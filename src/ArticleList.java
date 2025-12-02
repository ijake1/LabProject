import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    
    private Map<String, Integer> buildFrequencyMap() {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            String lower = w.toLowerCase();
            freq.put(lower, freq.getOrDefault(lower, 0) + 1);
        }
        return freq;
    }

    public void countWordFrequency() {
        Map<String, Integer> freq = buildFrequencyMap();

        System.out.println();
        System.out.println("Word Frequency Ranking:");
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void richestVocab(ArticleList a1, ArticleList a2, ArticleList a3) {
        int uniqueWords1 = a1.uniqueWords().size();
        int uniqueWords2 = a2.uniqueWords().size();
        int uniqueWords3 = a3.uniqueWords().size();
        if(uniqueWords1 > uniqueWords2 && uniqueWords1 > uniqueWords3) {
            System.out.println("The article with the richest vocabulary is article 1 with " + uniqueWords1 + " unique words.");
        } else if (uniqueWords2 > uniqueWords1 && uniqueWords2 > uniqueWords3) {
            System.out.println("The article with the richest vocabulary is article 2 with " + uniqueWords2 + " unique words.");
        } else if (uniqueWords3 > uniqueWords1 && uniqueWords3 > uniqueWords2) {
            System.out.println("The article with the richest vocabulary is article 3 with " + uniqueWords3 + " unique words.");
        } else {
            System.out.println("Cannot determine which article has the richest vocabulary.");
        }
    }

    public void top5Words() {
        Map<String, Integer> freq = buildFrequencyMap();

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());

        ArrayList<String> wordsUsedTop5 = new ArrayList<>();
        ArrayList<Integer> countsTop5 = new ArrayList<>();

        for (int i = 0; i < 5 && !entries.isEmpty(); i++) {
            Map.Entry<String, Integer> best = entries.get(0);
            int bestIndex = 0;

            for (int j = 1; j < entries.size(); j++) {
                if (entries.get(j).getValue() > best.getValue()) {
                    best = entries.get(j);
                    bestIndex = j;
                }
            }

            wordsUsedTop5.add(best.getKey());
            countsTop5.add(best.getValue());
            entries.remove(bestIndex);
        }

        System.out.println("Word Frequency Top 5 Ranking:");
        for (int i = 0; i < wordsUsedTop5.size(); i++) {
            System.out.println(wordsUsedTop5.get(i) + ": " + countsTop5.get(i));
        }
    }

    public void attitude() {
        String filePath = "files/lexicon_scores.txt";
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

        double score = 0;
        for(String w : words) {
            for(String k : lexiScores.keySet()) {
                if(w.equals(k)) {
                    score = score + lexiScores.get(k);
                }
            }
        }

        if(score >= 3) {
            System.out.println("The article is very positive with a lexicon score of " + score + ".");
        } else if (score > 0) {
            System.out.println("The article is positive with a lexicon score of " + score + ".");
        } else if (score == 0) {
            System.out.println("The article is neutral with a lexicon score of " + score + ".");
        } else if (score > -3) {
            System.out.println("The article is negative with a lexicon score of " + score + ".");
        } else {
            System.out.println("The article is very negative with a lexicon score of " + score + ".");
        }
    }
}
