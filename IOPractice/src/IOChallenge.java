import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOChallenge {
        public static void main(String[] args) throws Exception{
        java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        List<String> list = new ArrayList<>();

        //3: Prompt the user to enter lines of text and store them in 'lines' list

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        while (true) {
            try {
                if (!((text = bufferedReader.readLine()) != null && !text.isEmpty())) {
                    bufferedReader.close();
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            list.add(text);

        }

        //5: Write each line to the file using BufferedWriter

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("StoreText.txt"));
            for (var l : list){
                bufferedWriter.write(l);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("StoreText.txt"));
            String output;
            System.out.println("Output:");
            while ((output = bufferedReader1.readLine()) != null){
                System.out.println(output);
            }
            bufferedReader1.close();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}