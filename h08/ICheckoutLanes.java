package edu.ics211.h08;

import java.util.List;

/**
 * Represents a ICheckoutLanes.
 *
 * @author Cam Moore
 *
 */
public interface ICheckoutLanes {
  /**
   * Adds the shopper to the checkout lane.
   * 
   * @param laneNumber the checkout lane number.
   * @param shopper the shopper.
   */
  void enterLane(int laneNumber, Shopper shopper);


  /**
   * Simulates the checkout process.
   * 
   * @return A list of shoppers in the order they are finished.
   */
  List<Shopper> simulateCheckout();
}