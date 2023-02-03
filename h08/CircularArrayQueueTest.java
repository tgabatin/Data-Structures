package edu.ics211.h08;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Represents a CircularArrayQueueTest.
 *
 * @author Cam Moore
 *
 */
public class CircularArrayQueueTest {

  /**
   * Test method for {@link edu.ics211.h07.CircularArrayQueue#add(java.lang.Object)}.
   */
  @Test
  public void testAdd() {
    CircularArrayQueue<String> queue = new CircularArrayQueue<String>();
    assertTrue("Wrong size", 0 == queue.size());
    queue.add("Foo");
    assertTrue("Wrong size", 1 == queue.size());
    queue.offer("Bar");
    assertTrue("Wrong size", 2 == queue.size());
    for (int i = 0; i < 1000; i++) {
      System.out.println(queue.size());
      queue.add("Foo");
    }
    assertEquals("Wrong size", 1002, queue.size());
  }


  /**
   * Test method for {@link edu.ics211.h07.CircularArrayQueue#remove()}.
   */
  @Test
  public void testRemove() {
    CircularArrayQueue<String> queue = new CircularArrayQueue<String>();
    queue.add("Foo");
    queue.offer("Bar");
    assertTrue("Wrong remove", "Foo".equals(queue.remove()));
    assertTrue("Wrong size", 1 == queue.size());
    assertTrue("Wrong poll", "Bar".equals(queue.poll()));
    assertTrue("Wrong size", 0 == queue.size());
    assertEquals("Wrong empty poll", null, queue.poll());
    try {
      queue.remove();
      fail("Should throw exception");
    } catch (NoSuchElementException nse) {
      // this is expected
    } catch (Exception e) {
      fail("Wrong exception thrown");
    }
  }


  /**
   * Test method for {@link edu.ics211.h07.CircularArrayQueue#element()}.
   */
  @Test
  public void testElement() {
    CircularArrayQueue<String> queue = new CircularArrayQueue<String>();
    queue.add("Foo");
    queue.offer("Bar");
    assertTrue("Wrong element", "Foo".equals(queue.element()));
    assertTrue("Wrong size", 2 == queue.size());
    queue.remove();
    assertTrue("Wrong peek", "Bar".equals(queue.peek()));
    assertTrue("Wrong size", 1 == queue.size());
    queue.poll();
    assertEquals("Wrong peek for empty", null, queue.peek());
    try {
      queue.element();
      fail("Should have thrown exception");
    } catch (NoSuchElementException nse) {
      // this is correct
    } catch (Exception e) {
      fail("Threw wrong exception");
    }
  }


  /**
   * Tests the circular list.
   */
  @Test
  public void testCircular() {
    CircularArrayQueue<String> queue = new CircularArrayQueue<String>();
    for (int i = 0; i < 1000; i++) {
      queue.offer("Foo");
      queue.add("Bar");
      assertTrue("Wrong size", 2 == queue.size());
      queue.poll();
      queue.remove();
      assertTrue("Wrong size", 0 == queue.size());
    }
  }
}