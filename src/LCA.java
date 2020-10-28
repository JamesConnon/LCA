import java.lang.*;
class Node
{
    Integer data;
    Node left, right;

    public Node(Integer item)
    {
        data = item;
        left = right = null;
    }
}


public class LCA {

    Node root;

    Node findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }


    Node findLCA(Node node, int n1, int n2) {
        // Base case
        if (node == null)
            return null;


        if (node.data == n1 || node.data == n2)
            return node;


        Node leftLca = findLCA(node.left, n1, n2);
        Node rightLca = findLCA(node.right, n1, n2);


        if (leftLca != null && rightLca != null)
            return node;


        return (leftLca != null) ? leftLca : rightLca;

    }

    public String printBinaryTree(Node node) {
        if( node.data == null)
        {
            return "-null\n";
        }
        else
        {
            return printBinaryTree(root, "");
        }
    }

    public String printBinaryTree(Node node, String prefix)
    {
        String dash = "-";
        String newLine = "\n";
        if(node == null)
        {
            return prefix + "-null\n";
        }
        else
        {
            String binaryTreeString = prefix + dash + node.data.toString() + newLine +
                    printBinaryTree(node.left, (prefix + " |")) +
                    printBinaryTree(node.right, (prefix + "  "));
            return binaryTreeString;
        }
    }
    public static void main(String[] args) {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


        System.out.println("LCA(4, 5) = " +
                tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " +
                tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                tree.findLCA(2, 4).data);
        String s = tree.printBinaryTree(tree.root);
        System.out.print(s);
    }

}


