import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        FileLoader loader = new FileLoader();

        ArrayList<String> words = loader.loadWords();

        System.out.println("\n\nLoaded " + words.size() + " words total from the articles.");
    }
}


