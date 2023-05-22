import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCapitalizer {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String capitalizedLine = capitalizeWords(line);
                writer.write(capitalizedLine + "\n");
            }
            System.out.println("Content has been capitalized and written to output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String capitalizeWords(String line) {
        StringBuilder result = new StringBuilder();
        String[] words = line.split("\\s+");
        for (String word : words) {
            if (word.length() > 0) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                String rest = word.substring(1);
                result.append(firstChar).append(rest).append(" ");
            }
        }
        return result.toString().trim();
    }
}
