import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab2 {

  public static void main(String[] args)
    throws FileNotFoundException, IOException {
    try {
      String data = "Hello World!\nWelcome to Java";
      BufferedWriter output = new BufferedWriter(new FileWriter("lab2.txt"));
      output.write(data);
      output.close();
    } catch (IOException exception) {
      Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, exception);
    }

    try {
      char[] cBuf = new char[100];
      BufferedReader input = new BufferedReader(new FileReader("lab1.txt"));
      input.read(cBuf);
      System.out.println(cBuf);
      input.close();
    } catch (FileNotFoundException exception) {
      Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, exception);
    } catch (IOException exception) {
      Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, exception);
    }
  }
}
