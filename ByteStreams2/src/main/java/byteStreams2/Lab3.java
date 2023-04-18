package byteStreams2;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 {
    public static void main(String[] args) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.dat"));
            dataOutputStream.writeUTF("Jim Henry");
            dataOutputStream.writeInt(30);
            dataOutputStream.writeDouble(65.5);
            dataOutputStream.writeChar('A');
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.dat"));
            String readAFile = dataInputStream.readUTF();
            int age = dataInputStream.readInt();
            double score = dataInputStream.readDouble();
            char grade = dataInputStream.readChar();
            System.out.printf("name: %s, Age : %d, Score : %.2f, Grade : %s",readAFile,age,score,grade);
            dataInputStream.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
