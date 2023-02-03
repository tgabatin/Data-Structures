package edu.ics211.h02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the two comparators.
 *
 * @author Cam Moore
 *
 */
public class ComparatorTest {
  private ManoaBrewing brewer;


  /** Sets up the brewer. */
  @Before
  public void initialize() {
    brewer = ManoaBrewing.getInstance();
  }


  /**
   * Test method for the two comparators.
   */
  @Test
  public void testComparators() {
    IndiaPaleAle ipa = (IndiaPaleAle) brewer.brewIndiaPaleAle("Warrior IPA", 95, 7.3);
    Pilsner pils = (Pilsner) brewer.brewPilsner("Manoa Mist", 30, 4.3);
    BohemianPilsner boh = (BohemianPilsner) brewer.brewBohemianPilsner("Bohemian Sunset", 35, 5.3);
    IbuComparator ibuC = new IbuComparator();
    assertTrue("bad ibu comparator", ibuC.compare(ipa, pils) > 0);
    assertEquals("bad ibu comparator", ibuC.compare(ipa, ipa), 0);
    AbvComparator abvC = new AbvComparator();
    assertTrue("bad abv comparator", abvC.compare(pils, boh) < 0);
    assertEquals("bad abv comparator", abvC.compare(boh, boh), 0);
  }

}