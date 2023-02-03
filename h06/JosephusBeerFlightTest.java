package edu.ics211.h06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.ics211.h02.Beer;
import edu.ics211.h02.BeerType;
import edu.ics211.h02.ManoaBrewing;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * Represents a JosephusBeerFlightTest.
 *
 * @author Cam Moore
 *
 */
public class JosephusBeerFlightTest {

  private ManoaBrewing brewery;
  private Beer[] flight = new Beer[7];


  /**
   * Sets up the tests.
   * 
   * @throws Exception if there is a problem.
   */
  @Before
  public void setUp() throws Exception {
    brewery = ManoaBrewing.getInstance();
    for (int i = 0; i < flight.length; i++) {
      flight[i] = brewery.brewBeer("Beer" + i, randomBeerType());
    }
  }


  /**
   * Tests the tasteBeers method.
   */
  @Test
  public void testTastBeers() {
    JosephusBeerFlight beerFlight = new JosephusBeerFlight(flight);
    List<Beer> tasting = beerFlight.tasteBeers(1, 3, true);
    assertTrue(tasting.size() == flight.length);
    assertEquals(tasting.get(0), flight[2]);
    assertEquals(tasting.get(1), flight[5]);
    assertEquals(tasting.get(2), flight[1]);
    assertEquals(tasting.get(3), flight[6]);
    assertEquals(tasting.get(4), flight[4]);
    assertEquals(tasting.get(5), flight[0]);
    assertEquals(tasting.get(6), flight[3]);
    tasting = beerFlight.tasteBeers(4, 2, false);
    assertTrue(tasting.size() == flight.length);
    assertEquals(tasting.get(0), flight[2]);
    assertEquals(tasting.get(1), flight[0]);
    assertEquals(tasting.get(2), flight[5]);
    assertEquals(tasting.get(3), flight[3]);
    assertEquals(tasting.get(4), flight[6]);
    assertEquals(tasting.get(5), flight[1]);
    assertEquals(tasting.get(6), flight[4]);
    tasting = beerFlight.tasteBeers(1, 1, false);
    assertTrue(tasting.size() == flight.length);
    assertEquals(tasting.get(0), flight[0]);
    assertEquals(tasting.get(1), flight[6]);
    assertEquals(tasting.get(2), flight[5]);
    assertEquals(tasting.get(3), flight[4]);
    assertEquals(tasting.get(4), flight[3]);
    assertEquals(tasting.get(5), flight[2]);
  }


  /**
   * Returns a random beer type.
   * 
   * @return A random beer type.
   */
  public BeerType randomBeerType() {
    Random r = new Random();
    int val = r.nextInt(3);
    switch (val) {
      case 0:
        return BeerType.PILSNER;
      case 1:
        return BeerType.BOHEMIAN_PILSNER;
      case 2:
        return BeerType.INDIA_PALE_ALE;
      default:
        return BeerType.INDIA_PALE_ALE;
    }
  }

}