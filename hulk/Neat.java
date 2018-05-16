import java.lang.*;
class Neat{
    public static void main(String[] args) {
        int num = 131332;
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i< str.length(); i++) {
            if(i != str.length()-1 && Character.getNumericValue(str.charAt(i)) > Character.getNumericValue(str.charAt(i+1)) ) {
                int x = Character.getNumericValue(str.charAt(i)) * (int)Math.pow(10, (str.length()-i-1)) -1;
                sb.append(x);
                break;
            } else {
                sb.append(str.charAt(i));
            }
        }
        System.out.println("Neat numner= "+sb.toString());
    }

}