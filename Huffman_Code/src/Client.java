import compression.Compression;
import table.Table;
import translation.Decoding;
import translation.Encoding;

public class Client {
    public static void main(String[] args) {
        String message = "ALLE MEINE ENTCHEN";
        System.out.println("Message: " + message);

        Encoding encoding = new Encoding(message);
        String encodedMessage = encoding.getEncodedMessage();
        Table table = encoding.getTable();
        System.out.println("Encoded Message: " + encodedMessage + "\n");

        Compression compression = new Compression(message, encodedMessage, table);
        compression.printPercentageOfUnicodeSize();
        compression.printEntropy();
        compression.printAverageWordLength();

        Decoding decoding = new Decoding(encodedMessage, table);
        String decodedMessage = decoding.getDecodedMessage();
        System.out.println("\nDecoded Message: " + decodedMessage);
    }
}
