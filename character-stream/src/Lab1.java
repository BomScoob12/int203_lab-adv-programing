import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab1 {

  public static void main(String[] args)
    throws FileNotFoundException, IOException {
    try {
      String data = "Hello World!\nWelcome to Java";
      OutputStreamWriter output = new OutputStreamWriter(
        new FileOutputStream("lab1.txt")
      );
      output.write(data);
      output.close();
    } catch (IOException exception) {
      Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, exception);
    }

    try {
      InputStreamReader input = new InputStreamReader(
        new FileInputStream("lab1.txt")
      );
      int ch;
      while ((ch = input.read()) != -1) System.out.print((char) ch);
      input.close();
    } catch (FileNotFoundException exception) {
      Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, exception);
    } catch (IOException exception) {
      Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, exception);
    }
  }
}
