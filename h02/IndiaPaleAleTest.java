package edu.ics211.h02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Represents a IndiaPaleAleTest.
 *
 * @author Taylor D. Gabatino Worked with Dylan (ATA). Helped Bradley Valiente with class.
 *
 */
public class IndiaPaleAleTest {

  /**
   * Tests the IndiaPaleAle(String name) constructor.
   */
  @Test
  public void testIndiaPaleAleString() {
    IndiaPaleAle pils = new IndiaPaleAle("Bohemian Rapsody");
    assertNotNull("Should have created a IndiaPaleAle", pils);
    assertEquals("Should have the right name", "Bohemian Rapsody", pils.getName());
    assertEquals("Should have the right BeerType", BeerType.INDIA_PALE_ALE, pils.getType());
    assertTrue("Should have valid ibu", pils.getIbu() > 40 && pils.getIbu() < 100);
    assertTrue("Should have valid abv", pils.getAbv() > 5.0 && pils.getAbv() < 10.0);

  }


  /**
   * Tests the IndiaPaleAle(String name, Integer ibu, Double abv) constructor.
   */
  @Test
  public void testIndiaPaleAleStringIntegerDouble() {
    Integer ibu = 99;
    Double abv = 9.9;
    IndiaPaleAle pils = new IndiaPaleAle("My Monday Pils", ibu, abv);
    assertNotNull("Should have created a Pilsner", pils);
    assertEquals("Wrong name", "My Monday Pils", pils.getName());
    assertEquals("Wrong BeerType", BeerType.INDIA_PALE_ALE, pils.getType());
    assertTrue("Wrong ibu", pils.getIbu() > 40 && pils.getIbu() < 100);
    assertTrue("Wrong abv", pils.getAbv() > 5.0 && pils.getAbv() < 10.0);
    try {
      ibu = 24; // too low
      pils = new IndiaPaleAle("Bad, Bad, Bad", ibu, abv);
      fail("Should not create a Pilsner with low IBU");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      ibu = 35; // low edge
      pils = new IndiaPaleAle("Edge case", ibu, abv);
      assertNotNull("Should have created a Pilsner", pils);
      assertEquals("Wrong BeerType", BeerType.INDIA_PALE_ALE, pils.getType());
      assertEquals("Wrong ibu", ibu, pils.getIbu());
      assertEquals("Wrong abv", abv, pils.getAbv(), 0.0001);
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      ibu = 46; // too high
      pils = new IndiaPaleAle("Bad, Bad, Bad", ibu, abv);

    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      ibu = 45; // high edge
      pils = new IndiaPaleAle("Edge case", ibu, abv);
      assertNotNull("Should have created a Pilsner", pils);
      assertEquals("Wrong BeerType", BeerType.INDIA_PALE_ALE, pils.getType());
      assertTrue("Wrong ibu", pils.getIbu() > 40 && pils.getIbu() < 100);
      assertTrue("Wrong abv", pils.getAbv() > 5.0 && pils.getAbv() < 10.0);
    } catch (IllegalArgumentException iae) {
      fail("IBU 45 is ok for Pilsner");
    }
    try {
      ibu = 35; // ok
      abv = 4.1; // too low
      pils = new IndiaPaleAle("Bad, Bad, Bad", ibu, abv);
      fail("Should not create a Pilsner with low ABV");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      abv = 4.2; // low edge
      pils = new IndiaPaleAle("Edge case", ibu, abv);
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      abv = 5.5; // too high
      pils = new IndiaPaleAle("Bad, Bad, Bad", ibu, abv);
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      abv = 5.4; // high edge
      ibu = 41;
      pils = new IndiaPaleAle("Edge case", ibu, abv);
      assertNotNull("Should have created a Pilsner", pils);
      assertEquals("Wrong BeerType", BeerType.INDIA_PALE_ALE, pils.getType());
      assertEquals("Wrong ibu", ibu, pils.getIbu());
      assertEquals("Wrong abv", abv, pils.getAbv(), 0.0001);
    } catch (IllegalArgumentException iae) {
      fail("ABV 6.0 is ok for Pilsner");
    }
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#compareTo(edu.ics211.h02.Beer)}.
   */
  @Test
  public void testCompareTo() {
    Integer ibu = 40;
    Double abv = 5.0;
    IndiaPaleAle pils1 = new IndiaPaleAle("My Monday Pils", ibu, abv);
    IndiaPaleAle pils2 = new IndiaPaleAle("My Tuesday Pils", 40, 5.1);
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
    IndiaPaleAle pils = new IndiaPaleAle("My Poorly Named Pils", 40, 5.0);
    assertEquals("Should have the right name", "My Poorly Named Pils", pils.getName());
    pils.setName("Best Pils");
    assertEquals("Should have the right name", "Best Pils", pils.getName());
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#getType()}.
   */
  @Test
  public void testGetType() {
    IndiaPaleAle pils = new IndiaPaleAle("My Poorly Named Pils");
    assertEquals("Should have the right type", BeerType.INDIA_PALE_ALE, pils.getType());
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#getIbu()}.
   */
  @Test
  public void testGetIbu() {
    IndiaPaleAle pils = new IndiaPaleAle("My Poorly Named Pils", 40, 5.0);
    assertEquals("Should have the right IBU", Integer.valueOf(40), pils.getIbu());
  }


  /**
   * Test method for {@link edu.ics211.h02.Beer#getAbv()}.
   */
  @Test
  public void testGetAbv() {
    IndiaPaleAle pils = new IndiaPaleAle("My Poorly Named Pils", 40, 5.0);
    assertEquals("Should have the right ABV", Double.valueOf(5.0), pils.getAbv());
  }

}