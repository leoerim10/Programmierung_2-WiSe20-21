/**
 * Class BinTree <br>
 * this class implements different methods regarding binary tree
 * @author Sameer Dhimal, Wojciech Maximilian Frackowski
 */
public class BinTree {

    private BinNode root = null;
    private int prev = Integer.MIN_VALUE;

    public BinTree(){
        root = null;
    }

    public BinTree(BinNode rn){
        root = rn;
    }


    public BinNode getRoot() {
        return root;
    }





    /**
     * counts the nodes of the tree
     * @param k given node
     * @return the total number of nodes in a tree
     */
    public int countNodes(BinNode k){
        int counter = 0;
        if(k != null){
            counter = 1 + countNodes(k.left) + countNodes(k.right);
        }
        return counter;
    }





    /**
     * counts the number of nodes of the binary tree having two children nodes
     * @param k given node
     * @return the number of nodes
     */
    public int countTwoChildrenNodes(BinNode k){
        if(k == null){
            return 0;
        }
        int count = 0;
        if(k.left != null && k.right != null){
            count++;
        }
        count += (countTwoChildrenNodes(k.left) + countTwoChildrenNodes(k.right));
        return count;
    }

    /**
     * wrapper method for countTwoChildrenNodes(BinNode k)
     * @return the number of nodes
     */
    public int countTwoChildrenNodes(){
        return countTwoChildrenNodes(root);
    }





    /**
     * checks either the binary tree is sorted or not
     * @param k given node
     * @return true if the tree is sorted
     */
    public boolean isSorted(BinNode k) throws NullPointerException{
        if ( k == null){
            throw new NullPointerException("The tree is empty!!!");
        }
        if(k != null){
            if(!isSorted(k.left)){
                return false;
            }
            if (k.data <= prev){
                return false;
            }
            prev = k.data;
            return isSorted(k.right);
        }
        return true;
    }


    /**
     * wrapper method for isSorted(BinNode k)
     * @return true if the tree is sorted
     */
    public boolean isSorted(){
        return isSorted(root);
    }





    /**
     * deletes the node from a sorted binary tree which holds the given value
     * the tree should remain sorted after a node is deleted
     * @param value hold by the node that is to be deleted
     * @return true only if the node is in the tree and if its successfully deleted
     */
    public boolean removeNode(int value) throws NullPointerException{
       
        // TODO
        return true;
    }


    /**
     * insert a node in a binary tree
     * @param neu the new node to be inserted
     * @param k given node
     */
    private void insertNode(BinNode neu, BinNode k){
        if(k != null){
            if(neu.data < k.data){
                if(k.left == null){
                    k.left = neu;
                } else {
                    insertNode(neu, k.left);
                }
            }
            if (neu.data > k.data){
                if(k.right == null){
                    k.right = neu;
                }
                else{
                    insertNode(neu, k.right);
                }
            }
            if(neu.data == k.data){
                System.out.println("Knoten vorhanden");
            }
        } else {
            root = neu;
        }
    }


    /**
     * wrapper method for insertNode(BinNode neu, BinNode k)
     * includes the date for the new node that is inserted or to be inserted
     * @param data the date for the new node
     */
    public void insertNode(int data){
        BinNode n = new BinNode(data);
        insertNode(n, root);
    }


}
