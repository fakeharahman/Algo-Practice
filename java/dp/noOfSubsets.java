package dp;

public class noOfSubsets {
    // static int count = 0;
    int count(int[] arr, int n, int t) {
        if (t == 0) {
            // count++;
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return count(arr, n - 1, t) + count(arr, n - 1, t - arr[n - 1]);

    }

    public static void main(String[] args) {
        int arr[] = { 3,2,1,1 };
        int n = arr.length;
        int t = 4;
        System.out.println(new noOfSubsets().count(arr, n, t));
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 0; i < t + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<t+1; j++){
                if(arr[i-1]>j)
                dp[i][j]=dp[i-1][j];
                else
                dp[i][j]=dp[i-1][j]+ dp[i-1][j-arr[i-1]];
            }
        }
        System.out.println(dp[n][t]);
    }
}
