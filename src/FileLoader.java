import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLoader {
private String filename;

public FileLoader(String filename) {
    this.filename = filename;
}

private void loadFile() {
    String filePath1 = filename;
    String article1 = "";
    try {
        // Read all lines from the text file into a List
        List<String> lines1 = Files.readAllLines(Paths.get(filePath1));
        for (String line : lines1) {
            article1 += line + " ";
        }
    } catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }
    article1 = article1.replaceAll("[^a-zA-Z0-9\\s]", "");
    String[] a1 = article1.split("\\s+");
    ArrayList<String> dogArticle1 = new ArrayList<>(Arrays.asList(a1));
    System.out.println("Article 1: " + dogArticle1);
}
}
