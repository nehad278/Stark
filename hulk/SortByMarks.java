import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Class name should be "Source",
// otherwise solution won't be accepted
public class Source {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] arr = new String[T];
        HashMap<Integer, String[]> map = new Hashmap<Integer, String[]>();
        for(int i=0; i< T; i++) {
            arr[i] = in.nextLine().split(", ");
            map.put(Integer.parseInt(a[i][1]),[a[0], a[2]] )
        }
        
        
        for(Map.Entry<Integer, String[]> entry: map.entrySet() ) {
            if(entry.getValue() == 1) {
                System.out.println("unique key is--"+ entry.getKey());
            }

        }
        // Output the variable to STDOUT
        System.out.println(a);
   }
}
