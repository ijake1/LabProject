import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        //FileLoader file1 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle1.txt");
        //FileLoader file2 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle2.txt");
        //FileLoader file3 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle3.txt");

        FileLoader file1 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle1.txt");
        FileLoader file2 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle2.txt");
        FileLoader file3 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle3.txt");


        file1.loadFile();
        file2.loadFile();
        file3.loadFile();

        ArrayList<String> words = new ArrayList<>();
        words.addAll(file1.getWords());
        words.addAll(file2.getWords());
        words.addAll(file3.getWords());


        StopWords stop = new StopWords("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/stopwords.txt");
        //StopWords stop = new StopWords("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/stopwords.txt"); - put your stopwords.txt file path here

       ArrayList<String> filtered = new ArrayList<>();
       for (String w : words) {
            if (!stop.isStopWord(w)) {
                filtered.add(w);
            }
        }

        ArrayList<String> unique = new ArrayList<>();
        for (String w : filtered) {
            if (!unique.contains(w)) {
                unique.add(w);
            }
        }

        System.out.println("");
        System.out.println("Total words: " + words.size());
        System.out.println("");
        System.out.println("After removing stopwords: " + filtered.size());
        System.out.println("");
        System.out.println("Unique words: " + unique.size());
    }
}
