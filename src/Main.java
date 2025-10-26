import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FileLoader file1 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle1.txt");
        FileLoader file2 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle2.txt");
        FileLoader file3 = new FileLoader("C:/Users/laure/OneDrive/Documents/Programming Lab/Dog Articles/DogArticle3.txt");

        //FileLoader file1 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle1.txt");
        //FileLoader file2 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle2.txt");
        //FileLoader file3 = new FileLoader("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/Articles/Catarticle3.txt");

        ArticleList article10 = new ArticleList(file1.loadFile());
        ArticleList article20 = new ArticleList(file2.loadFile());
        ArticleList article30 = new ArticleList(file3.loadFile());

        System.out.println();
        System.out.println("File 1 Total Words: " + article10.getWords().size());
        System.out.println("File 2 Total Words: " + article20.getWords().size());
        System.out.println("File 3 Total Words: " + article30.getWords().size());

        //StopWords stop = new StopWords("C:/Users/jakes/OneDrive/Desktop/CPSC 2231/Lab Project/stopwords.txt");
        StopWords stop = new StopWords("C:/Users/laure/OneDrive/Documents/Programming Lab/stopwords.txt");

        ArrayList<String> file1R = new ArrayList<>(article10.removeStopWords(stop));
        ArrayList<String> file2R = new ArrayList<>(article20.removeStopWords(stop));
        ArrayList<String> file3R = new ArrayList<>(article30.removeStopWords(stop));

        ArticleList article1 = new ArticleList(file1R);
        ArticleList article2 = new ArticleList(file2R);
        ArticleList article3 = new ArticleList(file3R);

        System.out.println();
        System.out.println("File 1 Total Words After Removing Stop Words: " + file1R.size());
        System.out.println("File 2 Total Words After Removing Stop Words: " + file2R.size());
        System.out.println("File 3 Total Words After Removing Stop Words: " + file3R.size());

        System.out.println();
        System.out.println("File 1 Total Unique Words: " + article1.uniqueWords().size());
        System.out.println("File 2 Total Unique Words: " + article2.uniqueWords().size());
        System.out.println("File 3 Total Unique Words: " + article3.uniqueWords().size());

        System.out.println();
        System.out.println("File 1 Word Frequency Ranking:");
        article1.countWordFrequency();

        System.out.println();
        System.out.println("File 2 Word Frequency Ranking:");
        article2.countWordFrequency();

        System.out.println();
        System.out.println("File 3 Word Frequency Ranking:");
        article3.countWordFrequency();

        System.out.println();
        article1.richestVocab(article1, article2, article3);

        System.out.println();
        article1.top5Words();
        System.out.println();
        article2.top5Words();
        System.out.println();
        article3.top5Words();
    }
}
