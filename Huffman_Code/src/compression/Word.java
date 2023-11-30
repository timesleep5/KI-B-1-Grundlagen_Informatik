package compression;

public class Word {
    private final char letter;
    private final int wordOccurrences;
    private final int messageLength;
    private final double probability;
    private final String encoding;
    private final int wordLength;

    public Word(char letter, int wordOccurrences, int messageLength, String encoding) {
        this.letter = letter;
        this.wordOccurrences = wordOccurrences;
        this.messageLength = messageLength;
        this.probability = wordOccurrences / (double) messageLength;
        this.encoding = encoding;
        this.wordLength = encoding.length();
    }


    public double getProbability() {
        return probability;
    }

    public int getWordLength() {
        return wordLength;
    }
}
