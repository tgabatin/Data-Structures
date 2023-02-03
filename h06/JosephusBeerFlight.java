package edu.ics211.h06;

import edu.ics211.h02.Beer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * .
 * 
 * @author Taylor D. Gabatino received help from Dylan at Learning Emporium.
 * 
 *
 */
public class JosephusBeerFlight implements IBeerTasting {
  private Beer[] myBeer;


  /**
   * public class JosephusBeerFlight.
   * 
   * @param myBeer beer
   */
  public JosephusBeerFlight(Beer[] myBeer) {
    this.myBeer = myBeer;
  }


  /**
   * Returns a list of the beers in the order they were tasted.
   * @param start the position of where to start the tasting. This is a ones based index.
   * @param step the predetermined number for counting off.
   * @param isClockwise isClockwise if true the counting occurs in a clockwise/increasing order. 
   *     If false the counting occurs in a
   *     counter clockwise/decreasing order.
   * @return a list of beers in the order they were tasted.
   */
  @Override
  public List<Beer> tasteBeers(int start, int step, boolean isClockwise) {
    CircularDoublyLinkedList<Beer> list = new CircularDoublyLinkedList<Beer>(myBeer);
    ArrayList<Beer> tastedBeers = new ArrayList<Beer>();
    ListIterator<Beer> iterator = (ListIterator<Beer>) list.iterator();
    Beer beer = null;
    if (isClockwise == true) {
      for (int i = 0; i < start - 1; i++) {
        iterator.next();
      }
      while (iterator.hasNext() == true) {
        for (int i = 0; i < step; i++) {
          beer = iterator.next();
        }
        tastedBeers.add(beer);
        iterator.remove();
      }
      return tastedBeers;
    } else {
      for (int i = 0; i < start; i++) {
        iterator.next();
      }
      while (iterator.hasPrevious() == true) {
        for (int i = 0; i < step; i++) {
          beer = iterator.previous();
        }
        tastedBeers.add(beer);
        iterator.remove();
      }
      return tastedBeers;
    }
  }
}