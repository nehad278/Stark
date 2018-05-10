import java.util.Scanner;

public class TakeValueScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //for(int i=0; i<4; i++) {
            String y = scanner.nextLine();
            int x = scanner.nextInt();
            
            System.out.println("enter number = "+x);
            System.out.println("enter string = "+y);
        //}
        scanner.close();
    }
}