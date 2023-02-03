package edu.ics211.h06;

import edu.ics211.h02.Beer;

import java.util.List;

/**
 * Represents a IBeerTasting.
 *
 * @author Cam Moore
 *
 */
public interface IBeerTasting {

  /**
   * Returns a List of the beers in the order they were tasted. 
   * This method doesn't destroy the flight of beers.
   * 
   * @param start the position of where to start the tasting. This is a ones based index.
   * @param step the predetermined number for counting off.
   * @param isClockwise if true the counting occurs in a clockwise/increasing order. 
   *     If false the counting occurs in a
   *     counter clockwise/decreasing order.
   * @return A List of Beers in the order they were tasted.
   */
  List<Beer> tasteBeers(int start, int step, boolean isClockwise);
}