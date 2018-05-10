import java.util.*;
import java.io.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        System.out.println("reversed string is= "+reverseString(sb));
        scanner.close();
    }
    private static String reverseString(StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<sb.length(); i++) {
           if(sb.charAt(i) != ' ') {
                stack.push(sb.charAt(i));
            } else {
                sb2.append(' ');
                Character ch = (Character) stack.pop();
                while(ch != null) {
                    sb2.append(ch);
                    ch = (Character) stack.pop();
                }
            }
        }
        return sb2.toString();
    }
}