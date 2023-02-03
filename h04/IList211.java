package edu.ics211.h04;

/**
 * Interface for a List211.
 *
 * @author Cam Moore
 * @param <E> the generic type of the Lists.
 */
public interface IList211<E> {
  /**
   * Gets the item at the given index.
   * 
   * @param index the index.
   * @return the item at the given index.
   */
  E get(int index);


  /**
   * Sets the item at the given index.
   * 
   * @param index the index.
   * @param element the new element to set.
   * @return the old element at index.
   */
  E set(int index, E element);


  /**
   * Returns the index of the given obj or -1.
   * 
   * @param obj the object to find.
   * @return the index of the given obj or -1.
   */
  int indexOf(Object obj);


  /**
   * Returns the size of this list.
   * 
   * @return the size of this list.
   */
  int size();


  /**
   * Adds e to the end of the list.
   * 
   * @param e the item to add.
   * @return true if successful, false otherwise.
   */
  boolean add(E e);


  /**
   * Adds element to the list at the given index.
   * 
   * @param index the index.
   * @param element the element to add.
   */
  void add(int index, E element);


  /**
   * Removes the element at the given index.
   * 
   * @param index the index.
   * @return The element removed from the list.
   */
  E remove(int index);
}