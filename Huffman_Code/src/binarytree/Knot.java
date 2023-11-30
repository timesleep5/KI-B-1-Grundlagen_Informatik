package binarytree;

public class Knot {
    private final int usageCount;
    protected int branchValue;
    protected Knot left;
    protected Knot right;

    Knot(int usageCount) {
        this.usageCount = usageCount;
    }

    Knot(int usageCount, Knot left, Knot right) {
        this(usageCount);
        this.left = left;
        this.right = right;
    }

    void setBranchValues() {
        if (left != null) {
            left.setBranchValue(0);
            left.setBranchValues();
        }
        if (right != null) {
            right.setBranchValue(1);
            right.setBranchValues();
        }
    }

    /* {
     *  {'A', "001"},
     *  {'B', "010"},
     *  {'C', "011"}
     * }
     */
    String[][] getLetterPaths(String[][] paths, String currentPath) {
        if (left != null) {
            paths = left.getLetterPaths(paths, currentPath+branchValue);
        }
        if (right != null) {
            paths = right.getLetterPaths(paths, currentPath+branchValue);
        }
        return paths;
    }

    void setBranchValue(int branchValue) {
        this.branchValue = branchValue;
    }

    int getUsageCount() {
        return usageCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String left = this.left != null ? this.left.toString() : "null";
        String right = this.right != null ? this.right.toString() : "null";

        stringBuilder.append("\nUsage: ").append(usageCount);
        stringBuilder.append("\nBranch value: ").append(branchValue);
        stringBuilder.append("\nLeft child: ").append(left);
        stringBuilder.append("\nRight child: ").append(right);

        return (stringBuilder.toString()).indent(2);
    }
}
