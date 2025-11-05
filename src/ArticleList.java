import java.util.ArrayList;

/**
 * The ArticleList class represents a list of words extracted from an article.
 * It provides various text processing utilities such as:
 *  - Removing stop words
 *  - Finding unique words
 *  - Counting word frequencies
 *  - Comparing vocabulary richness between articles
 *  - Identifying the top 5 most frequent words
 *  - Evaluating sentiment (attitude) based on a lexicon file
 */
public class ArticleList {
    // Stores all words in the article
    private ArrayList<String> words;

    /**
     * Constructor that initializes the ArticleList with a given list of words.
     * Creates a copy of the input list to avoid modifying the original.
     * @param words list of words extracted from an article
     */
    public ArticleList(ArrayList<String> words) {
        this.words = new ArrayList<>(words);
    }

    /**
     * Getter method to retrieve the list of words.
     * @return ArrayList of words in the article
     */
    public ArrayList<String> getWords() {
        return words;
    }

    /**
     * Removes stop words (common words like "the", "and", etc.)
     * using a provided StopWords object.
     * @param stop a StopWords object containing the list of stop words
     * @return a new ArrayList<String> with stop words removed
     */
    public ArrayList<String> removeStopWords(StopWords stop) {
        ArrayList<String> filtered = new ArrayList<>();
        for (String w : words) {
            if (!stop.isStopWord(w)) {
                filtered.add(w);
            }
        }
        return filtered;
    }

    /**
     * Returns a list of unique words from the article.
     * @return ArrayList<String> containing only unique words
     */
    public ArrayList<String> uniqueWords() {
        ArrayList<String> unique = new ArrayList<>();
        for (String w : words) {
            if (!unique.contains(w)) {
                unique.add(w);
            }
        }
        return unique;
    }

    /**
     * Counts and prints the frequency of each word in the article.
     */
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

    /**
     * Compares three ArticleList objects and determines
     * which article has the richest vocabulary (most unique words).
     * @param a1 first article
     * @param a2 second article
     * @param a3 third article
     */
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

        ArrayList<String> wordsCopy = new ArrayList<>(wordsUsed);
        ArrayList<Integer> countsCopy = new ArrayList<>(counts);
        
        ArrayList<String> wordsUsedTop5 = new ArrayList<>();
        ArrayList<Integer> countsTop5 = new ArrayList<>();

        //find the top 5 words
        for (int i = 0; i < 5; i++) {
            int mostFrequent = countsCopy.get(0);
            int frequentIndex = 0;

            for (int j = 1; j < countsCopy.size(); j++) {
                if (countsCopy.get(j) > mostFrequent) {
                    mostFrequent = countsCopy.get(j);
                    frequentIndex = j;
                }
            }

            wordsUsedTop5.add(wordsCopy.get(frequentIndex));
            countsTop5.add(countsCopy.get(frequentIndex));

            wordsCopy.remove(frequentIndex);
            countsCopy.remove(frequentIndex);
        }

        //print results
        System.out.println("Word Frequency Top 5 Ranking:");
        for (int i = 0; i < wordsUsedTop5.size(); i++) {
            System.out.println(wordsUsedTop5.get(i) + ": " + countsTop5.get(i));
        }
    }

    /**
     * Performs a simple sentiment analysis (attitude evaluation)
     * by comparing words in the article against a lexicon of word scores.
     * 
     * Each word’s score (positive or negative) contributes to an overall total.
     * Based on the total score, the article is categorized as positive,
     * neutral, or negative.
     */
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
        double score = 0;
        for(String w : words) {
            for(String k : lexiScores.keySet()) {
                if(w.equals(k)) {
                    score = score + lexiScores.get(k);
                }
            }
        }
        
        //prints attitude based on score
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
