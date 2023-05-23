import java.io.*;
import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            BufferedWriter bf = new BufferedWriter(new FileWriter("./myBmi.txt"));
            System.out.print("Enter your name:");
            String name = sc.nextLine();
            System.out.print("Enter your weight:");
            double w = sc.nextDouble();
            System.out.print("Enter your height:");
            double h = sc.nextDouble();
            bf.write(name);
            bf.newLine();
            bf.write(String.valueOf(w));
            bf.newLine();
            bf.write(String.valueOf(h));
            bf.flush();
            bf.close();
        } catch (IOException e){
            e.getStackTrace();
        }

        try{
            Scanner scRead = new Scanner(new FileReader("./myBmi.txt"));
            String name = scRead.nextLine();
            double w = scRead.nextDouble();
            double h = scRead.nextDouble();
            System.out.println("Name:" + name + "Weight" + w + "Height" + h);
        } catch (IOException e){
            e.getStackTrace();
        }
    }
}
