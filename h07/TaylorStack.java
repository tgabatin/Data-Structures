package edu.ics211.h07;

import java.util.EmptyStackException;

/**
 * Represents a Stack that is a LinkedNode.
 * 
 * @author Taylor D. Gabatino received help from Cam Moore.
 * @param <E> the generic type.
 */
public class TaylorStack<E> {
  private LinkedNode top;


  /**
   * A constructor for the stack.
   */
  public TaylorStack() {
    this.top = null;

  }


  /**
   * Returns true if the stack is empty.
   * 
   * @return true if the stack is empty
   */
  public boolean empty() {
    return top == null;
  }


  /**
   * Pushes item onto the stack.
   * 
   * @param item the item
   * @return the item
   */
  E push(E item) {
    top = new LinkedNode(item, top);
    return item;
  }


  /**
   * Returns the top of the stack.
   * 
   * @return the top of the stack
   */
  E peek() {
    if (empty()) {
      throw new EmptyStackException();
    }
    return top.item;
  }


  /**
   * Remove the top of the stack.
   * 
   * @return the old top.
   */
  E pop() {
    if (empty()) {
      throw new EmptyStackException();
    }
    E ret = top.item;
    top = top.next;
    return ret;
  }

  /**
   * A linked node used to create a stack.
   * 
   * @author Taylor D. Gabatino
   *
   */
  private class LinkedNode {
    E item;
    LinkedNode next;


    public LinkedNode(E item, LinkedNode next) {
      this.item = item;
      this.next = next;
    }
  }

}