import static org.junit.Assert.*;

import org.junit.Test;

public class BinTreeTest {

    @Test
    public void testCountNodesEmpty() {
        BinTree tree = new BinTree();
        assertEquals(0, tree.countNodes(tree.getRoot()));
    }

    @Test
    public void testCountNodesRoot() {
        BinTree tree = new BinTree();
        tree.insertNode(1);
        assertEquals(1, tree.countNodes(tree.getRoot()));
    }

    @Test
    public void testCountNodes1() {
        BinTree tree = new BinTree();
        tree.insertNode(7);
        tree.insertNode(9);
        tree.insertNode(4);
        tree.insertNode(2);
        tree.insertNode(8);
        assertEquals(5, tree.countNodes(tree.getRoot()));
    }

    @Test
    public void testCountTwoChildrenNodesEmpty() {
        BinTree tree = new BinTree();
        assertEquals(0, tree.countTwoChildrenNodes());
    }

    @Test
    public void testCountTwoChildrenNodesRoot() {
        BinNode root = new BinNode(1);
        BinTree tree = new BinTree(root);
        assertEquals(0, tree.countTwoChildrenNodes());
    }

    @Test
    public void testCountTwoChildrenNodes1() {
        BinTree tree = new BinTree();
        tree.insertNode(7);
        tree.insertNode(4);
        tree.insertNode(9);
        tree.insertNode(2);
        tree.insertNode(5);
        tree.insertNode(8);
        tree.insertNode(1);
        tree.insertNode(3);
        assertEquals(3, tree.countTwoChildrenNodes());
    }

    @Test
    public void testCountTwoChildrenNodes2() {
        BinTree tree = new BinTree();
        tree.insertNode(6);
        tree.insertNode(4);
        tree.insertNode(9);
        tree.insertNode(2);
        tree.insertNode(7);
        tree.insertNode(5);
        assertEquals(2, tree.countTwoChildrenNodes(tree.getRoot()));
    }
}