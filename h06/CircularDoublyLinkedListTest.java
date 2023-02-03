package edu.ics211.h06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import edu.ics211.h02.Beer;
import edu.ics211.h02.BeerType;
import edu.ics211.h02.ManoaBrewing;

import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

/**
 * Represents a CircularDoublyLinkedListTest.
 *
 * @author Cam Moore
 *
 */
public class CircularDoublyLinkedListTest {
  private CircularDoublyLinkedList<Beer> list;
  private ManoaBrewing brewing;
  private Beer[] beers;
  private static final int NUM_BEERS = 15;


  /**
   * Sets up the list for the CircularDoublyLinkedList.
   * @throws java.lang.Exception if there is a problem.
   */
  @Before
  public void setUp() throws Exception {
    list = new CircularDoublyLinkedList<Beer>();
    brewing = ManoaBrewing.getInstance();
    beers = new Beer[NUM_BEERS];
    for (int i = 0; i < NUM_BEERS; i++) {
      beers[i] = brewing.brewBeer("Beer" + i, randomBeerType());
    }
  }


  /**
   * Test method for CircularDoublyLinkedList.
   */
  @Test
  public void test() {
    assertEquals(0, list.size());
    list.add(beers[0]);
    assertEquals(1, list.size());
    assertEquals(list.get(0), beers[0]);
    list.add(beers[1]);
    assertEquals(2, list.size());
    assertEquals(list.get(1), beers[1]);
    list.add(0, beers[2]);
    assertEquals(3, list.size());
    assertEquals(list.get(0), beers[2]);
    try {
      list.add(4, beers[0]);
      fail("Should have thrown IndexOutOfBoundsException");
    } catch (IndexOutOfBoundsException iob) {
      try {
        list.add(-1, beers[0]);
        fail("Should have thrown IndexOutOfBoundsException");
      } catch (IndexOutOfBoundsException iobe) {
        // this is ok
      }
    }
    list.add(3, beers[3]);
    assertEquals(4, list.size());
    assertEquals(list.get(3), beers[3]);
    try {
      list.set(-1, beers[0]);
      fail("Should have thrown IndexOutOfBoundsException");
    } catch (IndexOutOfBoundsException iob) {
      try {
        assertFalse(list.get(-1).equals(beers[0]));
        fail("Should have thrown IndexOutOfBoundsException");
      } catch (IndexOutOfBoundsException iobe) {
        // this is ok
      }
    }
    assertEquals(list.set(0, beers[10]), beers[2]);
    assertEquals(list.get(0), beers[10]);
  }


  /**
   * Test method for {@link edu.ics211.h05.CircularDoublyLinkedList#indexOf(java.lang.Object)}.
   */
  @Test
  public void testIndexOf() {
    assertEquals(list.indexOf(beers[9]), -1);
    list.add(beers[0]);
    assertEquals(list.indexOf(beers[0]), 0);
    assertEquals(list.indexOf(beers[9]), -1);
    list.add(beers[1]);
    assertEquals(list.indexOf(beers[1]), 1);
    assertEquals(list.indexOf(beers[9]), -1);
    list.add(0, beers[3]);
    assertEquals(list.indexOf(beers[3]), 0);
    assertEquals(list.indexOf(beers[1]), 2);
    assertEquals(list.indexOf(beers[9]), -1);
  }


  /**
   * Test method for {@link edu.ics211.h05.CircularDoublyLinkedList#iterator()}.
   */
  @Test
  public void testIterator() {
    ListIterator<Beer> iter = (ListIterator<Beer>) list.iterator();
    assertNotNull(iter);
    assertFalse(iter.hasNext());
    assertFalse(iter.hasPrevious());
    list.add(beers[0]);
    iter = (ListIterator<Beer>) list.iterator();
    assertNotNull(iter);
    assertTrue(iter.hasNext());
    assertTrue(iter.hasPrevious());
    assertEquals(iter.nextIndex(), 0);
    assertEquals(iter.previousIndex(), 0);
    Beer b = iter.next();
    assertNotNull(b);
    assertEquals(b, beers[0]);
    assertTrue(iter.hasNext());
    assertTrue(iter.hasPrevious());
    assertEquals(iter.nextIndex(), 0);
    assertEquals(iter.previousIndex(), 0);
    b = iter.previous();
    assertNotNull(b);
    assertEquals(b, beers[0]);
    assertTrue(iter.hasNext());
    assertTrue(iter.hasPrevious());
    assertEquals(iter.nextIndex(), 0);
    assertEquals(iter.previousIndex(), 0);
    list.add(beers[1]);
    iter = (ListIterator<Beer>) list.iterator();
    assertEquals(iter.nextIndex(), 0);
    assertEquals(iter.previousIndex(), 1);
    b = iter.next();
    assertEquals(iter.nextIndex(), 1);
    assertEquals(iter.previousIndex(), 0);
    assertEquals(b, beers[0]);
    b = iter.next();
    assertEquals(b, beers[1]);
    b = iter.next();
    assertEquals(b, beers[0]);
    b = iter.previous();
    assertEquals(b, beers[0]);
    b = iter.previous();
    assertEquals(b, beers[1]);
    iter.remove();
    assertEquals(list.size(), 1);
    assertTrue(iter.hasNext());
    assertTrue(iter.hasPrevious());
    assertEquals(iter.nextIndex(), 0);
    assertEquals(iter.previousIndex(), 0);
  }


  private BeerType randomBeerType() {
    int val = (int) (Math.random() * 3);
    switch (val) {
      case 0:
        return BeerType.PILSNER;
      case 1:
        return BeerType.BOHEMIAN_PILSNER;
      case 2:
        return BeerType.INDIA_PALE_ALE;
      default:
        return BeerType.INDIA_PALE_ALE;
    }
  }

}