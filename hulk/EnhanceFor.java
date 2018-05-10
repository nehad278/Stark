public class EnhanceFor {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7};
        sum(list);
        sumError(list);
    }
    public static void sum(int[] list) {
        int sum = 0;
        for(int i= 0; i<list.length; i++) {
            sum += list[i];
        }
        System.out.println("func 1 ="+sum);
    }

    public static void sumError(int[] list) {
        int sum = 0;
        for( int val: list) {
            sum += val;
        }
        System.out.println("func 2 = "+sum);
    }
}