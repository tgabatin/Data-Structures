package edu.ics211.h03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import org.junit.Test;

/**
 * Represents a ReadFileTest.
 *
 * @author Cam Moore
 *
 */
public class ReadFileTest {

  private String quote1 = "Mr. Phileas Fogg lived, in 1872, at No. 7, Saville Row, "
      + "Burlington Gardens, the house in which Sheridan died in 1814. He was one of "
      + "the most noticeable members of the Reform Club, though he seemed always to avoid "
      + "attracting attention; an enigmatical personage, about whom little was known, except "
      + "that he was a polished man of the world. People said that he resembled Byron-at least "
      + "that his head was Byronic; but he was a bearded, tranquil Byron, who might live on a "
      + "thousand years without growing old.";
  private String quote2 = "Certainly an Englishman, it was more doubtful whether Phileas Fogg "
      + "was a Londoner. He was never seen on 'Change, nor at the Bank, nor in the counting-rooms "
      + "of the \"City\"; no ships ever came into London docks of which he was the owner; he had "
      + "no public employment; he had never been entered at any of the Inns of Court, either at "
      + "the Temple, or Lincoln's Inn, or Gray's Inn; nor had his voice ever resounded in the "
      + "Court of Chancery, or in the Exchequer, or the Queen's Bench, or the Ecclesiastical "
      + "Courts.";
  private String quote3 = "He certainly was not a manufacturer; nor was he a merchant or "
      + "a gentleman farmer. His name was strange to the scientific and learned societies, "
      + "and he never was known to take part in the sage deliberations of the Royal Institution "
      + "or the London Institution, the Artisan's Association, or the Institution of Arts and "
      + "Sciences. He belonged, in fact, to none of the numerous societies which swarm in the "
      + "English capital, from the Harmonic to that of the Entomologists, founded mainly for "
      + "the purpose of abolishing pernicious insects.";
  private String quote4 = "Phileas Fogg was a member of the Reform, and that was all.";

  /**
   * Test method for {@link edu.ics211.h03.ReadFile#readFile(java.lang.String)}.
   */
  @Test
  public final void testReadFile() {
    ReadFile rf = new ReadFile();
    try {
      assertEquals("Bad answer for data1.dat", quote1, rf.readFile("data1.dat"));
      assertEquals("Bad answer for data2.dat", quote2, rf.readFile("data2.dat"));
      assertEquals("Bad answer for data3.dat", quote3, rf.readFile("data3.dat"));
      assertEquals("Bad answer for data4.dat", quote4, rf.readFile("data4.dat"));
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

}