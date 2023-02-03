package edu.ics211.h07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.EmptyStackException;

import org.junit.Test;

/**
 * Represents a CalculatorTest.
 *
 * @author Cam Moore
 *
 */
public class CalculatorTest {

  /**
   * Test method for {@link edu.ics211.h07.Calculator#postFixCalculate(java.lang.String)}.
   * 
   * @throws InvalidExpressionException throw an InvalidExpressionException
   */
  @Test
  public final void testPostFixCalculate() throws InvalidExpressionException {
    Calculator c = Calculator.getInstance();
    assertNotNull(c);
    try {
      c.postFixCalculate("");
      fail("Should throw exception on empty expression");
    } catch (InvalidExpressionException iee) {
      // this is ok
    }
    try {
      c.postFixCalculate("x");
      fail("Should throw exception on bad expression");
    } catch (InvalidExpressionException iee) {
      // this is ok
      c.clear();
    }
    try {
      c.postFixCalculate("2 + 3");
      fail("Should throw exception on bad expression");
    } catch (EmptyStackException iee) {
      // this is ok
      c.clear();
    }
    try {
      Number ans = c.postFixCalculate("5.2");
      assertTrue("Should be an Double", ans instanceof Double);
      assertEquals("Should be 5.2", Double.valueOf(5.2), (Double) ans, 0.0001);
    } catch (InvalidExpressionException iee) {
      fail("Should throw exception on bad expression");
    }
    try {
      c.postFixCalculate("5.2 1.0");
      fail("Should throw exception on bad expression");
    } catch (InvalidExpressionException iee) {
      // this is ok
      c.clear();
    }
    try {
      Number ans = c.postFixCalculate("1 2 + 3 * 6 + 2 3 + /");
      assertTrue("Should be an Integer", ans instanceof Integer);
      assertEquals("Should be 3", Integer.valueOf(3), ans);
    } catch (InvalidExpressionException iee) {
      fail("Should not throw an exception.");
    }
    try {
      Number ans = c.postFixCalculate("2.2 7.0 + 3.0 *");
      assertTrue("Should be an Double", ans instanceof Double);
      assertEquals("Should be 27.6", Double.valueOf(27.6), (Double) ans, 0.0001);
    } catch (InvalidExpressionException iee) {
      fail("Should not throw an exception.");
    }
    try {
      c.postFixCalculate("2.2 7.0a 3.0 *");
      fail("Should throw an exception.");
    } catch (InvalidExpressionException iee) {
      // the correct behavior
      c.clear();
    }
  }


  /**
   * Test method for {@link edu.ics211.h07.Calculator#preFixCalculate(java.lang.String)}.
   * 
   * @throws InvalidExpressionException throw an InvalidExpressionException
   */
  @Test
  public final void testPreFixCalculate() throws InvalidExpressionException {
    Calculator c = Calculator.getInstance();
    assertNotNull(c);
    try {
      try {
        c.preFixCalculate("");
      } catch (InvalidExpressionException iee) {
        // this is ok
      }
      try {
        c.preFixCalculate("x");
        fail("Should throw exception on bad expression");
      } catch (InvalidExpressionException iee) {
        // this is ok
        c.clear();
      }
      try {
        c.preFixCalculate("2 + 3");
        fail("Should throw exception on bad expression");
      } catch (EmptyStackException iee) {
        // this is ok
        c.clear();
      }
      try {
        Number ans = c.preFixCalculate("5.2");
        assertTrue("Should be an Double", ans instanceof Double);
        assertEquals("Should be 5.2", Double.valueOf(5.2), (Double) ans, 0.0001);
      } catch (InvalidExpressionException iee) {
        fail("Should throw exception on bad expression");
      }
      try {
        c.preFixCalculate("5.2 1.0");
        fail("Should throw exception on bad expression");
      } catch (InvalidExpressionException iee) {
        // this is ok
        c.clear();
      }
      try {
        Number ans = c.preFixCalculate("/ + * + 1 2 3 6 + 2 3");
        assertTrue("Should be an Integer", ans instanceof Integer);
        assertEquals("Should be 3", Integer.valueOf(3), ans);
      } catch (InvalidExpressionException iee) {
        fail("Should not throw an exception.");
      }
      try {
        Number ans = c.preFixCalculate("* + 2.2 7.0 3.0");
        assertTrue("Should be an Double", ans instanceof Double);
        assertEquals("Should be 27.6", Double.valueOf(27.6), (Double) ans, 0.0001);
      } catch (InvalidExpressionException iee) {
        fail("Should not throw an exception.");
      }
      try {
        Number ans = c.preFixCalculate("- 1 + 3 5");
        assertTrue("Should be an Integer", ans instanceof Integer);
        assertEquals("Should be -7", Integer.valueOf(-7), ans);
      } catch (InvalidExpressionException iee) {
        fail("Should not throw an exception.");
      }
      try {
        Number ans = c.preFixCalculate("+ / 3 4 5.0");
        assertTrue("Should be an Double", ans instanceof Double);
        assertEquals("Should be 5.0", Double.valueOf(5.0), (Double) ans, 0.0001);
      } catch (InvalidExpressionException iee) {
        fail("Should not throw an exception.");
      }
      try {
        Number ans = c.preFixCalculate("+ / 3 4.0 5.0");
        assertTrue("Should be an Double", ans instanceof Double);
        assertEquals("Should be 5.75", Double.valueOf(5.75), (Double) ans, 0.0001);
      } catch (InvalidExpressionException iee) {
        fail("Should not throw an exception.");
      }
    } catch (UnsupportedOperationException uoe) {
      // this is ok, pre-fix is extra credit.
    }
  }

}