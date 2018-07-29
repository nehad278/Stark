class MajorOccur {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,1,2,3,4,5};
        System.out.println(findMajorOccurance(arr));
    }
    private static boolean findMajorOccurance(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        return findOut(arr, l, r, arr.length);
    }
    private static boolean findOut(int[] arr, int l, int r, int n) {

        int mid = n%2==0 ? n/2 : n/2+1;
        if(arr[mid-1] == arr[mid+1] && (arr[mid] == arr[mid+1] || arr[mid] == arr[mid-1])) {
            return true; 
        } else {
            return false;
        }
    }
}