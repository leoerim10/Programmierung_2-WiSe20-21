import static org.junit.Assert.*;

import org.junit.Test;

public class BinTreeTest {

    @Test
    public void countNodesEmptyTree() { // case 1: with empty tree
        BinTree tree = new BinTree();
        assertEquals(0, tree.countTwoChildrenNodes());
    }

    @Test
    public void countNodesWithOneRoot() { // case 2: with just one root
        BinTree tree = new BinTree();
        tree.insertNode(1);
        assertEquals(0, tree.countTwoChildrenNodes());
    }

    @Test
    public void countGivenNodes1() { // test for Abb1 which is already sorted
        BinTree tree = new BinTree();
        tree.insertNode(7);
        tree.insertNode(9);
        tree.insertNode(4);
        tree.insertNode(2);
        tree.insertNode(8);
        tree.insertNode(5);
        tree.insertNode(3);
        tree.insertNode(1);
        assertEquals(3, tree.countTwoChildrenNodes());
    }

    @Test
    public void countGivenNodes2() { // test for Abb 2 after sorting
        BinTree tree = new BinTree();
        tree.insertNode(6);
        tree.insertNode(9);
        tree.insertNode(4);
        tree.insertNode(2);
        tree.insertNode(7);
        assertEquals(1, tree.countTwoChildrenNodes());
    }

}