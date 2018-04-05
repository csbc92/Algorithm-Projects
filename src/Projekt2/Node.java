/**
 * Node implementation
 *
 * Lavet af Christian Skafte Beck Clausen (chcla15) og Daniel Johansen (dajoh16)
 */
public class Node {
    private Node left;
    private Node right;
    private int key;

    /**
     * Creates a new node with left child, right child and the given key value
     * @param left
     * @param right
     * @param key
     */
    public Node(Node left, Node right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

    /**
     * Creates a new node with the given key value, and null values for children
     * @param key
     */
    public Node(int key) {
        this(null,null,key);
    }

    /**
     * Set the left child
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Set the right child
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * get the left child
     * @return
     */
    public Node getLeft() {
        return left;
    }

    /**
     * get the right child
     * @return
     */
    public Node getRight() {
        return right;
    }

    /**
     * Gets the key of the node
     * @return
     */
    public int getKey() {
        return key;
    }
}
