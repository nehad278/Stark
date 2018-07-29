class Rearrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i=0; i < num; i++;) {
            arr[i] = in.nextInt();
        }
        arrange(arr, num);
    }
    private static void arrange(int[] arr, int num) {
        for(int i=0; i< num; i++) {
            if(arr[i] < 0) {
                
            }
        }
    }
}