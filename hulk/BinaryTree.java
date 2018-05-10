class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        right = left = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree(int key) {
        root = new Node(key);
    }

    public BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(2);
        tree.root.left.right = new Node(28);
        tree.root.right.right = new Node(9);
        System.out.println(tree);
    }
}