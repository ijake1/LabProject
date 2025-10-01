import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static void main(String[] args) throws Exception
    {
        //first dog article
        List<Character> dogArticle1 = new ArrayList<>();
        FileReader fr1 = new FileReader(
                "C:/Users/haoli/articles/test1.txt");
        int i1;
        while ((i1 = fr1.read()) != -1){
            dogArticle1.add((char) i1);
        }
        for (Character ch : dogArticle1) {
            System.out.print(ch);
        }

        //second dog article
        List<Character> dogArticle2 = new ArrayList<>();
        FileReader fr2 = new FileReader(
                "C:/Users/haoli/articles/test1.txt");
        int i2;
        while ((i2 = fr2.read()) != -1){
            dogArticle2.add((char) i2);
        }
        for (Character ch : dogArticle2) {
            System.out.print(ch);
        }

        //third dog article
        List<Character> dogArticle3 = new ArrayList<>();
        FileReader fr3 = new FileReader(
                "C:/Users/haoli/articles/test1.txt");
        int i3;
        while ((i3 = fr3.read()) != -1){
            dogArticle1.add((char) i3);
        }
        for (Character ch : dogArticle3) {
            System.out.print(ch);
        }
    }
}