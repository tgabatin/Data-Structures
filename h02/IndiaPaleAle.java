package edu.ics211.h02;

import java.util.Random;

/**
 * Represents a IndiaPaleAle.
 *
 * @author Taylor D. Gabatino
 *
 */

public class IndiaPaleAle extends Beer {

  /**
   * IndiaPaleAle, checks the values of the ibu and abv.
   * 
   * @param name the name of the beer.
   * @param ibu the ibu amount.
   * @param abv the abv amount.
   */
  public IndiaPaleAle(String name, Integer ibu, Double abv) {
    super(name, BeerType.INDIA_PALE_ALE, ibu, abv);
    if (ibu < 40 || ibu > 100 || abv < 5.0 || abv > 10.0) {
      throw new IllegalArgumentException();
    }
  }


  /**
   * IndiaPaleAle, generates a random ibu and abv amount.
   * 
   * @param name the name of the beer.
   */
  public IndiaPaleAle(String name) {
    super(name, BeerType.INDIA_PALE_ALE);
    Random rand = new Random();
    this.ibu = rand.nextInt(100 + 1 - 40) + 40;
    this.abv = 5.0 + (10.0 - 5.0) * rand.nextDouble();
  }
}
