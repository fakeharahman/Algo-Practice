package dp;

// import java.util.Arrays;

public class LongestIncreasingSubsequence {
    int rec(int[] a, int n, int prev){
        if(n==0){
            return 0;
        }
        if(a[n-1]>prev){
            return 0;
        }
        return Math.max(rec(a, n-1, prev), rec(a, n-1, a[n-1])+1);
    }
    void dp(int[] a, int n){
    //    Arrays.sort(a);
    }
    public static void main(String[] args) {
        int[] a={10, 22, 9, 33, 21, 50, 41, 60, 80} ;
        int n=a.length;
        System.out.println(new LongestIncreasingSubsequence().rec(a, n, Integer.MAX_VALUE));
    }
}
