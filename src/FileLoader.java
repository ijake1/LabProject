// Java Program to Illustrate reading from
// FileReader using FileReader class

// Importing input output classes
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Main class
// ReadingFromFile
public class FileLoader {

    // Main driver method
    public static void main(String[] args) throws Exception
    {
        List<Character> article = new ArrayList<>();  // List to store characters

        // Passing the path to the file as a parameter
        FileReader fr = new FileReader(
                "C:/Users/haoli/articles/test1.txt");

        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1){
            article.add((char) i);
        }

        for (Character ch : article) {
            System.out.print(ch);
        }
    }
}