package byteStreams2;

import java.io.*;

public class Lab5 {
    public static void main(String[] args) {
        var s1 = new Student(1,"Bom");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("obj.dat"));
            objectOutputStream.writeObject(s1);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("obj.dat"));
            Student newS = (Student) objectInputStream.readObject();
            String name = newS.name;
            int id = newS.id;
            System.out.println(name+ " id:" + id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
