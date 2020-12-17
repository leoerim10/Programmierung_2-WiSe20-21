public class BinTreeGen<E extends Comparable<E>> implements BinTreeGenInterface<E> {

    BinNodeGen<E> root;
    static final int COUNT = 10;

    public BinTreeGen(){
        root = null;
    }

    public BinTreeGen(BinNodeGen<E> root) {
        this.root = root;
    }

    public BinTreeGen(E item) {
        this(new BinNodeGen<E>(item, null, null));
    }



    @Override
    public int countNodes(BinNodeGen<E> k) {
        int counter = 0;
        if(k != null){
            counter = 1 + countNodes(k.left) + countNodes(k.right);
        }
        return counter;
    }


    @Override
    public int countNodes() {
        int count = countNodes(root);
        return count;
    }


    @Override
    public boolean insertNode(E item) {
        if(item == null) {
            return false;
        }
        if(find(root, item) != null) {
            return false;
        }
        BinNodeGen<E> newNode = new BinNodeGen<E>(item);
        insertNode(root, newNode);
        return true;
    }

    /**
     * inserts an item into a sorted subtree if the item does not already exist
     * and returns true, if the item was successfully inserted
     * @param root given root
     * @param newNode new node
     */
    private void insertNode(BinNodeGen<E> root, BinNodeGen<E> newNode) {
        if(root != null) {
            if(newNode.data.compareTo(root.data) < 0) {
                if(root.left == null) {
                    root.left = newNode;
                } else {
                    insertNode(root.left, newNode);
                }
            }
            if (newNode.data.compareTo(root.data) > 0) {
                if(root.right == null) {
                    root.right = newNode;
                } else {
                    insertNode(root.right, newNode);
                }
            }
        }
        if(root == null) {
        }
    }


    @Override
    public BinNodeGen<E> find(E item){
        BinNodeGen<E> node = find(root, item);
        return node;
    }

    /**
     * searches for an item in a sorted subtree
     * @param root given root
     * @param item to search for
     * @return node with the searched item
     */
    private BinNodeGen<E> find(BinNodeGen<E> root, E item){
        if(root != null){
            if(item.compareTo(root.data) == 0){
                return root;
            } else {
                if(item.compareTo(root.data) < 0){
                    return find(root.left, item);
                } else if(item.compareTo(root.data) > 0){
                    return find(root.right, item);
                }
            }
        }
        return null;
    }


    @Override
    public String toString(BinNodeGen<E> k) {
        return treeString(k);
    }


    @Override
    public String toString() {
        return treeString(root);
    }

    /**
     * returns nodes of the tree as a String
     * @param n given node
     * @return String representation of the tree
     */
    private String treeString(BinNodeGen<E> n) {
        if(n == null)
            return "";
        return n.data.toString() + "\n" + treeString(n.left) + treeString(n.right);
    }



    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * prints the given tree
     */
    public void print2D() {
        print2D(root, 0);
    }

    /**
     * prints the given tree
     * @param root given root
     * @param space distance between the level
     */
    private void print2D(BinNodeGen<E> root, int space) {
        // Base case
        if (root == null)
            return;
        // Increase distance between levels
        space += COUNT;
        // Process right child first
        print2D(root.right, space);
        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");
        // Process left child
        print2D(root.left, space);
    }

}

