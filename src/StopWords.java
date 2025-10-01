import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StopWords {

    public static void main(String[] args) {
        String filePath = "C://Users//jakes//Downloads//stopwords.txt/"; //

        try {
            // Read all lines from the text file into a List
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Print out each line
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}