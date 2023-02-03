package edu.ics211.h02;

import java.util.Random;

/**
 * The IBrewery interface. All good breweries should implement this interface.
 *
 * @author Cam Moore
 *
 */
public interface IBrewery {

  /**
   * Brews the beer with the given type. Note the returned instance is a subclass of beer.
   *
   * @param name the name of the beer.
   * @param type the type of the beer.
   * @return the beer.
   */
  Beer brewBeer(String name, BeerType type);


  /**
   * Brews a Pilsner with the given name, ibu and abv.
   *
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return a Pilsner.
   */
  Beer brewPilsner(String name, Integer ibu, Double abv);


  /**
   * Brews a Bohemian Pilsner with the given name, ibu and abv.
   *
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return a Bohemian Pilsner.
   */
  Beer brewBohemianPilsner(String name, Integer ibu, Double abv);


  /**
   * Brews an India Pale Ale with the given ibu and abv.
   *
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return an India Pale Ale.
   */
  Beer brewIndiaPaleAle(String name, Integer ibu, Double abv);


  /**
   * Returns a random beer type.
   * 
   * @return A random beer type.
   */
  public default BeerType randomBeerType() {
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