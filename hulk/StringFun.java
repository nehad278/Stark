public class StringFun{
    public static void main(String[] args) {
        String one = "hello world ";
        int num = 23;
        String conct = one + num;
        String substr = conct.substring(1,5);
        System.out.println(one);
        System.out.println(conct);
        System.out.println(substr);

        num = 20;
        int num2 = 41;
        String t1 = num+num2+ " total";
        String t2 = "total "+ num+num2;
        String t3 = " " + num + num2 + " total";
        System.out.println("t1 "+ t1);
        System.out.println("t2 "+ t2);
        System.out.println("t3 "+ t3);

    }
}