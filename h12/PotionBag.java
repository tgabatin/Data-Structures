package edu.ics211.h12;

/**
 * Represents a PotionBag.
 *
 * @author Cam Moore
 *
 */
public interface PotionBag {
  /**
   * Stores the given Potion in the PotionBag.
   *
   * @param p the Potion to store.
   */
  void store(Potion p);


  /**
   * Returns the number of nanoseconds it took to store a potion.
   *
   * @param p the potion to store.
   * @return the duration in nanoseconds it took to store a potion.
   */
  long timedStore(Potion p);


  /**
   * Retrieves the Potion from the bag.
   *
   * @param p the Potion to retrieve.
   * @return the Potion or null if the Potion was not in the bag.
   */
  Potion retrieve(Potion p);


  /**
   * Returns the number of nanoseconds to takes to retrieve a potion.
   *
   * @param p the potion to retrieve.
   * @return the number of nanoseconds it takes to retrieve a potion.
   */
  long timedRetrieve(Potion p);


  /**
   * Returns the number of Potions in the bag.
   *
   * @return the number of Potions in the bag.
   */
  int size();
}