import java.util.*;
import java.lang.*;

class Binarian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i =0; i< n;i++) {
            arr[i] = in.nextInt();
            sum += Math.pow(2, arr[i]);
        }
        findBinarian(sum);      
        
        
    }
    private static void findBinarian(int sum) {
       // int tempSum = sum;
        double temp = 0;
        int j=0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(sum > 0) {
           // System.out.print("---te tee");
            temp = Math.pow(2, j);
            if( sum >= temp && Math.pow(2, j+1) > sum) {
                result.add(j);
                sum = sum - (int)temp;
                temp = 0;
                j = 0;
            }
            j++;
        }
        System.out.println("Required Sum is = " + result.size());
    }
}