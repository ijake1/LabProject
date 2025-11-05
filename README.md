# Lab Project

## This project is to code a program that runs basic text analysis with the goal of comparing articles about the same topics.

- **Group Members**:
    - Lauren Lanning
    - Jake Samuel
    - Isabela Arteaga

### Article Topics: 
1. Why owning a dog is good
2. Why owning a cat is good
3. Soccer

## Milestone 2 Abstract
After this milestone is completed the software application is able to preprocess the files downloaded into the library, removes the stopwords, calculates basic statistics, and ranks words by frequencies. It is also able to highlight differences between articles related to each topic like finding the richest vocabulary, repeated words, and attitudes of articles.

To achieve this, we collected and articles about the same topics. Then each article is processed by preforming the following tasks:
1. **Loading Text Files:** The FileLoader class reads text content from article files and puts the content into an array list of individual words while removing punctuation.
2. **Stop Words Removal:** Using the StopWords class, common stop words are filtered out from the array list leaving only meaniful terms.
3. **Basic Statistics:** A method in the FileLoader class displays the total word cound and the number of unique words remaining after the removal of stop words.
4. **Word Frequency Ranking:** The frequency disribution of the remaining words is calculated and displayed, helping to identify key terms used in each article.
5. **Which article used the richest Vocabulary?** We used the richestVocab method in the ArticleList class to compare the number of unique words in each article and determine which had the richest vocabulary.
6. **What list of words were repeated the most per article?** We used the top5Words method in the ArticleList class to identify and display the five most frequently used words in each article.
7. **Which articles expressed "positive" vs "negative" attitude**

The application is composed using four distinct classes- Main, FileLoader, StopWords, and ArticleList. These seperate classes ensure clarity and processing that will help with more advanced features in future milestones.

<img src="DiagramforMilestone2.png" alt="UML Diagram for Milestone 2">

