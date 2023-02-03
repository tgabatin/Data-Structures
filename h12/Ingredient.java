package edu.ics211.h12;

/**
 * Represents a Ingredient.
 *
 * @author Cam Moore
 *
 */
public class Ingredient {
  private String name;
  private Amount amount;

  /**
   * Creates an Ingredient.
   * @param name String, the name of the Ingredient.
   * @param amount Amount, the amount of the Ingredient.
   */
  public Ingredient(String name, Amount amount) {
    this.name = name;
    this.amount = amount;
  }


  /**
   * Returns the name of this Ingredient.
   *
   * @return the name of this Ingredient.
   */
  public final String getName() {
    return name;
  }


  /**
   * Sets the name value of this Ingredient.
   *
   * @param name the name to set.
   */
  public final void setName(String name) {
    this.name = name;
  }


  /**
   * Returns the amount of this Ingredient.
   *
   * @return the amount of this Ingredient.
   */
  public final Amount getAmount() {
    return amount;
  }


  /**
   * Sets the amount value of this Ingredient.
   *
   * @param amount the amount to set.
   */
  public final void setAmount(Amount amount) {
    this.amount = amount;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
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
    if (!(obj instanceof Ingredient)) {
      return false;
    }
    Ingredient other = (Ingredient) obj;
    if (amount == null) {
      if (other.amount != null) {
        return false;
      }
    } else if (!amount.equals(other.amount)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "[\"" + name + "\", " + amount + "]";
  }

}