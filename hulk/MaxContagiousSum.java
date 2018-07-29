import java.util.*;

class MaxContagiousSum {
    static Scanner in = new Scanner(System.in);
    static int num = in.nextInt();
    public static void main(String[] args) {
        int[] arr = new int[num];
        for(int i=0; i< num; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        maxSum(arr);
    }
    
    private static void maxSum(int[] arr) {
        int maxFinal = 0;
        int maxTemp = 0;
        int indexStart =0, indexEnd = 0, temp = 0;
        for(int i=0; i< num; i++) {
            maxTemp += arr[i];
            if(maxTemp < 0) {
                maxTemp = 0;
                temp = i + 1;

            }
            if(maxTemp > maxFinal) {
                maxFinal = maxTemp;
                indexStart = temp;
                indexEnd = i;
            }
        }
        System.out.println("Max sum of contagious sub array is = " + maxFinal);
        System.out.println("Indexes are = " + indexStart + " and " + indexEnd);
    }
}