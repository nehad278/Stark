import java.io.*;
import java.util.*;
class Stack{
    int top;
    final static int max = 1000;
    int[] a = new int[max];
    int maxVal = 0;
    Stack() {
        top = -1;
    }
    boolean isEmpty() {
        return (top < 0);
    }
    boolean push(int d) {
        if( top >= max) {
            return false;
        } else {
            maxVal = maxVal > d ? maxVal : d;
            ++top;
            a[top] = d;
            return true;
        }
    }
    int pop() {
        if(top < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            int x = a[top];
            if(x == maxVal) {
                maxVal = 0;
            }
             top--;
            return x;
        }
    }
    
    int maxValue() {
        return maxVal;
    }
}

public class StackOperation {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] arr = new String[N]; 
        for(int i = 0; i< N ; i++) {
            int j = in.nextInt();
            
            //int j = Integer.parseInt(arr[i].split(" ")[0]);
            if(j == 1) {
                int x = in.nextInt();
                stack.push(x);                        
                                         
            } else if(j == 2) {
                stack.pop();
                
            } else if(j == 3) {
                System.out.println(stack.maxValue());
            }
        }
    }
}