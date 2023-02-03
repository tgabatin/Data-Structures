package edu.ics211.h06;

import edu.ics211.h04.IList211;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Represents a Circular Doubly Linked list.
 * 
 * @author Taylor D. Gabatino received help from Dylan at Learning Emporium.
 *
 * @param <E> a generic type
 */
public class CircularDoublyLinkedList<E> implements IList211<E>, Iterable<E> {

  private DLinkedNode head;
  private DLinkedNode tail;
  private int size;


  /**
   * A constructor for CircularDoublyLinkedList.
   * @param items The generic type of items. 
   */
  public CircularDoublyLinkedList(E[] items) {
    this();
    for (E item : items) {
      add(item);
    }
  }


  /**
   *  The second constructor for CircularDoublyLinkedList.
   */
  public CircularDoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }


  /**
   * Creates a new instance of the MyListIterator inner class.
   * @return the new iterator list.
   */
  @Override
  public Iterator<E> iterator() {
    return new MyListIterator();
  }


  /**
   * Gets the object at the specified index.
   * @param index the index at which the object is to be called.
   */
  @Override
  public E get(int index) {
    checkIndex(index);
    DLinkedNode node = traverse(index);
    return node.item;
  }


  /**
   * A private inner class for CircularDoublyLinkedList.
   * @param index the index.
   * @return temp the DLinkedNode that is found at the traversed value.
   */
  private CircularDoublyLinkedList<E>.DLinkedNode traverse(int index) {
    DLinkedNode temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }


  /**
   * Checks the index, throws IndexOutOfBoundsException if incorrect.
   * @param index the index.
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

  }


  /**
   * Sets the object at specified index.
   * @param index the index at which the object is to be placed.
   * @param element the element to be placed at the specified index.
   * @return the value that was previously at element.
   */
  @Override
  public E set(int index, E element) {
    // checkIndex
    checkIndex(index);
    // traverse to index
    DLinkedNode node = traverse(index);
    E oldValue = node.item;
    node.item = element;
    return oldValue;
  }


  /**
   * Returns the index of the specified object.
   * @param obj the object that needs the index returned.
   */
  @Override
  public int indexOf(Object obj) {
    DLinkedNode temp = head;
    for (int index = 0; index < size; index++) {
      if (temp.item == obj) {
        return index;
      }
      temp = temp.next;
    }
    return -1;
  }


  /**
   * Returns the size of the list.
   */
  @Override
  public int size() {
    return this.size;
  }


  /**
   * Adds the element at the end of the list. 
   * @return true.
   */
  @Override
  public boolean add(E e) {
    add(size, e);
    return true;
  }


  /** Adds the object at the specified index.
   * @param index the index where the object is to be placed.
   * @param element the element to be placed at index.
   *
   */
  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (size == 0) {
      DLinkedNode newNode = new DLinkedNode(element, null, null);
      head = newNode;
      tail = newNode;
      head.prev = tail;
      tail.next = head;
    } else if (index == 0) {
      DLinkedNode newNode = new DLinkedNode(element, head, tail);
      head = newNode;
      tail.next = head;
    } else if (index == size) {
      DLinkedNode newNode = new DLinkedNode(element, head, tail);
      tail.next = newNode;
      tail = newNode;
      head.prev = tail;
    } else {
      DLinkedNode node = traverse(index - 1);
      DLinkedNode newNode = new DLinkedNode(element, node.next, node);
      node.next = newNode;
      newNode.next.prev = newNode;
    }
    size++;
  }


  /**
   * Removes the object at specified index.
   * @param index The position of the index where the object is to be removed.
   * @return the index of the object that is removed.
   */
  public E remove(int index) {
    checkIndex(index);
    E remembered = null;
    if (size == 1) {
      remembered = head.item;
      head = null;
      tail = null;
    } else if (index == 0) {
      remembered = head.item;
      head = head.next;
      head.prev = tail;

      tail.next = head;
    } else if (index == size - 1) {
      remembered = tail.item;
      tail = tail.prev;
      tail.next = head;
      head.prev = tail;
    } else {
      DLinkedNode node = traverse(index);
      node.next.prev = node.prev;
      node.prev.next = node.next;
      remembered = node.item;
    }
    size--;
    return remembered;
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

  /**
   * Represents a MyListIterator.
   *
   * @author Taylor D. Gabatino
   *
   */
  private class MyListIterator implements ListIterator<E> {

    private DLinkedNode nextNode;
    private DLinkedNode lastReturnedNode;
    private int nextIndex;


    /**
     *  A constructor for the list iterator.
     */
    public MyListIterator() {
      nextNode = head;
      lastReturnedNode = null;
      nextIndex = 0;
    }


    /**
     * Checks to see if the list has a next value. 
     * @return the size greater than zero.
     */
    @Override
    public boolean hasNext() {
      return size > 0;
    }


    /**
     * Checks to see if there is a next element, and returns the next remembered.
     * @return the value that is remembered at the next node.
     */
    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      lastReturnedNode = nextNode;
      E remembered = nextNode.item;
      nextNode = nextNode.next;
      nextIndex = (nextIndex + 1) % size;
      return remembered;
    }


    /**
     * Checks to see if the list has a previous value.
     * @return the size greater than zero.
     */
    @Override
    public boolean hasPrevious() {
      return size > 0;
    }


    /**
     * Checks to see if there is a previous element and returns the previous remembered.
     * @return the value that is remembered at the previous node.
     */
    @Override
    public E previous() {
      E remembered = null;
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      lastReturnedNode = nextNode.prev;
      remembered = nextNode.prev.item;
      nextNode = nextNode.prev;
      nextIndex = nextIndex - 1;
      if (nextIndex < 0) {
        nextIndex = size - 1;
      }
      return remembered;
    }


    /**
     * Returns the new index.
     * @return the new index after modulo size.
     */
    @Override
    public int nextIndex() {
      int newIndex = nextIndex % size;
      return newIndex;
    }


    /**
     * Checks to see if there is a next index and traverses to -1.
     * @return the value of the next index -1.
     */
    @Override
    public int previousIndex() {
      if (nextIndex == 0) {
        return size - 1;
      }
      return nextIndex - 1;
    }


    /**
     * Removed the value at the node specified.
     */
    public void remove() {
      if (lastReturnedNode == null) {
        throw new IllegalStateException();
      }
      DLinkedNode prev = lastReturnedNode.prev;
      prev.next = lastReturnedNode.next;
      lastReturnedNode.next.prev = prev;
      lastReturnedNode = null;
      size--;
    }


    /**
     * These methods are within the class purposely to pass the tests. 
     */
    @Override
    public void set(E e) {
      //This method is left blank purposely.
    }


    /**
     * These methods are within the class purposely to pass the tests.
     */
    @Override
    public void add(E e) {
      //This method is left blank purposely.
    }

  }
}
