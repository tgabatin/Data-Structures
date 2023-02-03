package edu.ics211.h10;

import java.util.List;

/**
 * Represents a InOrder.
 *
 * @author Cam Moore
 * @param <E> the generic type.
 */
public interface InOrder<E> {
  /**
   * Returns the items in sorted order.
   * 
   * @return The items in sorted order.
   */
  List<E> inorder();
}