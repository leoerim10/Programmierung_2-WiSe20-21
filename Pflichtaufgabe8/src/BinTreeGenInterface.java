
public interface BinTreeGenInterface<E extends Comparable<E>> {

    /**
     * counts all nodes in the subtree of k (inclusive k)
     * @param k given node
     * @return number of nodes in the subtree of k
     */
    public abstract int countNodes(BinNodeGen<E> k);

    /**
     * counts all nodes in the treee
     * @return number of nodes
     */
    public abstract int countNodes();

    /**
     * inserts an item into a sorted subtree if the item does not already exist
     * and returns true, if the item was successfully inserted
     * @param item to be inserted
     * @return true, if item was successfully inserted
     */
    public abstract boolean insertNode(E item);

    /**
     * searches for an item in a sorted subtree
     * @param item to search for
     * @return node with the searches item
     */
    public abstract BinNodeGen<E> find(E item);

    /**
     * returns all nodes of the subtree of k as a String
     * @param k given node
     * @return String representation of the subtree of k
     */
    public abstract String toString(BinNodeGen<E> k);

    /**
     * returns all nodes of the tree as a String
     * @return String representation of the tree
     */
    public abstract String toString();

}
