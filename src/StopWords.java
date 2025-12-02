import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The StopWords class is responsible for loading and storing
 * a list of stop words (common words to ignore during text processing).
 * It reads the stop words from a file, one per line, and provides
 * a method to check if a given word is a stop word.
 */
public class StopWords {
    // Stores all stop words loaded from the file
    private Set<String> words;

    /**
     * Constructor that reads stop words from the given file path.
     * Each line in the file is treated as a single stop word.
     * @param filePath the path to the stop words file
     */
    public StopWords(String filePath) {
        words = new HashSet<>();
        try {
            Scanner sc = new Scanner(new File(filePath));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim().toLowerCase();
                if (!line.equals("")) {
                    words.add(line);
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Problem reading stopwords file.");
        }
    }

    /**
     * Checks whether a given word is a stop word.
     * @param w the word to check
     * @return true if the word exists in the stop words list; false otherwise
     */
    public boolean isStopWord(String w) {
        return words.contains(w.toLowerCase());
    }
}
