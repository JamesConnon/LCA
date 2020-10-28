
import org.junit.Test;

import static org.junit.Assert.*;

public class LCATestJava {

    //Null Returned for empty tree
    @Test
    public void testIsEmpty()
    {
        LCA tree = new LCA();
        assertNull(tree.findLCA(0, 0));
    }

    //5. Checking LCA if only one Node -  Should return self
    @Test
    public void testOneNodeBinaryTree()
    {
        LCA tree = new LCA();

        tree.root = new Node(4);
        assertEquals(4, (int) tree.findLCA(4, 4).data);
    }

    @Test
    public void testBalancedTree(){
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        assertEquals(2, (int) tree.findLCA(4, 5).data);
        assertEquals(1, (int) tree.findLCA(4, 6).data);
        assertEquals(1, (int) tree.findLCA(3, 4).data);
        assertEquals(3, (int) tree.findLCA(6, 7).data);
        assertEquals(1, (int) tree.findLCA(3, 5).data);
        assertEquals(1, (int) tree.findLCA(5, 7).data);
        //Print function only used to help identify correct answer for assert statement
        //would be removed for large binary tree's
        System.out.print(tree.printBinaryTree(tree.root));
    }

    //Test unbalanced tree left
    @Test
    public void testLeftSubtree()
    {
        LCA tree = new LCA();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.left.left = new Node(4);
        tree.root.left.left.left.left = new Node(5);
        tree.root.left.left.left.left.left = new Node(6);
        assertEquals(3, (int) tree.findLCA(3, 6).data);
    }

    //Test unbalanced tree right
    @Test
    public void testRightSubtree()
    {
        LCA tree = new LCA();

        tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(3);
        tree.root.right.right.right = new Node(4);
        tree.root.right.right.right.right = new Node(5);
        tree.root.right.right.right.right.right= new Node(6);
        assertEquals(3, (int) tree.findLCA(3, 6).data);
    }



}