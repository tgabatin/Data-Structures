package edu.ics211.h04;

import java.util.Comparator;

/**
 * Interface for a SortableList.
 *
 * @author Cam Moore
 * @param <E> generic type.
 */
public interface ISortableList<E> {
  /**
   * Sorts the list using the insertion sort.
   * 
   * @param compare a Comparator that determines order.
   */
  void insertionSort(Comparator<E> compare);


  /**
   * Sorts the list using the bubble sort.
   * 
   * @param compare a Comparator that determines order.
   */
  void bubbleSort(Comparator<E> compare);


  /**
   * Sorts the list using the selection sort.
   * 
   * @param compare a Comparator that determines order.
   */
  void selectionSort(Comparator<E> compare);


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
   * Returns the time it took to sort the list.
   * 
   * @return the time it took to sort the list.
   */
  double getSortTime();
}