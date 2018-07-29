import java.io.*;
import java.util.*;

public class QueueByStack {
    public static Stack<Integer> stack1 = new Stack<Integer>();
    public static Stack<Integer> stack2 = new Stack<Integer>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ; i <= n ; i++) {
            String[] a = in.nextLine().split(" ");
            if(a[0].equals("1")) {
                enQueue(Integer.parseInt(a[1]));
            } else if(a[0].equals("2")) {
                deQueue();
            } else if(a[0].equals("3")) {
                printFront();
            }
        }
        in.close();
    }
    private static void enQueue(Integer n) {
        stack1.push(n);
    }
    private static void deQueue() {
        if(!stack2.isEmpty()) {
            stack2.pop();
        } else {
            while(!stack1.isEmpty()) {
               stack2.push(stack1.pop());
            }
            stack2.pop();
        }
    }
    private static void printFront() {
        if(!stack2.isEmpty()) {
            System.out.println(stack2.peek());
        } else if(!stack1.isEmpty()){
            while(!stack1.isEmpty()) {
               stack2.push(stack1.pop());
            }
            System.out.println(stack2.peek());
        } else {
            return;
        }
    }
}