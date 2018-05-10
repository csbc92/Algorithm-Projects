import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Encode implementation.
 * Lavet af Christian Skafte Beck Clausen Chcla15 og Daniel Johansen Dajoh16
 */
public class Encode {

    public static void main(String[] args) {
        int[] freqTable = new int[256]; //Indexes are byte values (ints) and values are frequency
        String[] variableLengthCodeWords = null;

        try (FileInputStream inFile = new FileInputStream(args[0])) {

            while (inFile.available() > 0) {
                int index = inFile.read();
                freqTable[index]++;
            }
            Element<Node> rootElement = Huffman.huffman(freqTable);
            variableLengthCodeWords = Huffman.convertToVariableLengthCodeWords(rootElement);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream outFile = new FileOutputStream(args[1]);) {
            BitOutputStream outBitStream = new BitOutputStream(outFile);
            for (int i = 0; i < freqTable.length; i++) {
                outBitStream.writeInt(freqTable[i]);
            }
            try (FileInputStream inFile = new FileInputStream(args[0])) {
                while (inFile.available() > 0) {
                    int index = inFile.read();
                    String codeWord = variableLengthCodeWords[index];
                    for (int charIndex = 0; charIndex < codeWord.length(); charIndex++) {
                        char charAt = codeWord.charAt(charIndex);
                        int bit = Integer.parseInt( ""+charAt);
                        outBitStream.writeBit(bit);
                    }
                }

            }
            outBitStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
