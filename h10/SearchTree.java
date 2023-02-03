package edu.ics211.h10;

/**
 * Represents a SearchTree.
 *
 * @author Cam Moore
 * @param <E> the type.
 */
public interface SearchTree<E> {
  /**
   * Inserts item into where it belongs in the tree.
   * 
   * @param item the item to add.
   * @return true if item is inserted, false if item is already in tree.
   */
  boolean add(E item);


  /**
   * Returns true if the item is in this SearchTree.
   * 
   * @param item the item to find.
   * @return true if item is in the tree, false otherwise.
   */
  boolean contains(E item);


  /**
   * Returns a reference to the target if it is in this SearchTree or null if it is not.
   * 
   * @param target the item to find.
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  E find(E target);


  /**
   * Removes target from the tree.
   * 
   * @param target the item to remove.
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  E delete(E target);


  /**
   * Removes target from the tree.
   * 
   * @param target the item to remove.
   * @return true if target was in the tree, false otherwise.
   */
  boolean remove(E target);
}