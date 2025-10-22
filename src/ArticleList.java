import java.util.ArrayList;

public class ArticleList {
    private ArrayList<String> words;

    public ArticleList(ArrayList<String> words) {
        this.words = new ArrayList<>(words);
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public ArrayList<String> removeStopWords(StopWords stop) {
        ArrayList<String> filtered = new ArrayList<>();
        for (String w : words) {
            if (!stop.isStopWord(w)) {
                filtered.add(w);
            }
        }
        return filtered;
    }

    public ArrayList<String> uniqueWords() {
        ArrayList<String> unique = new ArrayList<>();
        for (String w : words) {
            if (!unique.contains(w)) {
                unique.add(w);
            }
        }
        return unique;
    }

    public void countWordFrequency() {
        ArrayList<String> wordsUsed = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (String w : words) {
            w = w.toLowerCase();
            if (wordsUsed.contains(w)) {
                int index = wordsUsed.indexOf(w);
                counts.set(index, counts.get(index) + 1);
            } else {
                wordsUsed.add(w);
                counts.add(1);
            }
        }

        System.out.println();
        System.out.println("Word Frequency Ranking:");
        for (int i = 0; i < wordsUsed.size(); i++) {
            System.out.println(wordsUsed.get(i) + ": " + counts.get(i));
        }
    }

    public void richestVocab(ArticleList a1, ArticleList a2, ArticleList a3) {
        int uniqueWords1 = a1.uniqueWords().size();
        int uniqueWords2 = a2.uniqueWords().size();
        int uniqueWords3 = a3.uniqueWords().size();
        if(uniqueWords1 > uniqueWords2 && uniqueWords1 > uniqueWords3) {
            System.out.println("The article with the richest vocabulary is article 1 with " + a1.uniqueWords().size() + " unique words.");
        } else if (uniqueWords2 > uniqueWords1 && uniqueWords2 > uniqueWords3) {
            System.out.println("The article with the richest vocabulary is article 2 with " + a2.uniqueWords().size() + " unique words.");
        } else if (uniqueWords3 > uniqueWords1 && uniqueWords3 > uniqueWords2) {
            System.out.println("The article with the richest vocabulary is article 2 with " + a2.uniqueWords().size() + " unique words.");
        } else {
            System.out.println("Cannot determine which article has the richest vocabulary.");
        }
    }
}
