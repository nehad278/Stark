class LinkListLoop {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    boolean detectLoop() {
        Node pointer1 = head, pointer2 = head;
        while(pointer1 != null && pointer2 != null && pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
            if(pointer1 == pointer2) {
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        LinkListLoop linklist = new LinkListLoop();
        linklist.push(12);
        linklist.push(1);
        linklist.push(11);
        linklist.push(14);

        linklist.head.next.next.next = linklist.head;
        System.out.println("Loop found => "+ linklist.detectLoop());

    }
}