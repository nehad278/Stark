
class ReverseLinkList {
    static Node head;
    static class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
            next = null;
        }
    }
    private void insert(int d) {
        Node node = new Node(d);
        node.next = head;
        head = node;
        }
    private static Node reverse(Node head) {
        Node temp1 = head;
        Node temp2 = head.next;
        temp1.next = null;
        while(temp2 != null) {
            Node temp3 = temp2;
            temp2 = temp2.next;
            temp3.next = temp1;
            temp1 = temp3;
        }
        return temp1;
    }
    private static boolean checkPallindrom(Node node) {
        Node actual = node;
        Node reverse = reverse(node);
        while(actual != null) {
            if(actual.data != reverse.data) {
                return false;
            }
            reverse = reverse.next;
            actual = actual.next;
        }
        return true;
    }
    public static void main(String[] args) {
        ReverseLinkList list = new ReverseLinkList();
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        System.out.println("Reverse list is");
        //System.out.println("List is Pallindrom -> " + checkPallindrom(head));
        Node reverseList = list.reverse(head);
        while(reverseList != null) {
            System.out.print(reverseList.data + " ");
            reverseList = reverseList.next;
        }
    }
}