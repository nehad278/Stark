import java.util.Scanner;

class Node {
    Node left, right;
    int data;
    public Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}
public class LCA {
    Node root;
    public LCA() {
        root = null;
    }
    private void insert(int d) {
        root = insertRec(root, d);
    }

    private Node insertRec(Node node, int d) {
        if(node == null) {
            node = new Node(d);
            return node;
        } else if(d < node.data) {
            node.left = insertRec(node.left, d);
        } else {
            node.right = insertRec(node.right, d);
        }
        return node;
    }
    private Node findLCA(int x, int y) {
        return findLcaRec(root, x, y);
    }
    private static Node findLcaRec( Node root, int x, int y) {
        if(x < root.data && y < root.data) {
            return findLcaRec(root.left, x, y);
        }
        if(x > root.data && y > root.data) {
            return findLcaRec(root.right, x, y);
        }
        return root;

    }
    private void inOrder() {
        inOrderRec(root);
    }
    private void inOrderRec(Node node) {
        if(node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        LCA tree = new LCA();
        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.inOrder();
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();
        tree.inOrder();
        System.out.println("provide values are = "+ x + " and " + y);
        System.out.println("LCA is = " + tree.findLCA(x, y).data);
    }
}