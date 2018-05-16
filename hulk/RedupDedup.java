import java.util.*;


class RedupDedup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println("enter input="+ str);
        System.out.println("output is=" +deDup(str));
        System.out.println("output redup is=" +reDup(deDup(str)));
    }
    private static String deDup(String str) {
        StringBuilder sb = new StringBuilder("");
        char x = str.charAt(0);
        sb.append(str.charAt(0));
        int j=1;
        for(int i=1; i< str.length();i++) {
            if(x == str.charAt(i)) {
                j++;
            } else {
                x = str.charAt(i);
                if(j>1) {
                    sb.append(j).append(x);
                } else {
                sb.append(x);
                }
                j = 1;
            }
            if(i == str.length() -1 && j > 1) {
                sb.append(j);
            }
        }
        return sb.toString();
    }

    private static String reDup(String str) {
        char x = str.charAt(0);
        StringBuilder sb = new StringBuilder(x);
        sb.append(x);
        for(int i=1; i< str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                for(int j =1; j < Character.getNumericValue(str.charAt(i)); j++) {
                    sb.append(x);
                }
            } else {
                x = str.charAt(i);
                sb.append(x);
            }
        }
        return sb.toString();
    }
}