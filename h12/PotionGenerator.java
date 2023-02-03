package edu.ics211.h12;

import java.util.Random;

/**
 * Represents a PotionGenerator.
 *
 * @author Cam Moore
 *
 */
public class PotionGenerator {
  private static PotionGenerator instance;
  /** Holds the symbols for random strings. */
  private static final char[] symbols;
  /** Generates random numbers. */
  private static final Random random = new Random();

  /* Initialize the characters to use in random Strings. */
  static {
    StringBuilder tmp = new StringBuilder();
    for (char ch = '0'; ch <= '9'; ++ch) {
      tmp.append(ch);
    }
    for (char ch = 'a'; ch <= 'z'; ++ch) {
      tmp.append(ch);
    }
    for (char ch = 'A'; ch <= 'Z'; ++ch) {
      tmp.append(ch);
    }
    symbols = tmp.toString().toCharArray();
  }


  private PotionGenerator() {

  }


  /**
   * Returns the singleton PotionGenerator.
   *
   * @return the singleton instance.
   */
  public static PotionGenerator getInstance() {
    if (instance == null) {
      instance = new PotionGenerator();
    }
    return instance;
  }


  /**
   * Creates a random Potion.
   *
   * @return a random Potion.
   */
  public Potion createRandomPotion() {
    int stringLen = random.nextInt(15) + 1;
    String name = randomString(stringLen);
    Potion ret = new Potion(name);
    int numIngredients = random.nextInt(4) + 1;
    for (int i = 0; i < numIngredients; i++) {
      ret.addIngredient(new Ingredient(randomString(5), Amount.getRandomAmount()));
    }
    return ret;
  }


  /**
   * Generates a random String of the given length.
   *
   * @param length the length of the String.
   * @return A random String.
   */
  private static String randomString(int length) {
    if (length < 1) {
      throw new IllegalArgumentException("length < 1: " + length);
    }
    char[] buf = new char[length];
    for (int idx = 0; idx < buf.length; ++idx) {
      buf[idx] = symbols[random.nextInt(symbols.length)];
    }
    return new String(buf);
  }

}