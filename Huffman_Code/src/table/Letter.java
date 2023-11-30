package table;

public class Letter {
    private final char letter;
    private final String encoding;


    Letter(char letter, String encoding) {
        this.letter = letter;
        this.encoding = encoding;
    }

    public char getLetter() {
        return letter;
    }

    public String getEncoding() {
        return encoding;
    }
}
