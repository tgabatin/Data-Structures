package edu.ics211.h04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import edu.ics211.h02.AbvComparator;
import edu.ics211.h02.Beer;
import edu.ics211.h02.BeerType;
import edu.ics211.h02.IbuComparator;
import edu.ics211.h02.IndiaPaleAle;
import edu.ics211.h02.ManoaBrewing;
import edu.ics211.h02.Pilsner;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

/**
 * Represents a SortableBeerListTest.
 *
 * @author Cam Moore
 *
 */
public class SortableBeerListTest {

  private ManoaBrewing brewrey;
  private SortableBeerList bitters;
  private SortableBeerList strongs;
  private Pilsner[] pils;
  private IbuComparator ibuC;
  private AbvComparator abvC;


  /** Sets up the brewer. */
  @Before
  public void initialize() {
    brewrey = ManoaBrewing.getInstance();
    ibuC = new IbuComparator();
    abvC = new AbvComparator();
    pils = new Pilsner[3];
    pils[0] = (Pilsner) brewrey.brewPilsner("pils1", 25, 4.2);
    pils[1] = (Pilsner) brewrey.brewPilsner("pils2", 30, 5.0);
    pils[2] = (Pilsner) brewrey.brewPilsner("pils2", 35, 6.0);
    bitters = new SortableBeerList(ibuC);
    strongs = new SortableBeerList(abvC);
    for (int i = pils.length - 1; i >= 0; i--) {
      bitters.add(pils[i]);
      strongs.add(brewrey.brewBeer("strong beer" + i, brewrey.randomBeerType()));
    }
  }


  /**
   * Test method for {@link edu.ics211.h04.SortableBeerList#get(int)}.
   */
  @Test
  public void testGet() {
    assertTrue("Wrong Get", pils[0].equals(bitters.get(0)));
    assertTrue("Wrong Get", pils[1].equals(bitters.get(1)));
    assertTrue("Wrong Get", pils[2].equals(bitters.get(2)));
  }


  /**
   * Test method for {@link edu.ics211.h04.SortableBeerList#set(int, edu.ics211.h01.Beer)}.
   */
  @Test
  public void testSet() {
    bitters.set(0, pils[1]);
    assertTrue("Wrong Get", pils[1].equals(bitters.get(0)));
    assertTrue("Wrong Get", pils[1].equals(bitters.get(1)));
    assertTrue("Wrong Get", pils[2].equals(bitters.get(2)));
  }


  /**
   * Test method for {@link edu.ics211.h04.SortableBeerList#indexOf(java.lang.Object)}.
   */
  @Test
  public void testIndexOf() {
    IndiaPaleAle ipa = (IndiaPaleAle) brewrey.brewBeer("IPA", BeerType.INDIA_PALE_ALE);
    assertEquals("Shouldn't find ipa", bitters.indexOf(ipa), -1);
    assertEquals("Shouldn't find ipa", bitters.indexOf(pils[0]), 0);
    assertEquals("Shouldn't find ipa", bitters.indexOf(pils[1]), 1);
    assertEquals("Shouldn't find ipa", bitters.indexOf(pils[2]), 2);
  }


  /**
   * Test method for {@link edu.ics211.h04.SortableBeerList#size()}.
   */
  @Test
  public void testSize() {
    assertEquals("Wrong size want 3", bitters.size(), 3);
  }


  /**
   * Test method for {@link edu.ics211.h04.SortableBeerList#add(edu.ics211.h01.Beer)}.
   */
  @Test
  public void testAddBeer() {
    IndiaPaleAle ipa = (IndiaPaleAle) brewrey.brewBeer("IPA", BeerType.INDIA_PALE_ALE);
    assertTrue(bitters.add(ipa));
    assertTrue("Not Sorted", isSorted(bitters, ibuC));
    assertEquals("Wrong size want 4", bitters.size(), 4);
    assertTrue("Wrong Get", ipa.equals(bitters.get(3)));
  }


  /**
   * Test method for {@link edu.ics211.h04.SortableBeerList#add(int, edu.ics211.h01.Beer)}.
   */
  @Test
  public void testAddIntBeer() {
    IndiaPaleAle ipa = (IndiaPaleAle) brewrey.brewBeer("IPA", BeerType.INDIA_PALE_ALE);
    bitters.add(2, ipa);
    assertTrue("Not Sorted", isSorted(bitters, ibuC));
    assertEquals("Wrong size want 4", bitters.size(), 4);
    assertTrue("Wrong Get", ipa.equals(bitters.get(3)));
  }


  /**
   * Test method for {@link edu.ics211.h04.SortableBeerList#remove(int)}.
   */
  @Test
  public void testRemove() {
    try {
      bitters.remove(-1);
      fail("Should throw exception");
    } catch (Exception e) {
      // expected
    }
    assertEquals("Wrong size want 3", bitters.size(), 3);
    bitters.remove(0);
    assertEquals("Wrong size want 2", bitters.size(), 2);
  }

  private boolean isSorted(SortableBeerList data, Comparator<Beer> comp) {
    for (int i = 0; i < data.size() - 1; i++) {
      if (comp.compare(data.get(i), data.get(i + 1)) > 0) {
        return false;
      }
    }
    return true;
  }

}