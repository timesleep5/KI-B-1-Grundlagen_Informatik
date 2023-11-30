package table;

import java.util.Arrays;

public class Table {
    private Letter[] letters;

    public Table() {
        letters = new Letter[0];
    }

    public void addLetter(char letter, String encoding) {
        letters = Arrays.copyOf(letters, letters.length + 1);
        letters[letters.length - 1] = new Letter(letter, encoding);
    }

    public String getEncodingFor(char wantedLetter) {
        for (Letter letter : letters) {
            if (letter.getLetter() == wantedLetter) {
                return letter.getEncoding();
            }
        }
        return "";
    }

    public char getDecodingFor(String encodedString) {
        for (Letter letter : letters) {
            if (encodedString.equals(letter.getEncoding())) {
                return letter.getLetter();
            }
        }
        return 0;
    }

    public boolean isEncoding(String binaryString) {
        for (Letter letter : letters) {
            if (binaryString.equals(letter.getEncoding())) {
                return true;
            }
        }
        return false;
    }

    public Letter[] getLetters() {
        return letters;
    }
}
