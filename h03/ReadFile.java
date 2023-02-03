package edu.ics211.h03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.String;

/**
 * Represents a ReadFile.
 *
 * @author Taylor D. Gabatino received help from Trevor Tejero(LA).
 *
 */
public class ReadFile implements IReadFile {

  /**
   * Reads a file as an int then a byte, and returns it as a string.
   * 
   * @param fileName the name of the file.
   */
  
  @Override
  public String readFile(String fileName) throws IOException {
    FileInputStream fio = new FileInputStream(fileName);
    DataInputStream dis = new DataInputStream(fio);

    byte[] byteArr = new byte[dis.readInt()];

    switch (dis.readByte()) {

      case 1: {
        dis.read(byteArr);
        String str = new String(byteArr, "US-ASCII");
        dis.close();
        return str;
      }

      case 2: {
        dis.read(byteArr);
        String str = new String(byteArr, "UTF-16LE");
        dis.close();
        return str;
      }

      case 3: {
        dis.read(byteArr);
        String str = new String(byteArr, "UTF-8");
        dis.close();
        return str;
      }

      case 4: {
        dis.read(byteArr);
        String str = new String(byteArr, "UTF-16");
        dis.close();
        return str;
      }

      default: {
        dis.close();
        throw new IOException();
      }

    }
  }

}
