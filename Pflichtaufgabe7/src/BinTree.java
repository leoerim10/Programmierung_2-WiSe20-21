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
    public boolean isSorted(BinNode k){
        if(k != null){
            if(!isSorted(k.left)){
                return false;
            }

            if (k.data <= prev){ // prev = int.minvalue first time, second time..
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
    public boolean isSorted() throws NullPointerException{
        if (root == null){
            throw new NullPointerException("The tree is empty");
        }
        return isSorted(root);
    }


    /**
     * wrapper method to removeNode(int value)
     * @param value value of the node to be removed
     * @return true if it is successfully removed
     */
    public boolean removeNode(int value) {
        return (removeNode(getRoot(), value) != null);
    }


    /**
     * deletes the node from a sorted binary tree which holds the given value
     * the tree should remain sorted after a node is deleted
     * @param k current node
     * @param value value of the node to be removed
     * @return removed node
     * @throws NullPointerException if removed node is not presented in the tree
     */
    public BinNode removeNode(BinNode k, int value) throws NullPointerException{
        if(k == null){
            throw new NullPointerException("given value is not in the tree");
        }
        if(value < k.data){ // search in left part of the tree if the given value is smaller than the actual value
            k.left = removeNode(k.left, value);
        }else if(value > k.data){ // search in right part of the tree if the given value is larger than the actual value
            k.right = removeNode(k.right, value);
        }else{ // node to be removed is found
            if (k.left == null && k.right == null){
                return null;
            }else if(k.right == null){
                return k.left; // replaces the node with its left child
            }else if(k.left == null){
                return k.right;  // replaces the node with its right child
            }else{
                k.data = minValue(k.right); // finds the smallest node and overwrites the value
                k.right = removeNode(k.right, k.data); // delete the node form the right subtree
            }
        }
        return k;
    }
    /**
     * return the minimum value from the tree
     * @param k given node
     * @return the minimum value
     */
    public int minValue(BinNode k){
        if (k.left != null){
            return minValue(k.left);
        }
        return k.data;
    }

    /**
     * insert a node in a binary tree
     * @param neu the new node to be inserted
     * @param k given node
     *   TODO document exception
     */
    private void insertNode(BinNode neu, BinNode k)throws IllegalArgumentException{
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
                throw new IllegalArgumentException("node with this data already exists");
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




    public void printBinTree(BinNode b){
        if(b!=null){
            System.out.print("(");
            printBinTree(b.left);
            System.out.print(" " + b.data + " ");
            printBinTree(b.right);
            System.out.print(")");
        }
    }

    public void printBinTree() { //Verpackungsmethode
        printBinTree(root);
    }

}
