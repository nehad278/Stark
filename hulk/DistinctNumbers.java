import java.util.*;

class DistinctNumbers {
    public static void main(String[] args) {
       Scanner in  = new Scanner(System.in);
       int num = in.nextInt();
       System.out.println("total possible numbers are = " + possibleNumbers(num));
    }
    private static int possibleNumbers(int num) {
        String str = String.valueOf(num);
        int count = 0;
        int denom = 1;
        int flagZero = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(num > 0) {
            int i = num % 10;
            num = num/10;
            Integer value = map.get(i);
            if(value == null) {
                map.put(i, 1);
            } else {
                map.put(i, 1 + value);
            }
            count++;
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getKey() == 0) {
                flagZero = entry.getValue();
            }
            if(entry.getValue() > 1) {
                denom = denom * fact(entry.getValue());
            }
        }
        int result = fact(count)/denom;
        return result - flagZero;
    }

    private static int fact(int n) {
        if( n == 0 || n == 1) {
            return 1;
        } else {
            return n*fact(n-1);
        }
    }
}