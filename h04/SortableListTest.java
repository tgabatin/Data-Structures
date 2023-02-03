package edu.ics211.h04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/*The test written combines using a variation of strings and 
 *integers to test the methods in the SortableList class.
 *the SortableList class. The InsertionSort, SelectionSort, and BubbleSort were 
 *all tested using integers, and are very similar in the 
 *style of which I decided to run my tests. I decided to run the 
 *test with a comparator of two integers instead
 *of a variation of strings, so I would only need to create a separate class to test the 
 *comparators for it. As for the other following methods, I tested the get and set methods 
 *with different primitive types to determine if they would work with various
 *generic types, such as strings and ints that were thrown at it.
 */ 


/**
 * Represents a SortableListTest.
 *
 * @author Taylor D. Gabatino received help from Matthew Kirts and Michael Ito.
 *
 */
public class SortableListTest {

  SortableList<Integer> sl = new SortableList<Integer>();
  SortableList<String> ss = new SortableList<String>();

  private int[] inputArray = new int[3];


  /**
   * Tests that the list is created and can sort.
   */

  @Before
  public void testStortableList() {
    assertNotNull("I didn't create list", sl);
    assertEquals("Wrong size", 0, sl.size());
  }


  /**
   * Tests the insertion sort.
   */
  @Test
  public void testInsertionSort() {
    sl.add(4);
    sl.add(7);
    sl.add(13);
    sl.insertionSort(new IntegerComparator(null, null));
    assertEquals(sl.get(0), Integer.valueOf(4));
    assertEquals(sl.get(1), Integer.valueOf(7));
    assertEquals(sl.get(2), Integer.valueOf(13));

  }


  /**
   * Tests the bubble sort.
   */
  @Test
  public void testBubbleSort() {
    sl.add(7);
    sl.add(4);
    sl.add(13);
    sl.bubbleSort(new IntegerComparator(null, null));
    assertEquals(sl.get(0), Integer.valueOf(4));
    assertEquals(sl.get(1), Integer.valueOf(7));
    assertEquals(sl.get(2), Integer.valueOf(13));
  }


  /**
   * Tests the selection sort.
   */
  @Test
  public void testSelectionSort() {
    sl.add(7);
    sl.add(4);
    sl.add(13);
    sl.insertionSort(new IntegerComparator(null, null));
    assertEquals(sl.get(0), Integer.valueOf(4));
    assertEquals(sl.get(1), Integer.valueOf(7));
    assertEquals(sl.get(2), Integer.valueOf(13));
  }
  
  /**
   * .
   * Test the number of swaps
   * the next 3 methods were done alongside with Michael Ito
   */
  @Test
  public void testGetNumberOfSwaps() {
    sl.add(12);
    sl.add(15);
    sl.add(36);
    sl.add(74);
    sl.insertionSort(new IntegerComparator(null, null));
    assertEquals(sl.getNumberOfSwaps(), 0);
  }

  /**
   * Test the number of Comparisons.
   */
  @Test
  public void testGetNumberOfComparisons() {
    sl.add(12);
    sl.add(15);
    sl.add(36);
    sl.add(74);
    sl.insertionSort(new IntegerComparator(null, null));
    assertEquals(sl.getNumberOfComparisons(), 3);
  }


  /**
   * Test the sortTime for the sort.
   */
  @Test
  public void testGetSortTime() {
    sl.add(12);
    sl.add(15);
    sl.add(36);
    sl.add(74);
    sl.insertionSort(new IntegerComparator(null, null));
    assertNotNull(sl.getSortTime());
  }


  /**
   * Tests if method is able to get the value at index.
   */
  @Test
  public void testGet() {
    sl.add(7);
    sl.add(4);
    sl.add(13);
    assertEquals(sl.get(0), Integer.valueOf(7));
    assertEquals(sl.get(1), Integer.valueOf(4));
    assertEquals(sl.get(2), Integer.valueOf(13));
    try {
      sl.get(-1);
      fail("Didn't throw exception");
    } catch (IndexOutOfBoundsException exception) {
      try {
        sl.get(sl.size());
        fail("should throw exception");
      } catch (IndexOutOfBoundsException exceptions) {
        // This exception is desired.
      }

    }

  }


  /**
   * Test if you can set an element at a specified index.
   */
  @Test
  public void testSet() {
    ss.add("Cat");
    ss.add("Dog");
    try {
      ss.set(-1, "Dog");
      assertTrue("Dog".equals(ss.set(-1, "Dog")));
    } catch (IndexOutOfBoundsException e) {
      // This error is expected.
    }

    try {
      ss.set(ss.size() + -1, "Dog");
      assertTrue("Dog".equals(ss.set(ss.size() + -1, "Dog")));
    } catch (IndexOutOfBoundsException e) {
      // This error is expected.
    }
    String str = ss.get(0);
    assertEquals("Cat", str);
    str = ss.get(1);
    assertEquals("Dog", str);
  }


  /**
   * Tests if you can get the index.
   */
  @Test
  public void testindexOf() {
    ss.add("Dog");
    ss.add("Cat");
    ss.add("Hamster");
    assertTrue(0 == ss.indexOf("Dog"));
  }


  /**
   * Test method for returning the size of the generic array.
   */
  @Test
  public void testSize() {
    for (int i = 0; i < inputArray.length; i++) {
      sl.add(inputArray[i]);
    }
    assertTrue("Size should be 3", sl.size() == 3);
  }


  /**
   * Tests if you can add an element at the end of the list.
   */
  @Test
  public void testAddE() {
    for (int i = 0; i < inputArray.length; i++) {
      sl.add(inputArray[i]);
    }
    sl.add(17);
    assertTrue("Should be 4", sl.size() == 4);
  }


  /**
   * Tests if you can add an element at a specified index.
   */
  @Test
  public void testAddIntE() {
    for (int i = 0; i < inputArray.length; i++) {
      sl.add(inputArray[i]);
    }
    sl.add(1, 17);
    assertTrue("Should be 10", sl.get(1) == 17);
  }


  /**
   * Tests if the object at index can be removed.
   */
  @Test
  public void testRemove() {
    sl.add(1);
    sl.add(2);
    sl.add(3);
    try {
      sl.set(-1, 12);
      assertTrue(12 == sl.remove(-1));
    } catch (IndexOutOfBoundsException e) {
      // This error is expected.
    }
    try {
      sl.set(sl.size() + 1, 12);
      assertTrue(12 == sl.remove(sl.size() + 1));
    } catch (IndexOutOfBoundsException e) {
      // This error is expected.
    }
    assertEquals("Wrong size, expected size is 3", sl.size(), 3);
    assertTrue(sl.size() == 3);
    sl.remove(1);
    assertTrue(sl.size() == 2);
  }

}
