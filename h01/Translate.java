package edu.ics211.h01;

import java.io.InputStream;

/**
 * Translates InputStream to binary string, hexadecimal string, and a UTF-8 string.
 *
 * @author Cam Moore
 *
 */
public interface Translate {
  
  /**
   * Returns the contents of the InputStream as a binary String.
   * @param in the InputStream.
   * @return The contents of the InputStream as a binary String.
   */
  String asBinaryString(InputStream in);

  /**
   * Returns the contents of the InputStream as a hexadecimal String.
   * @param in the InputStream.
   * @return The contents of the InputStream as a hexadecimal String.
   */
  String asHexadecimalString(InputStream in);

  /**
   * Returns the contents of the InputStream as a UTF-8 String.
   * @param in the InputStream.
   * @return The contents of the InputStream as a UTF-8 String.
   */
  String asUtf8String(InputStream in);
}
