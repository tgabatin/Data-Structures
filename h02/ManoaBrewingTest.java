package edu.ics211.h02;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the ManoaBrewing class and Comparators.
 *
 * @author Cam Moore
 *
 */
public class ManoaBrewingTest {
  private ManoaBrewing brewer;


  /** Sets up the brewer. */
  @Before
  public void initialize() {
    brewer = ManoaBrewing.getInstance();
  }


  /**
   * Test for {@link edu.ics211.h01.ManoaBrewing#brewBeer(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testBrewBeer() {
    Beer beer = brewer.brewBeer("generic pilsner", BeerType.PILSNER);
    assertNotNull("Failed to brew beer", beer);
    assertTrue("Got wrong type of beer", beer instanceof Pilsner);
    assertTrue("Got wrong type of beer", beer.getType() == BeerType.PILSNER);
    assertTrue("Got wrong name", beer.getName().equals("generic pilsner"));
    beer = brewer.brewBeer("IPA", BeerType.INDIA_PALE_ALE);
    assertNotNull("Failed to brew beer", beer);
    assertTrue("Got wrong type of beer", beer instanceof IndiaPaleAle);
    assertTrue("Got wrong type of beer", beer.getType() == BeerType.INDIA_PALE_ALE);
    assertTrue("Got wrong name", beer.getName().equals("IPA"));
    beer = brewer.brewBeer("Rahpsody", BeerType.BOHEMIAN_PILSNER);
    assertNotNull("Failed to brew beer", beer);
    assertTrue("Got wrong type of beer", beer instanceof BohemianPilsner);
    assertTrue("Got wrong type of beer", beer.getType() == BeerType.BOHEMIAN_PILSNER);
    assertTrue("Got wrong name", beer.getName().equals("Rahpsody"));
  }


  /**
   * Test method for
   * {@link edu.ics211.h01.ManoaBrewing#brewPilsner
   * (java.lang.String, java.lang.Integer, java.lang.Double)}.
   */
  @Test
  public void testBrewPilsner() {
    Beer beer = brewer.brewPilsner("Manoa Mist", 30, 4.3);
    assertNotNull("Failed to brew Pilsner", beer);
    assertTrue("Didn't get a Pilsner", (beer instanceof Pilsner));
    try {
      beer = brewer.brewPilsner("Bad Pilsnser", -1, 10.3);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException iae) {
      // this should happen
    }
  }


  /**
   * Test method for
   * {@link edu.ics211.h01.ManoaBrewing#brewBohemianPilsner
   * (java.lang.String, java.lang.Integer, java.lang.Double)}.
   */
  @Test
  public void testBrewBohemianPilsner() {
    Beer beer = brewer.brewBohemianPilsner("Bohemian Sunset", 35, 5.3);
    assertNotNull("Failed to brew Bohemian Pilsner", beer);
    assertTrue("Didn't get a Bohemian Pilsner", (beer instanceof BohemianPilsner));
    try {
      beer = brewer.brewBohemianPilsner("Bad BohemianPilsnser", -1, 10.3);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException iae) {
      // this should happen
    }
  }


  /**
   * Test method for
   * {@link edu.ics211.h01.ManoaBrewing#brewIndiaPaleAle
   * (java.lang.String, java.lang.Integer, java.lang.Double)}.
   */
  @Test
  public void testBrewIndiaPaleAle() {
    Beer beer = brewer.brewIndiaPaleAle("Warrior IPA", 95, 7.3);
    assertNotNull("Failed to brew IPA", beer);
    assertTrue("Didn't get a IPA", (beer instanceof IndiaPaleAle));
    try {
      beer = brewer.brewIndiaPaleAle("Bad IPA", -1, 10.3);
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException iae) {
      // this should happen
    }
  }

}