package edu.ics211.h12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Represents a PotionBagTest.
 *
 * @author Cam Moore
 *
 */
public class PotionBagTest {

  private QuickPotionBag quick;
  private MediumPotionBag medium;
  private SlowPotionBag slow;
  private static final int NUM_POTIONS = 100000;

  /**
   * setUp gets the instances of the potion bags. 
   * @throws java.lang.Exception if there is a problem.
   */
  @Before
  public void setUp() throws Exception {
    quick = QuickPotionBag.getInstance();
    medium = MediumPotionBag.getInstance();
    slow = SlowPotionBag.getInstance();
    for (int i = 0; i < NUM_POTIONS; i++) {
      Potion p = PotionGenerator.getInstance().createRandomPotion();
      quick.store(p);
      medium.store(p);
      slow.store(p);
    }
  }


  /**
   * Tests storing and retrieving potions.
   */
  @Test
  public void test() {
    Potion p = PotionGenerator.getInstance().createRandomPotion();
    int sizeQ = quick.size();
    assertTrue(sizeQ == NUM_POTIONS);
    final long quickStoreTime = quick.timedStore(p);
    assertTrue(quick.size() == sizeQ + 1);
    int sizeM = medium.size();
    final long medStoreTime = medium.timedStore(p);
    assertTrue(medium.size() == sizeM + 1);
    int sizeS = slow.size();
    assertTrue(sizeS == NUM_POTIONS);
    long slowStoreTime = slow.timedStore(p);
    assertTrue(slow.size() == sizeS + 1);
    System.out.println("Q store: " + quickStoreTime
        + ", M store: " + medStoreTime + ", S store: " + slowStoreTime);
    long quickRetrieveTime = quick.timedRetrieve(p);
    assertTrue(quick.size() == sizeQ);
    long medRetrieveTime = medium.timedRetrieve(p);
    assertEquals(medium.size(), sizeM);
    long slowRetrieveTime = slow.timedRetrieve(p);
    System.out.println("Q retrieve: " + quickRetrieveTime
        + ", M retrieve: " + medRetrieveTime + ", S retrieve: " + slowRetrieveTime);
  }

}