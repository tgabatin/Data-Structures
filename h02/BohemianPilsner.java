package edu.ics211.h02;

import java.util.Random;

/**
 * Represents a BohemianPilsner, a subclass of Pilsner.
 *
 * @author Taylor D. Gabatino
 *
 */
public class BohemianPilsner extends Pilsner {

  /**
   * BohemianPilsner, checks the name, ibu, and abv.
   * 
   * @param name the name of the beer.
   * @param ibu the ibu amount.
   * @param abv the abv amount.
   */

  public BohemianPilsner(String name, Integer ibu, Double abv) {
    super(name, BeerType.BOHEMIAN_PILSNER, ibu, abv);
    if (ibu < 35 || ibu > 45 || abv < 4.2 || abv > 5.4) {
      throw new IllegalArgumentException();
    }
  }


  /**
   * BohemianPilsner, takes in the name and returns a random ibu and abv.
   * 
   * @param name the name of the beer.
   */

  public BohemianPilsner(String name) {
    super(name, BeerType.BOHEMIAN_PILSNER);
    Random rand = new Random();
    this.ibu = rand.nextInt(45 + 1 - 35) + 35;
    this.abv = 4.2 + (5.4 - 4.2) * rand.nextDouble();
  }

}
