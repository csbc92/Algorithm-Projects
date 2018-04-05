public class DictBinTree implements Dict {
    private Node root;
    private int treeSize;
    private int counterOrderedTraversal; //For use in inorder walk.


    public DictBinTree() {
        this.root = null;
        this.treeSize = 0;
        this.counterOrderedTraversal = 0;
    }

    @Override
    public void insert(int k) {
        Node y = null;
        Node x = root;
        Node z = new Node(k);
        while(x != null){
            y = x;
            if(z.getKey() < x.getKey()){
                x = x.getLeft();
            } else{
                x = x.getRight();
            }
        }
        if(y == null){
            //Tree was empty
            this.root = z;
        } else if(z.getKey() < y.getKey()){
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
        treeSize++;
    }

    @Override
    public int[] orderedTraversal() {
        int[] orderedNumbers = new int[treeSize];
        inorderTreeWalk(root,orderedNumbers);
        counterOrderedTraversal = 0; //Reset for next use.
        return orderedNumbers;
    }

    private void inorderTreeWalk(Node x, int[] orderedNumbers) {
        if(x != null){
            inorderTreeWalk(x.getLeft(), orderedNumbers);
            orderedNumbers[counterOrderedTraversal] = x.getKey(); //Add to sorted array
            counterOrderedTraversal++; //Count up the index for next insertion
            inorderTreeWalk(x.getRight(), orderedNumbers);
        }
    }

    @Override
    public boolean search(int k) {
        boolean isInTree;
        if(searchRecursively(root,k) == null){
            isInTree = false;
        } else {
            isInTree = true;
        }
       return isInTree;
    }

    private Node searchRecursively(Node x, int k) {
        if(x == null || k == x.getKey()){
            return x;
        }
        if(k < x.getKey()){
            return searchRecursively(x.getLeft(),k);
        } else {
            return searchRecursively(x.getRight(),k);
        }
    }
}
