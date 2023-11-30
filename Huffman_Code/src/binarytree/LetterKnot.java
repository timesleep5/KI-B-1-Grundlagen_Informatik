package binarytree;

import java.util.Arrays;

public class LetterKnot extends Knot {
    private final char letter;

    LetterKnot(int usageCount, char letter) {
        super(usageCount);
        this.letter = letter;
    }

    @Override
    String[][] getLetterPaths(String[][] paths, String currentPath) {
        return addLetterPathToPaths(paths, currentPath);
    }

    private String[][] addLetterPathToPaths(String[][] paths, String currentPath) {
        String[][] newPaths = Arrays.copyOf(paths, paths.length + 1);
        String[] newPath = new String[]{String.valueOf(letter), currentPath + branchValue};
        newPaths[paths.length] = newPath;
        return newPaths;
    }

    @Override
    public String toString() {
        return "\n  Letter: " + letter + super.toString();
    }
}
