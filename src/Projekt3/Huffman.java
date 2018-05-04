package Projekt3;

public class Huffman {


    public static Element<Node> huffman(int[] freqTable){
        int n = freqTable.length;
        PQ queue = new PQHeap(n);

        for (int byteValue = 0; byteValue < freqTable.length; byteValue++) {
            int freq = freqTable[byteValue];
            Element<Node> element = new Element<>(freq,new Node(null,null, byteValue)); //Node is the data of elements. No children present at the beginning.
            queue.insert(element);
        }

        for (int i = 0; i < n - 1; i++) {
            Element<Node> left = queue.extractMin();
            Element<Node> right = queue.extractMin();
            int freqSum = left.key + right.key;
            Node subTree = new Node(left.data,right.data,-1);
            Element<Node> newElement = new Element<>(freqSum,subTree);
            queue.insert(newElement);
        }

        return queue.extractMin(); //Return the root of the tree
    }

}
