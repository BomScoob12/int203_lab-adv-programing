
package characterStream2;

import java.io.*;
import static java.lang.Double.parseDouble;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class Lab4 {
    public static void main(String[] args) {
        try {
            //keyboard send byte data to computer
            BufferedReader ioInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String str = ioInput.readLine();
            System.out.println("Hello "+str + " kun");
            System.out.println("Enter your weight:");
            String w = ioInput.readLine();
            System.out.println("Enter your height:");
            String h = ioInput.readLine();
            
            System.out.println("Your Weight * height : "+ parseDouble(w)*parseDouble(h));
        } catch (IOException ex) {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
