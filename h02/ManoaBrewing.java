package edu.ics211.h02;

/**
 * Represents a ManoaBrewing.
 *
 * @author Taylor D. Gabatino received help from Carleton Moore in class for brewBeer method.
 *
 */
public class ManoaBrewing implements IBrewery {
  private static ManoaBrewing instance;


  private ManoaBrewing() {

  }


  /**
   * ManoaBrewing, returns the instance of ManoaBrewing.
   * 
   * @return the instance.
   */
  public static ManoaBrewing getInstance() {
    if (instance == null) {
      instance = new ManoaBrewing();
    }
    return instance;
  }


  @Override
  public Beer brewBeer(String name, BeerType type) {
    switch (type) {
      case PILSNER:
        return new Pilsner(name);
      case BOHEMIAN_PILSNER:
        return new BohemianPilsner(name);
      case INDIA_PALE_ALE:
        return new IndiaPaleAle(name);
      default:
        return new Pilsner(name);
    }

  }


  @Override
  public Beer brewPilsner(String name, Integer ibu, Double abv) {
    Beer o = new Pilsner(name, ibu, abv);
    return o;
  }


  @Override
  public Beer brewBohemianPilsner(String name, Integer ibu, Double abv) {
    Beer o = new BohemianPilsner(name, ibu, abv);
    return o;
  }


  @Override
  public Beer brewIndiaPaleAle(String name, Integer ibu, Double abv) {
    Beer o = new IndiaPaleAle(name, ibu, abv);
    return o;
  }

}
