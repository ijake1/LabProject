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
            System.out.println("The article with the richest vocabulary is article 3 with " + a3.uniqueWords().size() + " unique words.");
        } else {
            System.out.println("Cannot determine which article has the richest vocabulary.");
        }
    }

    public void top5Words() {
        ArrayList<String> wordsUsed = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        //count word frequencies
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

        ArrayList<String> wordsUsedTop5 = new ArrayList<>();
        ArrayList<Integer> countsTop5 = new ArrayList<>();

        //find the top 5 words
        for (int i = 0; i < 5; i++) {
            int mostFrequent = counts.get(0);
            int frequentIndex = 0;

            for (int j = 1; j < counts.size(); j++) {
                if (counts.get(j) > mostFrequent) {
                    mostFrequent = counts.get(j);
                    frequentIndex = j;
                }
            }

            wordsUsedTop5.add(words.get(frequentIndex));
            countsTop5.add(counts.get(frequentIndex));

            words.remove(frequentIndex);
            counts.remove(frequentIndex);
        }

        //print results
        System.out.println("Word Frequency Top 5 Ranking:");
        for (int i = 0; i < wordsUsedTop5.size(); i++) {
            System.out.println(wordsUsedTop5.get(i) + ": " + countsTop5.get(i));
        }
    }

    public void attitude() {
        //converts lexicon score files into a map
        String filePath = "C:/Users/laure/OneDrive/Documents/Programming Lab/lexicon_scores.txt";
        Map<String, Double> lexiScores = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t", 2);

                if(parts.length == 2) {
                    String key = parts[0].trim();
                    try {
                        Double value = Double.parseDouble(parts[1].trim());
                        lexiScores.put(key, value);
                    } catch (NumberFormatException e) {
                        System.err.println("Warning: Could not create double value in line - "+ line);
                    }

                } else {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }

        //uses lexicon map to measure article score
        int score = 0;
        

        //prints attitude based on score
        if(score >= 0.8) {
            System.out.println("The article is very positive with a lexicon score of " + score + ".");
        } else if (score > 0) {
            System.out.println("The article is positive with a lexicon score of " + score + ".");
        } else if (score == 0) {
            System.out.println("The article is neutral with a lexicon score of " + score + ".");
        } else if (score > -0.8) {
            System.out.println("The article is negative with a lexicon score of " + score + ".");
        } else {
            System.out.println("The article is very negative with a lexicon score of " + score + ".");
        }
    }
}
