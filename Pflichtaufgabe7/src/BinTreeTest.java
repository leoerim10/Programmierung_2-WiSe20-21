import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinTreeTest {
    private static BinTree tree1, tree2, tree3, tree4;
    private static BinNode root2, root3, root4;


    @BeforeClass
    public static void setUp() {
        tree1 = new BinTree(); // empty tree

        root2 = new BinNode(1); // tree with a single root
        tree2 = new BinTree(root2);

        root3 = new BinNode(7); // tree form Abb.1
        tree3 = new BinTree(root3);
        // 1st level
        root3.right = new BinNode(9);
        root3.left = new BinNode(4);
        //2nd level
        root3.right.left = new BinNode(8);
        root3.left.right = new BinNode(5);
        root3.left.left = new BinNode(2);
        //3rd level
        root3.left.left.right = new BinNode(3);
        root3.left.left.left = new BinNode(1);

        root4 = new BinNode(6);  // tree from Abb.2
        tree4 = new BinTree(root4);
        // 1st level
        root4.right = new BinNode(9);
        root4.left = new BinNode(4);
        // 2nd level
        root4.left.left = new BinNode(2);
        root4.left.right = new BinNode(7);
    }



    @Test
    public void countTwoChildrenNodesEmptyTree() { // counting nodes for a empty tree
        assertEquals(0, tree1.countTwoChildrenNodes());
    }


    @Test
    public void countTwoChildrenNodesWithOneRoot() { // counting nodes for a tree with only root
        assertEquals(0, tree2.countTwoChildrenNodes());
    }


    @Test
    public void countTwoChildrenNodes1() { // counting nodes for Abb.1
        assertEquals(3, tree3.countTwoChildrenNodes());
    }


    @Test
    public void countTwoChildrenNodes2() { // counting nodes for Abb.2
        assertEquals(2, tree4.countTwoChildrenNodes());
    }


    @Test(expected = NullPointerException.class)
    public void isSortedEmptyTree() { // checking if it throws an exception trying to sort an empty tree
        tree1.isSorted();
    }


    @Test
    public void isSortedWithOneRoot() { // checking if the tree with a single root is sorted or not
        assertTrue(tree2.isSorted());
    }


    @Test
    public void isSorted1() { // checking if the given tree from Abb.1 is sorted or not
        assertTrue(tree3.isSorted());
    }


    @Test
    public void isSorted2() {// checking if the given tree from Abb.2 is sorted or not
        assertFalse(tree4.isSorted());

    }


    @Test(expected = NullPointerException.class)
    public void removeNodeEmpty() { // checking if it throws an exception while trying to remove a node from an empty tree
        tree1.removeNode(11);
    }


    @Test
    public void removeNodeSingleRoot() { // removing node from a tree just with a root
        assertFalse(tree2.removeNode(1));
    }


    @Test
    public void removeNodeSortedTree() { //removing a node from a tree form Abb.1
        assertTrue(tree3.removeNode(3));
        assertTrue(tree3.isSorted()); // checking if the tree is still sorted after a node gets removed

        assertTrue(tree3.removeNode(9));
        assertTrue(tree3.isSorted());

        assertTrue(tree3.removeNode(4));
        assertTrue(tree3.isSorted());

        assertTrue(tree3.removeNode(7));
        assertTrue(tree3.isSorted());
    }


    @Test(expected = NullPointerException.class)
    public void removeNode10() { // checking if it throws an exception while trying to remove a node which does not exist in Abb.1
        tree3.removeNode(10);
        assertTrue(tree3.isSorted());
    }

}