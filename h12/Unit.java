package edu.ics211.h12;

import java.util.Random;

/**
 * Represents a Unit.
 *
 * @author Cam Moore
 *
 */
public enum Unit {
  OZ, CUP, PINT, TSP, TBSP, LB, DASH, DROP, PART, PIECE, SCOOP, SPLASH, SPRIG, STICK;

  /**
   * Returns a random unit.
   * @return a random Unit.
   */
  public static Unit getRandomUnit() {
    Random random = new Random();
    return values()[random.nextInt(values().length)];
  }
}