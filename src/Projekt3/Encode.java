package Projekt3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encode {

    public static void main(String[] args) {
        FileInputStream inFile = null;
        FileOutputStream outFile = null;
        BitOutputStream outBitStream;
        int[] freqTable = new int[256]; //Indexes are byte values (ints) and values are frequency


        try {
             inFile = new FileInputStream(args[0]);
             outFile = new FileOutputStream(args[1]);
             outBitStream = new BitOutputStream(outFile);
            while(inFile.available() > 0) {
                int index = inFile.read();
                freqTable[index]++;
            }
            Element<Node> rootElement = Huffman.huffman(freqTable);
            







        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
