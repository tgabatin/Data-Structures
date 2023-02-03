package edu.ics211.h02;

import java.util.Random;

/**
 * Represents a Pilsner.
 *
 * @author Taylor D. Gabatino recieved help from Carleton Moore in class.
 *
 */
public class Pilsner extends Beer {

  /**
   * Pilsner, checks to see if the ibu and abv values are valid.
   * 
   * @param name the name of the type of beer.
   * @param ibu the ibu.
   * @param abv the abv.
   */
  public Pilsner(String name, Integer ibu, Double abv) {
    super(name, BeerType.PILSNER, ibu, abv);
    if (ibu < 25 || ibu > 45 || abv < 4.2 || abv > 6.0) {
      throw new IllegalArgumentException();
    }
  }


  /**
   * Pilsner, takes in the parameter name and type beer values.
   * 
   * @param name the name of the beer.
   * @param type the type of the beer.
   */
  protected Pilsner(String name, BeerType type) {
    super(name, type);
  }


  /**
   * Pilsner, takes in name of beer and generates a random ibu and abv.
   * 
   * @param name name of beer
   */

  public Pilsner(String name) {
    super(name, BeerType.PILSNER);
    Random rand = new Random();
    this.ibu = rand.nextInt(21) + 25;
    this.abv = rand.nextDouble() * 1.8 + 4.2;

  }


  /**
   * Pilsner, takes the method from abstract class beer.
   * 
   * @param name name of beer.
   * @param type the type of beer.
   * @param ibu the ibu amount.
   * @param abv the abv amount.
   */

  protected Pilsner(String name, BeerType type, Integer ibu, Double abv) {
    super(name, type, ibu, abv);
  }

}
