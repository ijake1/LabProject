import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileLoader {
    private ArrayList<String> words = new ArrayList<>();
    private String filename;

public FileLoader(String filename) {
    this.filename = filename;
}

public void loadFile() {
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
    System.out.println(articleList);
}
    public ArrayList<String> getWords() {
        return words;
    }

}


