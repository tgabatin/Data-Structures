package edu.ics211.h12;

import java.util.HashMap;

/**
 * Represents a quick potion bag. 
 * 
 * @author Taylor D. Gabatino received help from Dylan at Learning Emporium.
 *
 */
public class QuickPotionBag implements PotionBag {
  private static HashMap<Potion, Potion> table = new HashMap<Potion, Potion>(); // a hashtable
  private static QuickPotionBag instance; // a singleton instance

  /**
   * Gets an instance of a potion bag.
   * 
   * @return the instance.
   */
  public static QuickPotionBag getInstance() {
    if (instance == null) {
      instance = new QuickPotionBag();
    }
    return instance;
  }


  /**
   * Stores the given Potion in the PotionBag.
   *
   * @param p the Potion to store.
   */
  @Override
  public void store(Potion p) {
    table.put(p, p);
  }


  /**
   * Returns the number of nanoseconds it took to store a potion.
   *
   * @param p the potion to store.
   * @return the duration in nanoseconds it took to store a potion.
   */
  @Override
  public long timedStore(Potion p) {
    long startTime = System.nanoTime();
    store(p);
    return System.nanoTime() - startTime;
  }


  /**
   * Retrieves the Potion from the bag.
   *
   * @param p the Potion to retrieve.
   * @return the Potion or null if the Potion was not in the bag.
   */
  @Override
  public Potion retrieve(Potion p) {
    Potion retVal = (Potion) table.remove(p);
    return retVal;
  }


  /**
   * Returns the number of nanoseconds to takes to retrieve a potion.
   *
   * @param p the potion to retrieve.
   * @return the number of nanoseconds it takes to retrieve a potion.
   */
  @Override
  public long timedRetrieve(Potion p) {
    long startTime = System.nanoTime();
    retrieve(p);
    return System.nanoTime() - startTime;
  }


  /**
   * Returns the number of Potions in the bag.
   *
   * @return the number of Potions in the bag.
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return table.size();
  }

}