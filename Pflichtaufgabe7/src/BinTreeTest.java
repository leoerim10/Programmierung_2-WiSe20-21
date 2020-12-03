import static org.junit.Assert.*;

import org.junit.Before;
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
    public void countTwoChildrenNodes2() { // counting Abb.2
        assertEquals(2, tree4.countTwoChildrenNodes());
    }


    @Test(expected = NullPointerException.class)
    public void isSortedEmptyTree() { // sorting an empty tree
        tree1.isSorted();
    }


    @Test
    public void isSortedWithOneRoot() { // sorting tree with a single root
        assertEquals(true, tree2.isSorted());
    }


    @Test
    public void isSorted1() { // sorting tree from Abb.1
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
        assertEquals(true, tree3.isSorted());
    }


    @Test
    public void isSorted2() {// sorting tree from Abb.2
        assertEquals(false, tree4.isSorted());

    }


    @Test(expected = NullPointerException.class)
    public void removeNodeEmpty() { // removing node from a empty tree
        tree1.removeNode(11);
    }


    @Test
    public void removeNodeSingleRoot() { // removing node from a tree with a root
        assertEquals(false, tree2.removeNode(1));
    }


    @Test
    public void removeNodeSortedTree() { //removing a node from a tree form Abb.1
        assertEquals(true, tree3.removeNode(3));
        assertEquals(true, tree3.isSorted());

        assertEquals(true, tree3.removeNode(9));
        assertEquals(true, tree3.isSorted());

        assertEquals(true, tree3.removeNode(4));
        assertEquals(true, tree3.isSorted());

        assertEquals(true, tree3.removeNode(7));
        assertEquals(true, tree3.isSorted());
    }

   

    @Test(expected = NullPointerException.class)
    public void removeNode10() { // removing a node from Abb. 1 which do not exist
        tree1.removeNode(10);
    }




}