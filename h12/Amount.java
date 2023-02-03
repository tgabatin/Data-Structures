package edu.ics211.h12;

import java.util.Random;

/**
 * Represents an Amount.
 *
 * @author Cam Moore
 *
 */
public class Amount {
  /**
   * Gets the random amount.
   * @return a random Amount.
   */
  public static Amount getRandomAmount() {
    Random random = new Random();
    double a = random.nextDouble() * 5 + 0.5;
    return new Amount(a, Unit.getRandomUnit());
  }

  private double amount;
  private Unit unit;

  /**
   * Creates an Amount.
   * @param amount double, the amount,
   * @param unit Unit, the unit of measurement.
   */
  public Amount(double amount, Unit unit) {
    this.amount = amount;
    this.unit = unit;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Amount)) {
      return false;
    }
    Amount other = (Amount) obj;
    if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount)) {
      return false;
    }
    if (unit != other.unit) {
      return false;
    }
    return true;
  }

  /**
   * Returns the amount of this Amount.
   *
   * @return the amount of this Amount.
   */
  public final double getAmount() {
    return amount;
  }

  /**
   * Returns the unit of this Amount.
   *
   * @return the unit of this Amount.
   */
  public final Unit getUnit() {
    return unit;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(amount);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((unit == null) ? 0 : unit.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return String.format("%2.2f",amount) + " " + unit;
  }
}