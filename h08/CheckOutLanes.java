package edu.ics211.h08;

import java.util.ArrayList;
import java.util.List;

/**
 * The checkout lanes.
 * 
 * @author Taylor D. Gabatino received help from Cam Moore.
 */
public class CheckOutLanes {
  int lanes;
  CircularArrayQueue<Shopper>[] checkoutLane;
  int regularLanes;
  int expressLanes;


  /**
   * Checkout Lane constructor.
   * 
   * @param numExpress number of express lanes
   * @param numRegular number of regular lanes
   */
  @SuppressWarnings("unchecked")
  public CheckOutLanes(int numExpress, int numRegular) {
    lanes = numExpress + numRegular;
    regularLanes = numRegular;
    expressLanes = numExpress;
    this.checkoutLane = new CircularArrayQueue[numExpress + numRegular];
    if (numExpress > 0) {
      for (int i = 0; i < numExpress; i++) {
        this.checkoutLane[i] = new CircularArrayQueue<Shopper>();
      }
      for (int i = numExpress; i < numExpress + numRegular; i++) {

        this.checkoutLane[i] = new CircularArrayQueue<Shopper>();
      }
    } else {
      for (int i = 0; i < numRegular; i++) {
        this.checkoutLane[i] = new CircularArrayQueue<Shopper>();
      }
    }
  }


  /**
   * Moves a shopper to a lane.
   * 
   * @param laneNumber the lane number
   * @param shopper the shopper
   */
  public void enterLane(int laneNumber, Shopper shopper) {
    checkoutLane[laneNumber].add(shopper);
  }


  /**
   * Simulates the checkout of the lanes.
   * 
   * @return shopper & the items.
   */
  public List<Shopper> simulateCheckout() {
    List<Shopper> s = new ArrayList<Shopper>();
    int p = 1;
    while (p != 0) {
      p = 0;
      for (int i = 0; i < lanes; i++) {
        if (checkoutLane[i].size() > 0) {
          if (i < expressLanes) {
            if (this.checkoutLane[i].element().getNumberOfItems() > 10) {
              Shopper temp = checkoutLane[i].peek();
              enterLane(expressLanes, checkoutLane[i].remove());
              System.out.println("Express" + temp.getNumberOfItems() + "moved" + expressLanes);
            } else {

              System.out.println("Lane" + i + checkoutLane[i].peek().getNumberOfItems() + "items.");
              s.add(checkoutLane[i].remove());
            }
          }
          if (i >= expressLanes) {
            System.out.println("Lane" + i + checkoutLane[i].peek().getNumberOfItems() + "items.");
            s.add(checkoutLane[i].remove());
          }
          if (checkoutLane[i].size() > 0) {
            p++;
          }

        }
      }
    }
    return s;
  }
}