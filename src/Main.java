import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //FileLoader file1 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle1.txt");
        // FileLoader file2 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle2.txt");
        // FileLoader file3 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle3.txt");

        FileLoader file1 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle1.txt");
        FileLoader file2 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle2.txt");
        FileLoader file3 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle3.txt");

        file1.loadFile();
        file2.loadFile();
        file3.loadFile();

        System.out.println();
        System.out.println("File 1 Total Words: " + file1.getWords().size());
        System.out.println("File 2 Total Words: " + file2.getWords().size());
        System.out.println("File 3 Total Words: " + file3.getWords().size());

        StopWords stop = new StopWords("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/stopwords.txt");
        //StopWords stop = new StopWords("C:/Users/laure/OneDrive/Documents/Programming Lab/stopwords.txt");

        ArrayList<String> file1R = new ArrayList<>(file1.removeStopWords(stop));
        ArrayList<String> file2R = new ArrayList<>(file2.removeStopWords(stop));
        ArrayList<String> file3R = new ArrayList<>(file3.removeStopWords(stop));

        System.out.println();
        System.out.println("File 1 Total Words After Removing Stop Words: " + file1R.size());
        System.out.println("File 2 Total Words After Removing Stop Words: " + file2R.size());
        System.out.println("File 3 Total Words After Removing Stop Words: " + file3R.size());

        System.out.println();
        System.out.println("File 1 Total Unique Words: " + file1.uniqueWords(file1R).size());
        System.out.println("File 2 Total Unique Words: " + file2.uniqueWords(file2R).size());
        System.out.println("File 3 Total Unique Words: " + file3.uniqueWords(file3R).size());

        System.out.println();
        System.out.println("File 1 Word Frequency Ranking:");
        file1.countWordFrequency(file1R);

        System.out.println();
        System.out.println("File 2 Word Frequency Ranking:");
        file2.countWordFrequency(file2R);

        System.out.println();
        System.out.println("File 3 Word Frequency Ranking:");
        file3.countWordFrequency(file3R);

    }
}
