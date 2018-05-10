import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the arrayManipulation function below.
     */
    static int arrayManipulation(int n, int[][] queries) {
        int[] a = new int[n];
        Arrays.fill(a, 0);
       
        int rows = queries[0].length;
        for(int i= 0; i< rows; i++) {
            
            
            for(int j =queries[i][0]-1; j<queries[i][1]; j++) {
                a[j] = a[j] + queries[i][2];
            }
        }
        int max = a[0];
         for(int i= 0; i< n; i++) {
             if(a[i] > max) {
                 max = a[i];
             }
         }
        return max;
        /*
         * Write your code here.
         */

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[][] queries = new int[m][3];

        for (int queriesRowItr = 0; queriesRowItr < m; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
