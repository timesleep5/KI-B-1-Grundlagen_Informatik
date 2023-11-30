package translation;

import table.Table;

public class Decoding {
    private final String decodedMessage;
    private final Translation translation;
    public Decoding(String encodedMessage, Table table) {
        translation = new Translation(table);
        decodedMessage = translation.decodeMessage(encodedMessage);
    }

    public String getDecodedMessage() {
        return decodedMessage;
    }
}
