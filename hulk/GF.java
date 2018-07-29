import java.util.*;

class GF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter A, B and N");
        int x = findSolution(in.nextInt(), in.nextInt(), in.nextInt());
        System.out.println("Answer is = " + x%1000000007);
    }
    private static int findSolution(int A, int B, int N) {
        if(N == 0) {
            return A;
        } else if(N == 1) {
            return B;
        } else {
            return findSolution(A, B, N-1) + findSolution(A, B, N-2); 
        }
    }
}