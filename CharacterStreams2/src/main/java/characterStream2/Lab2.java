
package characterStream2;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab2 {
    public static void main(String[] args) {
        try{
            FileWriter out = new FileWriter("Data1.txt");
            out.write("Hello world");
            out.write("Welcome to JAVA");
            out.close();
        }catch (IOException e){
            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, e);
        }
        try{
            FileReader in = new FileReader("Data1.txt");
            int ch;
            while ((ch = in.read()) != -1){
                System.out.println((char) ch);
            }
        }catch (IOException e){
            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
