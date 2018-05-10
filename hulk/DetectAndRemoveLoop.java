
class DetectAndRemoveLoop {
    static Node head;
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void push(int d) {
        Node node = new Node(d);
        node.next = head;
        head = node;
    }
    
    void detectAndRemove(Node head) {
        if(head == null || head.next == null) {
            return;
        }

        Node p1 = head, p2 = head;
        p1 = p1.next;
        p2 = p2.next.next;

        while(p2 != null && p2.next != null) {
          
            if(p1 == p2) {
                break;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }

        if(p1 == p2) {
            p1 = head;
            while(p1.next != p2.next) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p2.next = null;
        }
    }

    void printList(Node head) {
        while(head != null) {
            System.out.print(" "+ head.data);
            head = head.next;
        }
    }

    public static void main(String args[]) {
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        // list.push(6);
        // list.push(7);
        
        head.next.next.next.next = head.next.next;
        list.detectAndRemove(head);

        list.printList(head);


    }
}