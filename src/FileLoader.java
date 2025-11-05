import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The FileLoader class reads the contents of a text file,
 * cleans the text by removing punctuation, and stores all words
 * in an ArrayList<String> for later use.
 */
public class FileLoader {
    // Stores all words extracted from the file
    private ArrayList<String> words = new ArrayList<>();
    // The name (or path) of the file to be read
    private String filename;

    // Constructor that accepts a file name or path
    public FileLoader(String filename) {
        this.filename = filename;
    }

    /**
     * Reads the file line by line, concatenates its contents,
     * removes punctuation, splits the text into words,
     * and stores them in an ArrayList.
     * @return an ArrayList<String> containing all cleaned words from the file
     */
    public ArrayList<String> loadFile() {
        String filePath = filename;
        String article = "";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                article += line + " ";
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        article = article.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] a = article.split("\\s+");
        ArrayList<String> articleList = new ArrayList<>(Arrays.asList(a));
        words.addAll(articleList);
        return articleList;
    }
}
