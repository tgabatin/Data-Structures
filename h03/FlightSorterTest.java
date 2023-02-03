package edu.ics211.h03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.ics211.h02.AbvComparator;
import edu.ics211.h02.Beer;
import edu.ics211.h02.IbuComparator;
import edu.ics211.h02.ManoaBrewing;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;


/**
 * Represents a FlightSorterTest.
 *
 * @author Cam Moore
 *
 */
public class FlightSorterTest {

  private ArraySorter<Beer> sorter;
  private ManoaBrewing brewery;
  private Beer[] shortFlight;
  private Beer[] longFlight;
  private Beer[] veryLongFlight;
  private IbuComparator ibuC;
  private AbvComparator abvC;

  /** Sets up the brewer. */
  @Before
  public void initialize() {
    sorter = new ArraySorter<Beer>();
    brewery = ManoaBrewing.getInstance();
    ibuC = new IbuComparator();
    abvC = new AbvComparator();
    shortFlight = new Beer[5];
    for (int i = 0; i < shortFlight.length; i++) {
      shortFlight[i] = brewery.brewBeer("short beer" + i, brewery.randomBeerType());
    }
    longFlight = new Beer[1000];
    for (int i = 0; i < longFlight.length; i++) {
      longFlight[i] = brewery.brewBeer("long beer" + i, brewery.randomBeerType());
    }
    veryLongFlight = new Beer[15000];
    for (int i = 0; i < veryLongFlight.length; i++) {
      veryLongFlight[i] = brewery.brewBeer("very long beer" + i, brewery.randomBeerType());
    }
  }


  /**
   * Test method for {@link edu.ics211.h03.ArraySorter#insertionSort(java.util.Comparator, E[])}.
   */
  @Test
  public void testInsertionSort() {
    Beer[] copy = Arrays.copyOf(shortFlight, shortFlight.length);
    sorter.insertionSort(ibuC, copy);
    final double shortTime = sorter.getSortTime();
    assertTrue("Flight isn't sorted", isSorted(copy, ibuC));
    sorter.insertionSort(ibuC, copy);
    assertEquals("Wrong number of comparisons",
        sorter.getNumberOfComparisons(), shortFlight.length - 1);
    assertEquals("Wrong number of swaps", sorter.getNumberOfSwaps(), 0);
    sorter.insertionSort(abvC, copy);
    assertTrue("Flight isn't sorted", isSorted(copy, abvC));
    assertTrue("Wrong number of comparisons", sorter.getNumberOfComparisons()
        >= shortFlight.length - 1);
    sorter.insertionSort(abvC, copy);
    assertEquals("Wrong number of comparisons",
        sorter.getNumberOfComparisons(), shortFlight.length - 1);
    assertEquals("Wrong number of swaps", sorter.getNumberOfSwaps(), 0);
    copy = Arrays.copyOf(longFlight, longFlight.length);
    sorter.insertionSort(abvC, copy);
    final double longTime = sorter.getSortTime();
    assertTrue("Bad timing", longTime > shortTime);
    copy = Arrays.copyOf(veryLongFlight, veryLongFlight.length);
    sorter.insertionSort(abvC, copy);
    final double veryLongTime = sorter.getSortTime();
    assertTrue("Bad timing", veryLongTime > longTime);
  }


