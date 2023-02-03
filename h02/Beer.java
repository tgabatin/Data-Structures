package edu.ics211.h02;

/**
 * Represents a Beer.
 *
 * @author Taylor
 *
 */
public abstract class Beer implements Comparable<Beer> {
  private String name;
  private BeerType type;
  protected Integer ibu;
  protected Double abv;


  /**
   * Beer, takes in the name and the type of beer.
   * 
   * @param name the name of the beer.
   * @param type the type of the beer.
   */

  public Beer(String name, BeerType type) {
    super();
    this.name = name;
    this.type = type;
  }


  /**
   * Beer, takes in the name, ibu, and abv of the beer.
   * 
   * @param name the name of the beer.
   * @param ibu the ibu amount.
   * @param abv the abv amount.
   */

  public Beer(String name, Integer ibu, Double abv) {
    super();
    this.name = name;
    this.ibu = ibu;
    this.abv = abv;
  }


  /**
   * Beer, takes in the name, type, ibu, and abv.
   * 
   * @param name the name of the beer.
   * @param type the type of the beer.
   * @param ibu the ibu amount.
   * @param abv the abv amount.
   */

  public Beer(String name, BeerType type, Integer ibu, Double abv) {
    super();
    this.name = name;
    this.type = type;
    this.ibu = ibu;
    this.abv = abv;
  }


  /**
   * compareTo, returns the name of the beers that are being compared.
   * 
   * @param otherBeer the beer that is being compared.
   */
  @Override
  public int compareTo(Beer otherBeer) {
    return this.name.compareTo(otherBeer.name);
  }


  /**
   * BeerType, gets and returns the type of beer.
   * 
   * @return the type
   */
  public BeerType getType() {
    return type;
  }


  /**
   * getName, gets and returns the name of beer.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }


  /**
   * setName, sets the name of the beer.
   * 
   * @param name the name of the beer.
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * getIbu, returns the ibu.
   * 
   * @return the ibu
   */
  public Integer getIbu() {
    return ibu;
  }


  /**
   * getAbv, returns the abv.
   * 
   * @return the abv
   */
  public Double getAbv() {
    return abv;
  }

}
