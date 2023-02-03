package edu.ics211.h11;

import java.io.IOException;
import java.util.Scanner;

public class H11HuffmanTaylor {

  public static void main(String[] args) throws IOException {
    testCode();
  }


  /**
   * Testing the compression and decompression of Huffman encoded files.
   * @author Taylor D. Gabatino received help from Michael Kirts testing code. 
   * @throws IOException throws the IOException for files.
   */
  public static void testCode() throws IOException {
    Scanner scan = new Scanner(System.in);
    System.out.print("Press 1 to compress, press 2 to decompress: ");
    int i = scan.nextInt();
    switch (i) {
      case 1: {
        Scanner scanCompress = new Scanner(System.in);
        System.out.print("Please input a file to be compressed: ");
        String comp = scanCompress.nextLine();
        System.out.println("Compressing: " + "\"" + comp + "\"");
        Huffman.compress(comp);
        System.out.println("Please refresh the project to see the compressed file.");
        scanCompress.close();
      }
        break;
      case 2: {
        Scanner scanDecomp = new Scanner(System.in);
        System.out.print("Please input a file ending in .huff to decompress: ");
        String decomp = scanDecomp.nextLine();
        System.out.println("Decompressing: " + "\"" + decomp + "\"");
        Huffman.decompress(decomp);
        System.out.println("Please refresh the project to see the decompressed file.");
        scanDecomp.close();
      }
        break;
      default: {
        System.out.println("Usage:" + "\"" + "java H11Human <filename>" + "\"");
        System.exit(0);
      }
    }
    scan.close();

  }
}
