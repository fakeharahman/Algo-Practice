package dp;

public class noOfSubsets {
    // static int count = 0;
    int count(int[] arr, int n, int t){
        if(t==0){
            // count++;
            return 1;
        }
        if(n==0){
            return 0;
        }
       return count(arr, n-1, t) + count(arr, n-1, t-arr[n-1]);
        
    }
    public static void main(String[] args) {
        int arr[]= {5,3,2,1,6,0};
        int n=arr.length;
        int t=6;
        System.out.println(new noOfSubsets().count(arr, n, t));
    }
}
