class Node
{
    int data;
    Node left, right;

    public Node(int item)
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
    public static void main(String[] args) {


    }

}


