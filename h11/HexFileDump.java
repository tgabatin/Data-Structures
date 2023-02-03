package edu.ics211.h11;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Will print the binary contents of a file in hexadecimal along
 * with a translation of printable characters.
 *
 * @author Zach Tomaszewski
 */
public class HexFileDump {

  private static final int LINE_LEN = 10;
  private static final int SPACE_FREQ = 5;
  private static final char UNPRINTABLE = '.';
  private static final String SPACER = " ";

  /**
   * Run with the name of a file to display.
   * @param args the command line arguments.
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Error: No filename given.");
      System.out.println();
      System.out.println("Usage: java HexFileDump filename");
      System.out.println("Will print binary contents of given file in hex.");
      return;
    }

    try {
      BufferedInputStream filein = new BufferedInputStream(
                                      new FileInputStream(args[0]));
      int count = 0;
      int nextByte = 0;
      StringBuffer lineEnd = new StringBuffer();
      while (true) {
        // read next byte
        nextByte = filein.read();
        count++;
        if (nextByte == -1) {
          //finish out the line
          for (int i = count; i <= LINE_LEN; i++) {
            System.out.print("   ");
            if (i % SPACE_FREQ == 0) {
              System.out.print(SPACER);
              lineEnd.append(SPACER);
            }
          }
          System.out.println(lineEnd);
          break;  //DONE
        }

        //print byte
        System.out.printf("%02X ", nextByte);
        if (nextByte >= 32 && nextByte < 127) {
          //printable ascii char
          lineEnd.append((char) nextByte);
        } else {
          //non printable
          lineEnd.append(UNPRINTABLE);
        }
        if (count % SPACE_FREQ == 0) {
          System.out.print(SPACER);  //extra space every so often
          lineEnd.append(SPACER);
        }
        if (count == LINE_LEN) {
          //print char view, end line, and reset for next line
          System.out.println(lineEnd);
          lineEnd = new StringBuffer();
          count = 0;
        }
      }

      filein.close();

    } catch (IOException e) {
      System.out.println("Could not display file: " + e.getMessage());
    }
  }

}