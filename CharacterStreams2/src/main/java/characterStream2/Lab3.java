package characterStream2;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            PrintWriter output = new PrintWriter("Data1.txt");
            output.write("Harry Potter is my baby.\n");
            output.println(19);
            output.println(60.5);
            output.println(175.0);
            output.flush();
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { //read example 1
            FileReader in = new FileReader("Data1.txt");
            BufferedReader input = new BufferedReader(in);
            String s;
            while ((s = input.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, e);
        }
        //read example 2
        Scanner sc = new Scanner(new FileReader("Data1.txt"));
        String ss = sc.nextLine();
        System.out.println(ss);
        int age = sc.nextInt();
        System.out.println(age);
        double weight = sc.nextDouble();
        System.out.println(weight);
        double height = sc.nextDouble();
        System.out.println(height);
    }
}
