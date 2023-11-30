package binarytree;

public class SourceKnot extends Knot {
    SourceKnot(int usageCount, Knot left, Knot right) {
        super(usageCount, left, right);
    }

    @Override
    String[][] getLetterPaths(String[][] paths, String currentPath) {
        if (left != null) {
            paths = left.getLetterPaths(paths, currentPath);
        }
        if (right != null) {
            paths = right.getLetterPaths(paths, currentPath);
        }
        return paths;
    }
}
