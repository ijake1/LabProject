import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader {
    private String folderPath;

    public FileLoader(String folderPath) {
        this.folderPath = folderPath;
    }

    public List<String> loadFiles() {
        List<String> articles = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            for (File f : files) {
                StringBuilder content = new StringBuilder();
                try (Scanner reader = new Scanner(f)) {
                    while (reader.hasNextLine()) {
                        content.append(reader.nextLine()).append("\n");
                    }
                    articles.add(content.toString()); // each file = one string
                } catch (FileNotFoundException e) {
                    System.out.println("Could not read: " + f.getName());
                    e.printStackTrace();
                }
            }
        }
        return articles;
    }
}
