import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 {

  public static void main(String[] args) {
    try {
      PrintWriter output = new PrintWriter(
        new OutputStreamWriter(new FileOutputStream("lab3.txt"))
      );
      output.println("Hello World!");
      output.println("Welcome to Java");
      output.println("Harry Potter");
      output.println(19);
      output.println(60.5);
      output.println(175.0);
      output.close();
    } catch (FileNotFoundException exception) {
      Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, exception);
    }

    try {
      Scanner scanner = new Scanner(new File("./lab3.txt"));
      while (scanner.hasNext()) System.out.println(scanner.nextLine());
      scanner.close();
    } catch (FileNotFoundException exception) {
      Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, exception);
    }
  }
}
