package byteStreams2;

import java.io.*;

public class Lab4 {
    public static void main(String[] args) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("data.dat"));
            String s = "Welcome to my world.";
            byte [] b = s.getBytes();
            bufferedOutputStream.write(b);
            bufferedOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("data.dat"));
            while (bufferedInputStream.read() != -1){
                System.out.println(bufferedInputStream.read()+" "+ (char) bufferedInputStream.read());
            }
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
