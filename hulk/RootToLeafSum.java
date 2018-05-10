import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int k) {
        key = k;
        left = right = null;
    }
}

public class RootToLeafSum {
    Node root;

    public RootToLeafSum() {
        root = null;
    }

    private static boolean checkSum(Node root, int sum) {
        
        if(root == null) {
            return (sum == 0);
        } else {
            boolean flag = false;
            int rem = sum - root.key;
            if(rem == 0 && root.left == null && root.right == null) {
                return true;
            }
            if(root.left != null) {
                flag = flag || checkSum(root.left, rem);
            }
            
            if(root.right != null) {
                flag = flag || checkSum(root.right, rem);
            }
            return flag;
        }
    }
    
    public static void main(String[] args) {
        RootToLeafSum tree = new RootToLeafSum();

        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(3);
        tree.root.right = new Node(2);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();


        System.out.println("root to leaf sum exists? " + checkSum(tree.root, num));
    }

    
}