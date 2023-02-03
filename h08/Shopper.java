package edu.ics211.h08;

/**
 * Represents a Shopper.
 *
 * @author Cam Moore
 *
 */
public class Shopper {
  private static int count = 0;
  private int numberOfItems;
  private int shopperNumber;
  
  /**
   * Creates a new Shopper with the given number of items.
   * @param numItems the number of items.
   */
  public Shopper(int numItems) {
    this.shopperNumber = count++;
    this.numberOfItems = numItems;
  }

  /**
   * Returns the numberOfItems of this Shopper.
   *
   * @return the numberOfItems of this Shopper.
   */
  public final int getNumberOfItems() {
    return numberOfItems;
  }

  /**
   * Returns the shopperNumber of this Shopper.
   *
   * @return the shopperNumber of this Shopper.
   */
  public final int getShopperNumber() {
    return shopperNumber;
  }
  
}