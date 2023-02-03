package edu.ics211.h04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Represents a SortableList.
 *
 * @author Taylor D. Gabatino received help from Carleton Moore.
 * @param <E> The type of the list.
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {

  private int size;
  private E[] data;
  int time;
  private int swaps;
  private int comps;
  private double startTime;
  private double estTime;


  /**
   * A sortable list.
   * 
   */
  @SuppressWarnings("unchecked")
  public SortableList() {
    this.data = (E[]) new Object[13];
    this.size = 0;
    this.swaps = 0;
    this.comps = 0;
    this.time = 0;
  }


  /**
   * Sorts the data using the insertion sort method.
   * 
   * @param compare comparing methods of the data.
   */
  @Override
  public void insertionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    comps = 0;
    swaps = 0;
    for (int i = 1; i < this.size; i++) {
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
    estTime = endTime - startTime;
    System.out.println(estTime);

  }


  /**
   * Sorts the data using the bubble sort method.
   * 
   * @param compare comparing methods of the data.
   */
  @Override
  public void bubbleSort(Comparator<E> compare) {
    comps = 0;
    swaps = 0;
    startTime = System.nanoTime();
    boolean exchange = false;
    int pass = 0;

    do {
      exchange = false;

      for (int i = 1; i < this.size - pass; i++) {
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
    estTime = endTime - startTime;
    System.out.println(estTime);

  }


  /**
   * Sorts the data using the selection sort method.
   * 
   * @param compare comparing methods of the data.
   */
  @Override
  public void selectionSort(Comparator<E> compare) {
    comps = 0;
    swaps = 0;
    startTime = System.nanoTime();
    int min;

    for (int i = 0; i < this.size; i++) {
      min = i;
      for (int j = i + 1; j < this.size; j++) {
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
    estTime = endTime - startTime;
    System.out.println(estTime);

  }


  /**
   * A method that returns the number of swaps.
   *
   */
  @Override
  public int getNumberOfSwaps() {
    return this.swaps;
  }


  /**
   * A method that returns the number of comparisons.
   *
   */
  @Override
  public int getNumberOfComparisons() {
    return this.comps;
  }


  /**
   * A method that returns the estimated time.
   *
   */
  @Override
  public double getSortTime() {
    return this.estTime;
  }


  /**
   * Checks the index of the array.
   * 
   * @param index the index.
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }


  /**
   * A method that gets the object at the given index.
   * 
   * @return the object at the given index.
   */
  @Override
  public E get(int index) {
    checkIndex(index);
    return data[index];
  }


  /**
   * A method that sets the element at the given index.
   * 
   * @return the new element to be set at the index.
   */
  @Override
  public E set(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    data[index] = element;
    return data[index];

  }


  /**
   * Returns the location of the object within the array.
   * 
   * @return the objects location within the array.
   */
  @Override
  public int indexOf(Object obj) {
    for (int i = 0; i < this.size; i++) {
      if (data[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }


  /**
   * Returns the size of the given list.
   * 
   * @return the size of the list.
   */
  public int size() {
    return this.size;
  }


  /**
   * A boolean method that adds an item to the end of the list.
   * 
   * @param e Reference to the element that needs to be added.
   * @return true.
   */
  public boolean add(E e) {
    add(size, e);
    return true;
  }


  /**
   * A method that adds an element at the given index.
   * 
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (this.size == data.length) {
      this.data = Arrays.copyOf(data, 2 * data.length);
    }
    for (int i = size; i >= index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = element;
    this.size++;
  }


  /**
   * A method that removes the element at the given index.
   * 
   * @return the element to be removed at the given index.
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    E temp = data[index];
    for (int i = index + 1; i < size; i++) {
      data[i] = data[i - 1];
    }
    size--;
    return temp;

  }

}
