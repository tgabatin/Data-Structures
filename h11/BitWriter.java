package edu.ics211.h11;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Writes single bits to a binary output stream. Does not buffer more than
 * a single byte at a time (though the underlying output stream might itself
 * be buffered). Do not intersperse writes to the underlying stream with writes
 * through this BitWriter.
 * 
 * <p>IMPORTANT: Since only whole bytes can be written to the underlying output
 * stream, you need to indicate that you are done writing bits. Call flush()
 * after you write your last bit to be sure any last few bits get sent to the output
 * stream.
 *
 * @author Zach Tomaszewski and Cam Moore
 * @since 15 Nov 2012
 */
public class BitWriter implements AutoCloseable {

  byte buffer = 0;
  int bits = 0; // bits in the buffer
  OutputStream out;

  /*
   * Implementation note: Although the buffer is conceptually filled in left-to-right:
   *
   * Adding 1, 0, 1, 1: 1??????? 10?????? 101????? 1011????
   *
   * we'll instead append new bits on the right, thereby pushing any existing bits to the left:
   *
   * ???????1 ??????10 ?????101 ????1011
   *
   * Either way, the byte looks the same after 8 additions.
   */


  /**
   * Constructs a BitWriter that will write to the given output stream.
   * @param out the OutputStream to write to.
   */
  public BitWriter(OutputStream out) {
    this.out = out;
  }


  /**
   * Writes the given boolean as a bit to the underlying stream. 
   * <code>true</code> == 1 and <code>false</code> == 0.
   *
   *@param bit the bit to write.
   * @throws IOException If cannot write to underlying stream.
   */
  public void write(boolean bit) throws IOException {
    this.write((bit) ? 1 : 0);
  }


  /**
   * Writes the given int value as a bit to the underlying stream. 
   * 0 is a 0 bit and any other int value is treated as a
   * 1 bit.
   *
   * @param bit the bit to write.
   * @throws IOException If cannot write to underlying stream.
   */
  public void write(int bit) throws IOException {
    bit &= 0x1; // mask all but last of 32 bits so bit is only 1 or 0
    buffer <<= 1; // shift buffer over 1 bit
    buffer |= bit; // merge bit into buffer
    bits++;
    if (bits == 8) {
      this.flush(); // time to write out; resets buffer and bits
    }
  }


  /**
   * Writes the given byte one bit a time. This is convenience method that allows
   * a user to also write more traditional-sized data through this BitWriter.
   * @param b the byte to write.
   * @throws IOException If cannot write to stream.
   */
  public void writeByte(byte b) throws IOException {
    /* would have used a java.util.BitSet here, but valueOf not in Java 1.6 */
    // manually cycle through bits in b...
    for (int i = 7; i >= 0; i--) { // loop through bit positions: 76543210
      int mask = 0x01 << i; // mask out all except bit at position i
      int bit = b & mask;
      bit >>>= i; // shift remaining bit to position 0 (right-most)
      this.write(bit);
    }
  }


  /**
   * Writes the bits in the byte-long buffer to the underlying output stream. If
   * the buffer is not full yet, pads the
   * remainder of the byte with 0 bits.
   *
   * @throws IOException If cannot write to stream.
   */
  public void flush() throws IOException {
    // conceptually, may need to "pad" remainder of byte first.
    // (Actually, just shift left, since 0s will come in on right)
    int padding = 8 - bits;
    buffer <<= padding;
    out.write(buffer);
    buffer = 0;
    bits = 0;
  }


  /* (non-Javadoc)
   * @see java.lang.AutoCloseable#close()
   */
  @Override
  public void close() throws IOException {
    flush();
    out.close();
  }
}