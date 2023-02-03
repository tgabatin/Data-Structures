 /**
 * 
 */

package edu.ics211.h01;

import java.io.IOException;
import java.io.InputStream;

/**
 * Translator, translates binary, hexadecimal, and UTF-8 as Strings.
 * @author Taylor D. Gabatino worked with Jackie Wong(Former Student) & Bradley Valiente. 
 *
 */

public class Translator implements Translate {

  /**
   * Converts byte from input stream to integer and returns the value as a string.
   *
   * @param in the values from the InputStream
   * @return The binary code is returned as a string.
   * 
   */

  @Override
  public String asBinaryString(InputStream in) {
    StringBuilder binaryString = new StringBuilder();
    BitReader bitreader;
    try {
      bitreader = new BitReader(in);
      while (!bitreader.isDone()) {
        byte b = (byte) bitreader.readAsInt();
        binaryString.append(b);
      }
      bitreader.close();
      return binaryString.toString();
    } catch (IOException e) {
      e.printStackTrace();
      return binaryString.toString();
    }

  }


  /**
   * Converts the input from the input stream to a hexadecimal then returns it to a String.
   *
   * @param in the values from the InputStream.
   * @return The hexadecimal string is returned from the input string.
   */
  @Override
  public String asHexadecimalString(InputStream in) {
    StringBuilder hexString = new StringBuilder();
    try {
      int b = in.read();
      while (b != -1) {
        String s = Integer.toHexString(b);
        if (s.length() == 1) {
          s = "0" + s;
        }
        hexString.append(s);
        b = in.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return hexString.toString();
  }


  /**
   * Converts the input stream to bytes then reads it and returns as a String.
   *
   * @param in the values from the InputStream.
   * @return The contents from UTF-8 are returned as a String.
   */
  @Override
  public String asUtf8String(InputStream in) {
    try {
      byte[] bytes = new byte[in.available()];
      in.read(bytes);
      return new String(bytes, "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
