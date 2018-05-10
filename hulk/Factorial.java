public class Factorial {
    public static void main(String args[]) {
        final int num = 10;
        for(int i =0; i< num; i++) {
            System.out.println(fact(i));
        }

    }

    public static int fact(int num) {
        if(num == 1 || num == 0) {
            return 1;
        } else {
            return num*fact(num-1);
        }
    }
}