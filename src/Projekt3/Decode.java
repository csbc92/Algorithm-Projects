import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Decode implementation.
 * Lavet af Christian Skafte Beck Clausen Chcla15 og Daniel Johansen Dajoh16
 */
public class Decode {

    public static void main(String[] args) {
        String compressedFilePath = args[0];
        String outputFilePath = args[1];
        int[] freqTable = new int[256];
        try (FileInputStream inFile = new FileInputStream(compressedFilePath)) {
            BitInputStream bitInputStream = new BitInputStream(inFile);

            //Read the first 256 Bytes, which represent the frequency table.
            int fileByteLength = 0;
            for (int i = 0; i < 256; i++) {
                freqTable[i] = bitInputStream.readInt();
                fileByteLength += freqTable[i];
            }
            Element<Node> rootElement = Huffman.huffman(freqTable);
            try(FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                int bytesWritten = 0;
                while (bytesWritten <= fileByteLength) {
                    decodeNextSequence(rootElement.data, bitInputStream, outputStream);
                    bytesWritten++;
                }
            }
            bitInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decodeNextSequence(Node node, BitInputStream bitInputStream, FileOutputStream outputStream) throws IOException {
        if(node.getRight() == null && node.getLeft() == null){
            //Leaf node reached. Write to output. End of sequence, return out.
            outputStream.write(node.getKey());
            return;
        }
        int bit = bitInputStream.readBit();
        if(bit == 0){
            decodeNextSequence(node.getLeft(),bitInputStream,outputStream);
        } else {
            decodeNextSequence(node.getRight(),bitInputStream,outputStream);
        }

    }
}
