package edu.ics211.h10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Represents a ContactComparatorTest.
 *
 * @author Cam Moore
 *
 */
public class ContactComparatorTest {

  /**
   * Test method for ContactComparator#compare(Contact, Contact).
   */
  @Test
  public void testCompare() {
    Contact foo = new Contact("Foo", "Bar", "808-555-1234");
    Contact bar = new Contact("Bar", "Foo", "808-555-2345");
    Contact baz = new Contact("Baz", "Foo", "808-555-3456");
    ContactComparator c = new ContactComparator();
    assertTrue(c.compare(foo, bar) < 0);
    assertEquals(c.compare(baz, baz), 0);
    assertTrue(c.compare(baz, bar) > 0);
  }

}