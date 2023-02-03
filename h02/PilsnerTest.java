package edu.ics211.h02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test cases for Pilsner.
 *
 * @author Cam Moore
 *
 */
public class PilsnerTest {

  /**
   * Test method for {@link edu.ics211.h02.Pilsner#Pilsner(java.lang.String)}.
   */
  @Test
  public void testPilsnerString() {
    Pilsner pils = new Pilsner("My Best Pils");
    assertNotNull("Should have created a Pilsner", pils);
    assertEquals("Should have the right name", "My Best Pils", pils.getName());
    assertTrue("Should have valid ibu", pils.getIbu() > 24 && pils.getIbu() < 46);
    assertTrue("Should have valid abv", pils.getAbv() >= 4.2 && pils.getAbv() <= 6.0);
  }


  /**
   * Test method for {@link edu.ics211.h02.Pilsner#Pilsner
   * (java.lang.String, java.lang.Integer, java.lang.Double)}.
   */
  @Test
  public void testPilsnerStringIntegerDouble() {
    Pilsner pils = new Pilsner("My Monday Pils", 35, 5.0);
    assertNotNull("Should have created a Pilsner", pils);
    assertEquals("Should have the right name", "My Monday Pils", pils.getName());
    assertTrue("Should have the right ibu", 35 == pils.getIbu());
    assertEquals("Should have the right name", 5.0, pils.getAbv(), 0.0001);
    try {
      pils = new Pilsner("Bad, Bad, Bad", 100, 5.0);
      fail("Should not create a Pilsner with that IBU");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      pils = new Pilsner("Bad, Bad, Bad", 35, 10.0);
      fail("Should not create a Pilsner with that ABV");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#compareTo(edu.ics211.h02.Beer)}.
   */
  @Test
  public void testCompareTo() {
    Pilsner pils1 = new Pilsner("My Monday Pils", 35, 5.0);
    Pilsner pils2 = new Pilsner("My Tuesday Pils", 30, 4.5);
    assertTrue("pils1 should be less than pils2", pils1.compareTo(pils2) < 0);
    assertEquals("Comparing the same pilsner should return 0", 0, pils1.compareTo(pils1));
    assertTrue("pils2 should be greater than pils1", pils2.compareTo(pils1) > 0);
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#getName()}.
   */
  @Test
  public void testGetName() {
    Pilsner pils = new Pilsner("My Monday Pils", 35, 5.0);
    assertEquals("Should have the right name", "My Monday Pils", pils.getName());
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#setName(java.lang.String)}.
   */
  @Test
  public void testSetName() {
    Pilsner pils = new Pilsner("My Monday Pils", 35, 5.0);
    assertEquals("Should have the right name", "My Monday Pils", pils.getName());
    pils.setName("A better name");
    assertEquals("Should have the right name", "A better name", pils.getName());
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#getType()}.
   */
  @Test
  public void testGetType() {
    Pilsner pils = new Pilsner("My Best Pils");
    assertEquals("Should have the right type", BeerType.PILSNER, pils.getType());
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#getIbu()}.
   */
  @Test
  public void testGetIbu() {
    Pilsner pils = new Pilsner("My Monday Pils", 35, 5.0);
    assertEquals("Should have the right IBU", Integer.valueOf(35), pils.getIbu());
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#getAbv()}.
   */
  @Test
  public void testGetAbv() {
    Pilsner pils = new Pilsner("My Monday Pils", 35, 5.0);
    assertEquals("Should have the right ABV", Double.valueOf(5.0), pils.getAbv());
  }

}