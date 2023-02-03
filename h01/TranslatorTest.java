package edu.ics211.h01;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

/**
 * Represents a TranslatorTest.
 *
 * @author Cam Moore
 *
 */
public class TranslatorTest {

  private final String testData = "Hello World from ICS 211.\nThis is the second line.";
  private final String binaryData = "0100100001100101011011000110110001101111001000000101011101101"
      + "11101110010011011000110010000100000011001100111001001101111011011010010000001001001010000"
      + "11010100110010000000110010001100010011000100101110000010100101010001101000011010010111001"
      + "10010000001101001011100110010000001110100011010000110010100100000011100110110010101100011"
      + "011011110110111001100100001000000110110001101001011011100110010100101110";
  private final String hexData = "48656c6c6f20576f726c642066726f6d20494353203231312e0a"
      + "5468697320697320746865207365636f6e64206c696e652e";
  private byte[] byteArray;
  private Translator translator;

  /**
   * Sets up the FileDump instance and the byteArray.
   * @throws java.lang.Exception if there is a problem.
   */
  @Before
  public void setUp() throws Exception {
    this.byteArray = testData.getBytes("UTF-8");
    this.translator = new Translator();
  }


  /**
   * Test method for {@link edu.ics211.h01.Translator#asBinaryString(java.io.InputStream)}.
   */
  @Test
  public final void testAsBinaryString() {
    String binary = translator.asBinaryString(new ByteArrayInputStream(byteArray));
    assertEquals("Got wrong binary String", binaryData, binary);
  }


  /**
   * Test method for {@link edu.ics211.h01.Translator#asHexadecimalString(java.io.InputStream)}.
   */
  @Test
  public final void testAsHexadecimalString() {
    String hex = translator.asHexadecimalString(new ByteArrayInputStream(byteArray));
    assertEquals("Got wrong hexadecimal String", hexData, hex);
  }


  /**
   * Test method for {@link edu.ics211.h01.Translator#asUtf8String(java.io.InputStream)}.
   */
  @Test
  public final void testAsUtf8String() {
    String utf8 = translator.asUtf8String(new ByteArrayInputStream(byteArray));
    assertEquals("Got wrong UTF-8 String", testData, utf8);
  }

}