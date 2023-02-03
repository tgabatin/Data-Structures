package edu.ics211.h05;

import edu.ics211.h04.IList211;
import edu.ics211.h04.ISortableList;

import java.util.Comparator;

/**
 * Represents a SortableList.
 *
 * @author Taylor D. Gabatino received help from Carleton Moore in class. 
 * @param <E> A generic sortable list.
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {

  private DLinkedNode head;
  private DLinkedNode tail;
  private int size;
  private int swaps;
  private int comps;
  private double time;
  private double startTime;
  private double endTime;
  @SuppressWarnings("unused")
  private double estTime;
  private E[] data;


  /**
   * A constructor for the sortable list using linkedlists.
   */
  @SuppressWarnings("unchecked")
  public SortableList() {
    this.data = (E[]) new Object[13];
    this.head = null;
    this.size = 0;
    this.swaps = 0;
    this.comps = 0;
    this.time = 0.0;
  }


  /**
   * Sorts the linked list by the method of insertion sorting.
   */
  @Override
  public void insertionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comps = 0;

    DLinkedNode tempNode = head;
    for (int i = 0; i < size; i++) {
      data[i] = tempNode.item;
      tempNode = tempNode.next;
    }
    boolean doInsert = false;
    for (int newValue = 1; newValue < size; newValue++) {
      E nextValue = data[newValue];
      int indexCount = newValue;
      while (indexCount > 0 && compare.compare(nextValue, data[indexCount - 1]) < 0) {
        comps++;
        data[indexCount] = data[indexCount - 1];
        swaps++;
        indexCount--;
        doInsert = true;
      }
      if (doInsert) {
        data[indexCount] = nextValue;
      }
      if (indexCount > 0) {
        comps++;
      }
    }
    endTime = System.nanoTime();
    estTime = endTime - startTime;
    tempNode = head;
    for (int i = 0; i < size; i++) {
      tempNode.item = data[i];
      tempNode = tempNode.next;
    }

  }


  /**
   * Sorts the linked list by method of bubble sort.
   */
  @Override
  public void bubbleSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comps = 0;

    DLinkedNode tempNode = head;
    for (int i = 0; i < size; i++) {
      data[i] = tempNode.item;
      tempNode = tempNode.next;
    }
    boolean isSorted = true;
    int nextValue = 0;
    do {
      isSorted = false;
      for (int indexCount = 0; indexCount < size - 1 - nextValue; indexCount++) {
        if (compare.compare(data[indexCount], data[indexCount + 1]) > 0) {
          E temp = data[indexCount];
          data[indexCount] = data[indexCount + 1];
          data[indexCount + 1] = temp;
          swaps++;
          isSorted = true;
        }
        comps++;
      }
      nextValue++;  
    } while (isSorted);
    endTime = System.nanoTime();
    estTime = endTime - startTime;
    tempNode = head;
    for (int i = 0; i < size; i++) {
      tempNode.item = data[i];
      tempNode = tempNode.next;
    }

  }


  /**
   * Sorts the linked list by method of selection sort.
   */
  @Override
  public void selectionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comps = 0;
    DLinkedNode tempNode = head;
    for (int i = 0; i < size; i++) {
      data[i] = tempNode.item;
      tempNode = tempNode.next;
    }
    for (int fill = 0; fill < size - 1; fill++) {
      int posMin = fill;
      boolean doSwap = false;
      for (int next = fill + 1; next < size; next++) {
        if (compare.compare(data[next], data[posMin]) < 0) {
          posMin = next;
          doSwap = true;
        }
        comps++;
      }
      if (doSwap) {
        E temp = data[fill];
        data[fill] = data[posMin];
        data[posMin] = temp;
        swaps++;
      }
    }
    endTime = System.nanoTime();
    estTime = endTime - startTime;
    tempNode = head;
    for (int i = 0; i < size; i++) {
      tempNode.item = data[i];
      tempNode = tempNode.next;
    }

  }


  /**
   * Returns the number of swaps.
   */
  @Override
  public int getNumberOfSwaps() {
    return this.swaps;
  }


  /**
   * Returns the number of comparisons.
   */
  @Override
  public int getNumberOfComparisons() {
    return this.comps;
  }


  /**
   * Returns the amount of time it takes to sort.
   */
  @Override
  public double getSortTime() {
    return this.time;
  }


  /**
   * Returns the item that is in the specified index.
   * 
   * @param index the position of the item.
   * @return the item in the position.
   */
  @Override
  public E get(int index) {
    checkIndex(index);
    DLinkedNode temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp.item;
  }


  /**
   * Checks the specified index.
   * 
   * @param index the index that needs to be checked.
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

  }


  /**
   * Sets a specified element to the position at index.
   * 
   * @param index the position of the element.
   * @param element the element that is added at the specified index.
   * @return the old element at the index.
   */
  @Override
  public E set(int index, E element) {
    checkIndex(index);
    DLinkedNode temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    E oldItem = temp.item;
    temp.item = element;
    return oldItem;
  }


  /**
   * Finds the index of the object in parameters.
   * 
   * @param obj the object that is found within the list.
   * @return the position of the index of the items first appearance.
   */
  @Override
  public int indexOf(Object obj) {
    DLinkedNode temp = head;
    for (int i = 0; i < size; i++) {
      if (temp.item.equals(obj)) {
        return i;
      }
      temp = temp.next;
    }
    return -1;
  }


  /**
   * Returns the size of the linked list.
   * 
   * @return the size of the linked list.
   */
  @Override
  public int size() {
    return this.size;
  }


  /**
   * A boolean add method.
   * 
   * @param e the element to be added.
   * @return returns true.
   */
  @Override
  public boolean add(E e) {
    add(size, e);
    return true;
  }


  /**
   * Adds an element to the specified index.
   * 
   * @param index the position of the element to be added.
   * @param element the item to be added to the linked list.
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (size == 0) {
      head = new DLinkedNode(element, null, null);
      tail = head;
    } else if (index == 0) {
      head.prev = new DLinkedNode(element, head, null);
      head = head.prev;
    } else if (index == size) {
      tail.next = new DLinkedNode(element, null, tail);
      tail = tail.next;
    } else {
      DLinkedNode temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }
      temp.next = new DLinkedNode(element, temp.next, temp);
      temp.next.next.prev = temp.next;
    }
    size++;

  }


  /**
   * Removes the element at the specified position.
   * 
   * @param index the position of the element to be removed.
   */
  @Override
  public E remove(int index) {
    checkIndex(index);
    DLinkedNode temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    if (temp.prev == null) {
      head = temp.next;
    } else {
      temp.prev.next = temp.next;
    }
    if (temp.next != null) {
      temp.next.prev = temp.prev;
    }
    size--;
    return temp.item;

  }

  /**
   * Represents a DLinkedNode.
   *
   * @author Taylor D. Gabatino
   *
   */
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;


    public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }

}
