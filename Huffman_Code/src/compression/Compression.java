package compression;

import table.Letter;
import table.Table;

import java.util.Collection;

public class Compression {
    private final int PRECISION = 1_000;
    private final String message;
    private final String encodedMessage;
    private final Table table;
    private final Word[] wordbook;

    public Compression(String message, String encodedMessage, Table table) {
        this.message = message;
        this.encodedMessage = encodedMessage;
        this.table = table;
        this.wordbook = buildWordbook();
    }

    private Word[] buildWordbook() {
        Letter[] letters = table.getLetters();
        Word[] wordbook = new Word[letters.length];
        for (int index = 0; index < letters.length; index++) {
            Letter letter = letters[index];
            int occurrences = occurrenceAmount(letter.getLetter());
            wordbook[index] = new Word(letter.getLetter(), occurrences, message.length(), letter.getEncoding());
        }
        return wordbook;
    }

    private int occurrenceAmount(char letter) {
        return message.length() - message.replace(String.valueOf(letter), "").length();
    }

    public void printPercentageOfUnicodeSize() {
        float huffmanLength = encodedMessage.length();
        float unicodeLength = message.length() * 16;
        float percentage = Math.round((huffmanLength / unicodeLength) * 10_000) / 100f;
        System.out.println("The Huffman-Code has " + percentage + "% of the size the Unicode-Notation (16 bit) would have:");
        System.out.println("Huffman: " + (int) huffmanLength + " bit");
        System.out.println("Unicode: " + (int) unicodeLength + " bit");
    }

    public void printAverageWordLength() {
        double averageWordLength = (double) Math.round(calculateAverageWordLength() * PRECISION) / PRECISION;
        System.out.println("Average Word Length of the Huffman Code: " + averageWordLength + " bit");
    }

    public void printEntropy() {
        double entropy = (double) Math.round(calculateEntropy() * PRECISION) / PRECISION;
        System.out.println("Entropy of the message: " + entropy + " bit");
    }


    private double calculateEntropy() {
        double entropy = 0;
        for (Word word : wordbook) {
            entropy += word.getProbability() * log2(word.getProbability());
        }
        return -entropy;
    }

    private double calculateAverageWordLength() {
        double averageWordLength = 0;
        for (Word word : wordbook) {
            averageWordLength += word.getProbability() * word.getWordLength();
        }
        return averageWordLength;
    }

    private double log2(double x) {
        return (Math.log(x) / Math.log(2));
    }
}
