package edu.ics211.h04;

import java.util.Comparator;

/**
 * Represents a IntegerComparator.
 *
 * @author Taylor D. Gabatino received help from Carleton Moore.
 *
 */
public class IntegerComparator implements Comparator<Integer> {

  Integer o1;
  Integer o2;


  /**
   * Compares two integers.
   * 
   * @param o1 the first integer type to be compared.
   * @param o2 the second integer type to be compared.
   */
  public IntegerComparator(Integer o1, Integer o2) {
    this.o1 = o1;
    this.o2 = o2;
  }


  /**
   * Returns the difference of the integers compared.
   */
  @Override
  public int compare(Integer o1, Integer o2) {
    return o1 - o2;
  }
}
