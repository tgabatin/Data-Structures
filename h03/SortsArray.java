package edu.ics211.h03;

import java.util.Comparator;

/**
 * Interface for a SortableArray.
 * 
 * @author Cam Moore
 * @param <E> the type of the data.
 */
public interface SortsArray<E> {

  /**
   * Sorts the array data using the insertion sort.
   * @param compare the Comparator that determines order.
   * @param data the data.
   */
  void insertionSort(Comparator<E> compare, E[] data);


  /**
   * Sorts the array data using the bubble sort.
   * @param compare the Comparator that determines order.
   * @param data the data.
   */
  void bubbleSort(Comparator<E> compare, E[] data);


  /**
   * Uses the selection sort algorithm to sort the data array.
   * @param compare a Comparator.
   * @param data the data to sort.
   */
  void selectionSort(Comparator<E> compare, E[] data);


  /**
   * Returns the number of swaps for the last sort.
   * 
   * @return the number of swaps for the last sort.
   */
  int getNumberOfSwaps();


  /**
   * Returns the number of comparisons for the last sort.
   * 
   * @return the number of comparisons for the last sort.
   */
  int getNumberOfComparisons();


  /**
   * Returns the time it took to sort.
   * 
   * @return the time it took to sort.
   */
  double getSortTime();
}