import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        FileLoader loader = new FileLoader();
        ArrayList<String> words = loader.loadWords();


        StopWords stop = new StopWords("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/stopwords.txt");


        ArrayList<String> filtered = new ArrayList<>();
        for (String w : words) {
            if (!stop.isStopWord(w)) {
                filtered.add(w);
            }
        }


        System.out.println("Total words: " + words.size());
        System.out.println("  ");
        System.out.println("After removing stopwords: " + filtered.size());
    }
}


