class Node {
    int key;
    Node left, right;
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree{
    Node root;
    public BinarySearchTree() {
        root = null;
    }

    private void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        } else if(key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else {
            root.right = insertRecursive(root.right, key);
        }

        return root;

    }

    private void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
            if(root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(1);
        bst.insert(2);
        bst.insert(-2);
        bst.insert(9);
        bst.insert(0);
        bst.inorder();
    }
}