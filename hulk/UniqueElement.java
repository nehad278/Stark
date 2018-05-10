import java.util.HashMap;
import java.util.Map;

class UniqueElement {
    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    private static void findUnique( Node head, HashMap<Integer, Integer> map  ) {
        map.put(head.data, 0);
        while(head != null) {
            Integer val = map.get(head.data);
            if(val == null) {
                map.put(head.data, 1);
            } else {
                map.put(head.data, val + 1);
            }
            head = head.next;
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet() ) {
            if(entry.getValue() == 1) {
                System.out.println("unique key is--"+ entry.getKey());
            }

        }

    } 

    public static void main(String args[]) {
        //UniqueElement list = new UniqueElement();
        head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next = new Node(3);

        HashMap<Integer, Integer> map = new HashMap<>();
        findUnique(head, map);
    }
}