package edu.ics211.h12;

import java.util.Comparator;

/**
 * A comparator that compares two potions.
 * @author Taylor D. Gabatino
 */
public class PotionComparator implements Comparator<Potion> {

  /**
   * Potion comparator needed for MediumPotionBag.
   * 
   * @param p1 potion 1
   * @param p2 potion 2
   * @return the difference of the hashcode. 
   */
  public int compare(Potion p1, Potion p2) {
    return p1.hashCode() - p2.hashCode();
  }
}