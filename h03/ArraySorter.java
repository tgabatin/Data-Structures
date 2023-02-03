
package edu.ics211.h03;

import java.util.Comparator;

/**
 * Generic class that implements SortableArray interface.
 * 
 * @author Taylor D. Gabatino received help from Trevor Tejero (LA).
 * @param <E>
 *
 */
public class ArraySorter<E> implements SortsArray<E> {
  static double startTime;
  static double estimatedTime;
  static int comps;
  static int swaps;


  /**
   * Gets the number of swaps.
   * 
   * @return swaps
   */

  public int getNumberOfSwaps() {

    return swaps;
  }


  /**
   * Gets number of comparisons.
   * 
   * @return compss
   */

  public int getNumberOfComparisons() {

    return comps;
  }


  /**
   * Gets the sort time.
   * 
   * @return estimatedTime
   */

  public double getSortTime() {
    return estimatedTime;
  }


  /**
   * Sorts the data using the insertion sort method.
   * 
   * @param data the data being compared.
   * @param compare comparing methods of data.
   */

  @Override
  public void insertionSort(Comparator<E> compare, E[] data) {
    startTime = System.nanoTime();
    comps = 0;
    swaps = 0;
    for (int i = 1; i < data.length; i++) {
      E temp = data[i];
      int j = i;
      comps++;
      while (j > 0 && compare.compare(data[j - 1], temp) > 0) {
        data[j] = data[j - 1];
        j--;
        swaps++;
      }
      data[j] = temp;
    }
    double endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    System.out.println(estimatedTime);

  }


  /**
   * Sorts the data using the bubble sort method.
   * 
   * @param data the data being compared.
   * @param compare comparing methods of data.
   */

  @Override
  public void bubbleSort(Comparator<E> compare, E[] data) {
    comps = 0;
    swaps = 0;
    startTime = System.nanoTime();
    boolean exchange = false;
    int pass = 0;

    do {
      exchange = false;

      for (int i = 1; i < data.length - pass; i++) {
        int result = compare.compare(data[i - 1], data[i]);
        comps++;
        if (result > 0) {
          E temp = data[i];
          data[i] = data[i - 1];
          data[i - 1] = temp;
          exchange = true;
          swaps++;

        }
      }
      pass++;
    } while (exchange);
    double endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    System.out.println(estimatedTime);

  }


  /**
   * Sorts the data using the selection sort method.
   * 
   * @param data the data being compared.
   * @param compare comparing methods of the data.
   */
  @Override
  public void selectionSort(Comparator<E> compare, E[] data) {
    comps = 0;
    swaps = 0;
    startTime = System.nanoTime();
    int min;

    for (int i = 0; i < data.length; i++) {
      min = i;
      for (int j = i + 1; j < data.length; j++) {
        comps++;
        if (compare.compare(data[j], data[min]) < 0) {
          min = j;
          swaps++;
        }
      }
      E temp = data[min];
      data[min] = data[i];
      data[i] = temp;

    }
    double endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    System.out.println(estimatedTime);

  }

}
