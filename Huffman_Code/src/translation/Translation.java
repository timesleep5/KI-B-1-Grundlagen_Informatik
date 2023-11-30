package translation;

import table.Table;

import java.util.Arrays;

public class Translation {
    private final Table table;

    Translation(Table table) {
        this.table = table;
    }

    String encodeMessage(String message, boolean readable) {
        StringBuilder encodedMessage = new StringBuilder();

        for (int letter = 0; letter < message.length(); letter++) {
            String letterEncoding = table.getEncodingFor(message.charAt(letter));
            encodedMessage.append(letterEncoding);
            if (readable) {
                encodedMessage.append(" ");
            }
        }
        return encodedMessage.toString();
    }

    String decodeMessage(String encodedMessage) {
        String[] components = splitIntoComponents(encodedMessage);
        StringBuilder decodedMessage = new StringBuilder();

        for (String component : components) {
            char letter = table.getDecodingFor(component);
            decodedMessage.append(letter);
        }
        return decodedMessage.toString();
    }

    private String[] splitIntoComponents(String encodedString) {
        StringBuilder encodedMessage = new StringBuilder(encodedString);
        String[] components = new String[0];
        while (!encodedMessage.isEmpty()) {
            for (int range = 1; range <= encodedMessage.length(); range++) {
                String encoding = encodedMessage.substring(0, range);
                if (table.isEncoding(encoding)) {
                    encodedMessage.delete(0, range);
                    components = addEncoding(components, encoding);
                }
            }
        }
        return components;
    }

    private String[] addEncoding(String[] components, String encoding) {
        components = Arrays.copyOf(components, components.length + 1);
        components[components.length - 1] = encoding;
        return components;
    }
}
