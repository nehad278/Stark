import java.util.Scanner;
import java.util.*;

public class KMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int[] input = new int[N];

        for(int i = 0; i< N; i++) {
            input[i] = in.nextInt();
        }
        in.close();

        findKMax(input, N, K);
    }

    private static void findKMax(int[] input, int N, int K) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int i=0; i<K; i++) {
            pQueue.add(input[i]);
        }
        for(int i = K; i < N; i++) {
            if(input[i] > pQueue.peek()) {
                pQueue.poll();
                pQueue.add(input[i]);
            }
        }
        Iterator<Integer> itr2 = pQueue.iterator();
        while (itr2.hasNext()) {
            System.out.println("->" + itr2.next());
        }
    }
}