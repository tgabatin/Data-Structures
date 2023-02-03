package edu.ics211.h01;

import java.io.IOException;
import java.io.InputStream;

/**
 * Represents a BitReader.
 *
 * @author Cam Moore
 *
 */
public class BitReader implements AutoCloseable {
  private boolean done;
  private byte buffer = 0;
  private int bits = 0;
  private InputStream in;


  /**
   * Creates a BitReader for the given input stream.
   *
   * @param in The input stream to read from.
   * @throws IOException if there is a problem with the InputStream.
   */
  public BitReader(InputStream in) throws IOException {
    this.done = false;
    this.bits = 0;
    this.in = in;
    fillBuffer();
  }


  /**
   * Reads a Byte from the input stream.
   *
   * @return a Byte from the input stream.
   */
  public Byte readByte() {
    byte buf = 0;
    for (int i = 0; i < 8; i++) {
      buf <<= 1;
      int val = readAsInt();
      buf |= val;
    }
    return buf;
  }


  /**
   * Returns an Integer from the input stream.
   *
   * @return an Integer from the input stream.
   */
  public Integer readInt() {
    int value = 0;
    for (int i = 0; i <= 3; i++) {
      byte b = readByte();
      value |= (b & 0x00ff);
      value *= 256;
    }
    value /= 256;
    return value;
  }


  /**
   * Reads a bit from the input stream.
   *
   * @return true if the bit is 1, false if the bit is 0.
   */
  public boolean read() {
    return readAsInt() == 1;
  }


  /**
   * Reads the bit from the input stream.
   *
   * @return 1 or 0 for the bit.
   */
  public int readAsInt() {
    //CHECKSTYLE:OFF
    int bit = buffer & 0x80;
    //CHECKSTYLE:ON
    buffer <<= 1;
    bits++;
    if (bits == 8) {
      try {
        fillBuffer();
      } catch (IOException e) {
        try {
          close();
        } catch (Exception e1) {
          // its ok.
        }
      }
      bits = 0;
    }
    return bit / 128;
  }


  /**
   * Returns the done of this BitReader.
   *
   * @return the done of this BitReader.
   */
  public boolean isDone() {
    return done;
  }


  /**
   * Fills the internal buffer.
   *
   * @throws IOException if there is a problem with the input stream.
   */
  private void fillBuffer() throws IOException {
    this.buffer = 0;
    int byteValue = in.read();
    this.buffer = (byte) (byteValue & 0x00ff);
    this.bits = 0;
    this.done = byteValue == -1;
  }


  /* (non-Javadoc)
   * @see java.lang.AutoCloseable#close()
   */
  @Override
  public void close() throws IOException {
    done = true;
    in.close();
  }
}