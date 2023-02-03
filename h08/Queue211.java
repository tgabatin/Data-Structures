
package edu.ics211.h08;

/**
 * Represents a Queue211.
 *
 * @author Cam Moore
 * @param <E> the generic type.
 */
public interface Queue211<E> {
  /**
   * Adds e to the end of the queue. May throw an IllegalStateException if the queue is full.
   * 
   * @param e the item to add.
   * @return true if successful.
   */
  boolean add(E e);


  /**
   * Retrieves, but doesn't remove the head of the queue.
   * Throws NoSuchElementException if queue is empty.
   * 
   * @return the head of the queue.
   * @throws NoSuchElementException if queue is empty.
   */
  E element();


  /**
   * Adds e to the end of the queue. Returns false if the queue is full.
   * 
   * @param e the item to add.
   * @return true if successful, false otherwise.
   */
  boolean offer(E e);


  /**
   * Returns the front of this queue without removing the front item.
   * 
   * @return The front of this queue.
   */
  E peek();


  /**
   * Removes and returns the front of this queue.
   * 
   * @return The front of this queue, removing that item.
   */
  E poll();


  /**
   * Removes and returns the front of this queue.
   * 
   * @return The front of this queue, removing that item.
   */
  E remove();


  /**
   * Returns the size of this queue.
   * 
   * @return The size of this queue.
   */
  int size(); // Returns the size of the queue.
}