  /**
   * Test method for {@link edu.ics211.h03.ArraySorter#bubbleSort(java.util.Comparator, E[])}.
   */
  @Test
  public void testBubbleSort() {
    Beer[] copy = Arrays.copyOf(shortFlight, shortFlight.length);
    sorter.bubbleSort(ibuC, copy);
    final double shortTime = sorter.getSortTime();
    assertTrue("Flight isn't sorted", isSorted(copy, ibuC));
    sorter.bubbleSort(ibuC, copy);
    assertEquals("Wrong number of comparisons",
        sorter.getNumberOfComparisons(), shortFlight.length - 1);
    assertEquals("Wrong number of swaps", sorter.getNumberOfSwaps(), 0);
    sorter.bubbleSort(abvC, copy);
    assertTrue("Flight isn't sorted", isSorted(copy, abvC));
    assertTrue("Wrong number of comparisons", sorter.getNumberOfComparisons()
        >= shortFlight.length - 1);
    sorter.bubbleSort(abvC, copy);
    assertEquals("Wrong number of comparisons",
        sorter.getNumberOfComparisons(), shortFlight.length - 1);
    assertEquals("Wrong number of swaps", sorter.getNumberOfSwaps(), 0);
    copy = Arrays.copyOf(longFlight, longFlight.length);
    sorter.bubbleSort(abvC, copy);
    final double longTime = sorter.getSortTime();
    assertTrue("Bad timing", longTime > shortTime);
    copy = Arrays.copyOf(veryLongFlight, veryLongFlight.length);
    sorter.bubbleSort(abvC, copy);
    final double veryLongTime = sorter.getSortTime();
    assertTrue("Bad timing", veryLongTime > longTime);
  }


  /**
   * Test method for {@link edu.ics211.h03.ArraySorter#selectionSort(java.util.Comparator, E[])}.
   */
  @Test
  public void testSelectionSort() {
    Beer[] copy = Arrays.copyOf(shortFlight, shortFlight.length);
    sorter.selectionSort(ibuC, copy);
    final double shortTime = sorter.getSortTime();
    assertTrue("Flight isn't sorted", isSorted(copy, ibuC));
    sorter.selectionSort(ibuC, copy);
    assertEquals("Wrong number of comparisons",
        sorter.getNumberOfComparisons(), (4 + 3 + 2 + 1));
    assertEquals("Wrong number of swaps", sorter.getNumberOfSwaps(), 0);
    sorter.selectionSort(abvC, copy);
    assertTrue("Flight isn't sorted", isSorted(copy, abvC));
    assertTrue("Wrong number of comparisons", sorter.getNumberOfComparisons()
        >= shortFlight.length - 1);
    sorter.selectionSort(abvC, copy);
    assertEquals("Wrong number of comparisons",
        sorter.getNumberOfComparisons(), (4 + 3 + 2 + 1));
    assertEquals("Wrong number of swaps", sorter.getNumberOfSwaps(), 0);
    copy = Arrays.copyOf(longFlight, longFlight.length);
    sorter.selectionSort(abvC, copy);
    final double longTime = sorter.getSortTime();
    assertTrue("Bad timing", longTime > shortTime);
    copy = Arrays.copyOf(veryLongFlight, veryLongFlight.length);
    sorter.selectionSort(abvC, copy);
    final double veryLongTime = sorter.getSortTime();
    assertTrue("Bad timing", veryLongTime > longTime);
  }

  /**
   * Tests the times for sorting sorted arrays.
   */
  @Test
  public void testCompareSortTimes() {
    Beer[] copy = Arrays.copyOf(veryLongFlight, veryLongFlight.length);
    sorter.insertionSort(abvC, copy);
    sorter.insertionSort(abvC, copy);
    final double insertionTime = sorter.getSortTime();
    copy = Arrays.copyOf(veryLongFlight, veryLongFlight.length);
    sorter.bubbleSort(abvC, copy);
    sorter.bubbleSort(abvC, copy);
    final double bubbleTime = sorter.getSortTime();
    copy = Arrays.copyOf(veryLongFlight, veryLongFlight.length);
    sorter.selectionSort(abvC, copy);
    sorter.selectionSort(abvC, copy);
    final double selectionTime = sorter.getSortTime();
    assertTrue("Not BigO(N)", bubbleTime < selectionTime);
    assertTrue("Not BigO(N)", insertionTime < selectionTime);
  }

  private boolean isSorted(Beer[] data, Comparator<Beer> comp) {
    for (int i = 0; i < data.length - 1; i++) {
      if (comp.compare(data[i], data[i + 1]) > 0) {
        return false;
      }
    }
    return true;
  }

}