package binarytree;

import table.Table;

public class BinaryTree {
    private final SourceKnot source;

    BinaryTree(SourceKnot source) {
        this.source = source;
    }

    void setBranchValues() {
        source.setBranchValues();
    }

    Table buildEncodingTable() {
        String[][] paths = source.getLetterPaths(new String[][]{}, "");
        return addPathsToTable(paths);
    }

    private Table addPathsToTable(String[][] paths) {
        Table table = new Table();
        for (String[] path : paths) {
            char letter = path[0].charAt(0);
            String encoding = path[1];
            table.addLetter(letter, encoding);
        }
        return table;
    }

    @Override
    public String toString() {
        return source.toString();
    }
}
