package translation;

import binarytree.BinaryTree;
import binarytree.TreeBuilder;
import table.Table;

public class Encoding {
    private final Table table;
    private final Translation translation;
    private final String encodedMessage;

    public Encoding(String message) {
        TreeBuilder treeBuilder = new TreeBuilder(message);
        table = treeBuilder.getTable();
        translation = new Translation(table);
        encodedMessage = translation.encodeMessage(message, false);
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public Table getTable() {
        return table;
    }
}
