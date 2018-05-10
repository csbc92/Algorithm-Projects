package Projekt3;

public class Huffman {

    private static StringBuilder sb = new StringBuilder();

    public static Element<Node> huffman(int[] freqTable) {
        int n = freqTable.length;
        PQ queue = new PQHeap(n);

        for (int byteValue = 0; byteValue < freqTable.length; byteValue++) {
            int freq = freqTable[byteValue];
            Element<Node> element = new Element<>(freq, new Node(null, null, byteValue)); //Node is the data of elements. No children present at the beginning.
            queue.insert(element);
        }

        for (int i = 0; i < n - 1; i++) {
            Element<Node> left = queue.extractMin();
            Element<Node> right = queue.extractMin();
            int freqSum = left.key + right.key;
            Node subTree = new Node(left.data, right.data, -1);
            Element<Node> newElement = new Element<>(freqSum, subTree);
            queue.insert(newElement);
        }

        return queue.extractMin(); //Return the root of the tree
    }

    public static String[] convertToVariableLengthCodeWords(Element<Node> rootElement) {
        String[] variableLengthCodeWords = new String[256];
        //Recursive inorder tree walk, that create variable length code words for each byte (Leaf in the huffman tree).
        inorderTreeWalk(variableLengthCodeWords, rootElement.data);
        return variableLengthCodeWords;
    }

    /**
     * Recursive inorder tree walk
     * @param variableLengthCodeWords The array that is filled with variable length code words, where the index is the byte value
     * @param x a node
     */
    private static void inorderTreeWalk(String[] variableLengthCodeWords, Node x) {
        if(x != null){
            if(x.getLeft() == null && x.getRight() == null){
                //Leaf node. Insert code word
                variableLengthCodeWords[x.getKey()] = sb.toString();
            }
            //Append 0 if we go left in the tree
            sb.append("0");
            inorderTreeWalk(variableLengthCodeWords,x.getLeft());
            //Clean when we go back up the tree
            sb.deleteCharAt(sb.length() - 1);

            //Append 1 if we go right in the tree
            sb.append("1");
            inorderTreeWalk(variableLengthCodeWords,x.getRight());
            //Clean when we go back up the tree. The StringBuilder is empty at the root node.
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
