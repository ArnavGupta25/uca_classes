// import java.util.*;

public class BST {
    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public boolean isBST(Node root) {
        return helper(root, null, null);
    }

    private boolean helper(Node root, Integer minval, Integer maxval) {
        if (root == null) {
            return true;
        }

        if ((minval != null && root.val <= minval) || (maxval != null && root.val >= maxval)) {
            return false;
        }

        return helper(root.left, minval, root.val) && helper(root.right, root.val, maxval);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = tree.new Node(4);
        root.left = tree.new Node(2);
        root.right = tree.new Node(5);
        root.left.left = tree.new Node(1);
        root.left.right = tree.new Node(3);

        System.out.println("Is BST: " + tree.isBST(root)); 
    }
}