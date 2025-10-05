import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {  // <— Exception, not just IOException
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter folder path: ");
        String folderPath = br.readLine().trim();
        if (folderPath.startsWith("\"") && folderPath.endsWith("\"")) {
            folderPath = folderPath.substring(1, folderPath.length()-1);
        }

        StopWords stop = new StopWords("C:/Users/jakes/Downloads/stopwords.txt");
        FileLoader loader = new FileLoader();

        ArrayList<String> tokens = loader.loadWordsFromFolder(folderPath); // must exist in FileLoader

        HashMap<String,Integer> freq = new HashMap<>();
        for (String w : tokens) {
            if (!stop.isStopWord(w)) {
                if (freq.containsKey(w)) freq.put(w, freq.get(w) + 1);
                else freq.put(w, 1);
            }
        }

        int totalAfter = 0;
        for (int c : freq.values()) totalAfter += c;

        System.out.println("\nTotal words (after stopwords): " + totalAfter);
        System.out.println("Unique words: " + freq.size());

        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        System.out.println("\nTop 20 words:");
        for (int i = 0; i < 20 && i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }
    }
}

