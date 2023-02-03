package edu.ics211.h10;

import java.util.Comparator;

/**
 * A ContactComparator class.
 * @author Taylor D. Gabatino
 *
 */
public class ContactComparator implements Comparator<Contact> {

  /**
   * Compares the contacts's name.
   * 
   * @param o1 the first object to compare with.
   * @param o2 the second object to compare with.
   * @return an integer depending on the argument conclusion
   */
  @Override
  public int compare(Contact o1, Contact o2) {
    int lastNameComp = o1.getLastName().compareToIgnoreCase(o2.getLastName());
    if (lastNameComp == 0) {
      return o1.getFirstName().compareTo(o2.getFirstName());
    }
    return lastNameComp;
  }
}
