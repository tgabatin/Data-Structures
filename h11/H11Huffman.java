package edu.ics211.h11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A class to compress and decompress Huffman encoding.
 * 
 * @author Taylor D. Gabatino received help from Cam Moore.
 */
public class H11Huffman {

  /**
   * Decodes the Huffman code in selected texts.
   * 
   * @param args checks the length of the string to run code.
   * @throws IOException throws the IOException.
   */
  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("Usage: java H11Huffman <filename>");
    } else {
      System.out.println(args[0]);
      int index = args[0].indexOf(Huffman.HUFF_EXT);
      if (index != -1) {
        String outputName = args[0].substring(0, index);
        System.out.println(outputName);
        FileInputStream input = new FileInputStream(args[0]);
        FileOutputStream output = new FileOutputStream(outputName);
        Huffman.decompress(input, output);
        output.flush();
        output.close();
      }
    }
  }

}
