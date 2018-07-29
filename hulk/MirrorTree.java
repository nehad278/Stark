class Node {
    int data;
    Node left;
    Node right;
    public Node(int d) {
        data = d;
        left = right = null;
    }
}
class MirrorTree {
    static Node root;
    public MirrorTree(int d) {
        root = new Node(d);
    }
    public MirrorTree() {
        root = null;
    }
    public static Node mirror(Node root) {
        if(root.left == null && root.right == null) {
            return root;
        } else {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.right!= null) {
                mirror(root.right);
            }
            if(root.left != null) {
                mirror(root.left);
            }
           return root;
        }
    }
    public static void printTree(Node root) {
        while(root.left != null || root.right != null) {
            System.out.println("--left " + root.left.data);
            System.out.println("--right " + root.right.data);
            printTree(root.left);
            printTree(root.right);
        }
    }
    public static void main(String[] args) {
        root = new Node(2);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left = new Node(5);
        root.right = new Node(19);
        root.right.left = new Node(11);
        root.right.left.right = new Node(8);

        System.out.println("--"+ root);
        mirror(root);
        printTree(root);
        
    }
}