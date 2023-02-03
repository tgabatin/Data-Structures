package edu.ics211.h08;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A CircularArrayQueue class.
 * 
 * @author Taylor D. Gabatino received help from Cam Moore.
 * @param <E> is the given data.
 */
public class CircularArrayQueue<E> implements Queue211<E> {

  private int front;
  private int rear;
  private int size;
  private E[] data;


  /**   
   * Constructor for the class.
   */
  @SuppressWarnings("unchecked")
  public CircularArrayQueue() {
    // TODO Auto-generated constructor stub
    this.data = (E[]) new Object[1];
    this.front = rear;
    this.rear = data.length - 1;
    this.size = 0;

  }

  /**
   * Creates private class Iter that implements Iterator interface.
   * @author Taylor D. Gabatino
   */
  @SuppressWarnings("unused")
  private class Iter implements Iterator<E> {
    private int index;
    private int count;


    public Iter() {
      this.index = front;
    }


    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
      return count < size;
    }


    @Override
    public E next() {
      // TODO Auto-generated method stub
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E result = data[index];
      index = (index + 1) % data.length;
      count++;
      return result;
    }

  }


  @Override
  public boolean add(E e) {
    // TODO Auto-generated method stub
    if (size == data.length) {
      reallocate();
    }
    rear = (rear + 1) % data.length;
    data[rear] = e;
    size++;
    return true;
  }


  @Override
  public E element() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[front];
  }


  @Override
  public boolean offer(E e) {
    // TODO Auto-generated method stub
    try {
      return add(e);
    } catch (IllegalStateException ise) {
      return false;
    }
  }


  @Override
  public E peek() {
    // TODO Auto-generated method stub
    try {
      return element();

    } catch (NoSuchElementException nse) {
      return null;
    }
  }


  @Override
  public E poll() {
    // TODO Auto-generated method stub
    try {
      return remove();

    } catch (NoSuchElementException nse) {
      return null;
    }
  }


  @Override
  public E remove() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new NoSuchElementException();

    }
    E value = data[front];
    front = (front + 1) % data.length;
    size--;
    return value;
  }


  /**
   * Returns the size.
   * 
   * @return size
   */
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }


  @SuppressWarnings("unchecked")
  private void reallocate() {
    E[] newData = (E[]) new Object[2 * data.length];
    int j = front;
    for (int i = 0; i < size; i++) {
      newData[i] = data[j];
      j = (j + 1) % data.length;
    }
    front = 0;
    rear = size - 1;
    data = newData;
  }

}
