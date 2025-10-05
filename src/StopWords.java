import java.io.*;
import java.util.*;

public class StopWords {
    private ArrayList<String> words;

    public StopWords(String filePath) {
        words = new ArrayList<>();
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

    public boolean isStopWord(String w) {
        return words.contains(w.toLowerCase());
    }
}
