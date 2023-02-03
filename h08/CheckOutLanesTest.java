package edu.ics211.h08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Represents a CheckoutLanesTest.
 *
 * @author Cam Moore
 *
 */
public class CheckOutLanesTest {

  /**
   * Test no express lane.
   */
  @Test
  public void testNoExpress() {
    System.out.println("\nTest No Express");
    CheckOutLanes lanes = new CheckOutLanes(0, 1);
    lanes.enterLane(0, new Shopper(5));
    lanes.enterLane(0, new Shopper(10));
    lanes.enterLane(0, new Shopper(15));
    List<Shopper> shoppers = lanes.simulateCheckout();
    assertTrue(shoppers.get(0).getNumberOfItems() == 5);
    assertTrue(shoppers.get(1).getNumberOfItems() == 10);
    assertTrue(shoppers.get(2).getNumberOfItems() == 15);
  }

  /**
   * Test one express lane.
   */
  @Test
  public void testOneExpress() {
    System.out.println("\nTest One Express");
    CheckOutLanes lanes = new CheckOutLanes(1, 1);
    lanes.enterLane(0, new Shopper(15));
    lanes.enterLane(0, new Shopper(10));
    lanes.enterLane(0, new Shopper(5));
    lanes.enterLane(1, new Shopper(25));
    List<Shopper> shoppers = lanes.simulateCheckout();
    assertEquals("Wrong number of shoppers", 4, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 25);
    assertTrue(shoppers.get(1).getNumberOfItems() == 10);
    assertTrue(shoppers.get(2).getNumberOfItems() == 15);
    assertTrue(shoppers.get(3).getNumberOfItems() == 5);
  }


  /**
   * One express two regular.
   */
  @Test
  public void testOneTwo() {
    System.out.println("\nTest One Express, Two Regular");
    CheckOutLanes checkout = new CheckOutLanes(1, 2);
    checkout.enterLane(0, new Shopper(15));
    checkout.enterLane(0, new Shopper(3));
    checkout.enterLane(1, new Shopper(20));
    checkout.enterLane(2, new Shopper(17));
    List<Shopper> shoppers = checkout.simulateCheckout();
    assertEquals("Wrong number of shoppers", 4, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 20);
    assertTrue(shoppers.get(1).getNumberOfItems() == 17);
    assertTrue(shoppers.get(2).getNumberOfItems() == 3);
    assertTrue(shoppers.get(3).getNumberOfItems() == 15);
  }

}