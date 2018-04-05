public class Node {
    private Node left;
    private Node right;
    private int key;

    public Node(Node left, Node right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

    public Node(int key) {
        this(null,null,key);
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getKey() {
        return key;
    }
}
