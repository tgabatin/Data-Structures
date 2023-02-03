package edu.ics211.h12;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Potion.
 *
 * @author Cam Moore
 *
 */
public class Potion {
  private String name;
  private List<Ingredient> ingredients;

  /**
   * Creates a Potion with the given name and no ingredients.
   * @param name String the name of the potion.
   */
  public Potion(String name) {
    this(name, new ArrayList<Ingredient>());
  }

  /**
   * Creates a Potion with the given name and ingredients.
   * @param name String the name of the potion.
   * @param ingredients List the ingredients.
   */
  public Potion(String name, List<Ingredient> ingredients) {
    this.name = name;
    this.ingredients = ingredients;
  }

  /**
   * Adds and ingredient to this potion.
   * @param e Ingredient, the ingredient to add.
   * @return true.
   * @see java.util.List#add(java.lang.Object)
   */
  public boolean addIngredient(Ingredient e) {
    return ingredients.add(e);
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
    if (!(obj instanceof Potion)) {
      return false;
    }
    Potion other = (Potion) obj;
    if (ingredients == null) {
      if (other.ingredients != null) {
        return false;
      }
    } else if (!ingredients.equals(other.ingredients)) {
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

  /**
   * Returns the ingredients of this Potion.
   *
   * @return the ingredients of this Potion.
   */
  public final List<Ingredient> getIngredients() {
    return ingredients;
  }

  /**
   * Returns the name of this Potion.
   *
   * @return the name of this Potion.
   */
  public final String getName() {
    return name;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  /**
   * Removes an ingredient from this potion.
   * @param o Ingredient the ingredient to remove.
   * @return true if successful, false otherwise.
   * @see java.util.List#remove(java.lang.Object)
   */
  public boolean removeIngredient(Ingredient o) {
    return ingredients.remove(o);
  }

  /**
   * Sets the name value of this Potion.
   *
   * @param name the name to set.
   */
  public final void setName(String name) {
    this.name = name;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Potion [\"" + name + "\", ingredients=" + ingredients + "]";
  }

}