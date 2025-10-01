import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the Path : ");

        // Reading File name
        String path = br.readLine();

        // pass the path to the file as a parameter
        File file = new File(path);

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}
