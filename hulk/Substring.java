import java.util.*;
class Substring{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strArr = str.trim().split(" ");
        StringBuilder sb = new StringBuilder("");
        int flag = 0;
        for(int i=0; i < strArr.length; i++) {
            if(strArr[i].charAt(0) == '"' && strArr[i].charAt(strArr[i].length() - 1) == '"') {
                System.out.println(strArr[i]);
            } else if(strArr[i].charAt(0) == '"' && flag == 0) {
                flag = 1;
                sb.append(strArr[i] + " ");
            } else if (strArr[i].charAt(0) != '"' && flag == 1 && strArr[i].charAt(strArr[i].length() - 1) != '"') {
                sb.append(strArr[i] + " ");
            } else if(flag == 1 && strArr[i].charAt(strArr[i].length() - 1) == '"') {
                sb.append(strArr[i]);
                flag = 0;
                System.out.println(sb.toString());
                sb = new StringBuilder("");
            } else {
                System.out.println(strArr[i]);
            }
        }
    }
}