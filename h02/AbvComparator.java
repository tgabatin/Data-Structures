package edu.ics211.h02;

import java.util.Comparator;

/**
 * Comparator, compares the abv values of two types of beers.
 * 
 * @author Taylor D. Gabatino
 *
 */

public class AbvComparator implements Comparator<Beer> {

  /**
   * compare, Compares the two beer abv values.
   * 
   * @param o1 the first beer to compare.
   * @param o2 the second beer to compare.
   * @return return 1 if o1 is greater, if not, then return 0.
   */
  public int compare(Beer o1, Beer o2) {
    if (o1.getAbv() > o2.getAbv()) {
      return 1;
    } else if (o1.getAbv() < o2.getAbv()) {
      return -1;
    }
    return 0;
  }

}