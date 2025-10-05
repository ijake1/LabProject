import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public ArrayList<String> loadWordsFromFolder(String folderPath) throws Exception {
        return loadWords();
    }

    public ArrayList<String> loadWords() throws Exception {
        ArrayList<String> allWords = new ArrayList<>();

        // first dog article
        List<Character> dogArticle1 = new ArrayList<>();
        FileReader fr1 = new FileReader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle1.txt"); //change this to ur dog file when try to run it - jake
        int i1;
        while ((i1 = fr1.read()) != -1) dogArticle1.add((char) i1);
        fr1.close();
        for (Character ch : dogArticle1) System.out.print(ch);
        allWords.addAll(toWords(dogArticle1));

        // second dog article
        List<Character> dogArticle2 = new ArrayList<>();
        FileReader fr2 = new FileReader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle2.txt");
        int i2;
        while ((i2 = fr2.read()) != -1) dogArticle2.add((char) i2);
        fr2.close();
        for (Character ch : dogArticle2) System.out.print(ch);
        allWords.addAll(toWords(dogArticle2));

        // third dog article
        List<Character> dogArticle3 = new ArrayList<>();
        FileReader fr3 = new FileReader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle3.txt");
        int i3;
        while ((i3 = fr3.read()) != -1) dogArticle3.add((char) i3); // fixed
        fr3.close();
        for (Character ch : dogArticle3) System.out.print(ch);
        allWords.addAll(toWords(dogArticle3));

        return allWords;
    }

    private ArrayList<String> toWords(List<Character> chars) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Character ch : chars) {
            if (Character.isLetter(ch) || ch == '\'') sb.append(Character.toLowerCase(ch));
            else if (sb.length() > 0) { words.add(sb.toString()); sb.setLength(0); }
        }
        if (sb.length() > 0) words.add(sb.toString());
        return words;
    }
}
