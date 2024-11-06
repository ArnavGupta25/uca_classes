public class BST {
    class Node {
        Integer key;
        Integer val;
        Node left;
        Node right;

        Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BST(){
        this.root=null;
    }

    public Integer get(Integer key) {
        return get(root, key);
    }

    private Integer get(Node root, Integer key) {
        if (root == null) {
            return null;
        }

        if (key == root.key) {
            return root.val;
        }

        else if (key < root.key) {
            return get(root.left, key);
        }

        else {
            return get(root.right, key);
        }
    }

    public void put(Integer key, Integer val) {
        root = put(root, key, val);
    }

    private Node put(Node root, Integer key, Integer val) {
        if (root == null) {
            return new Node(key, val);
        }

        if (key == root.key) {
            root.val = val;
        }

        else if (key < root.key) {
            root.left = put(root.left, key, val);
        }

        else {
            root.right = put(root.right, key, val);
        }

        return root;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        
        bst.put(5, 3);
        bst.put(7, 3);
        bst.put(3, 5);
        bst.put(1, 6);
        bst.put(9, 1);

        assert bst.get(7)== 3;
        assert bst.get(11)== null;
        assert bst.get(1)== 6;
    }
}