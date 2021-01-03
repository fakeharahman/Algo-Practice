package dp;

public class coinsWays {
    int rec(int[] arr, int n, int sum){
        if(sum==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(arr[n-1]>sum){
            return rec(arr, n-1, sum);
        }
        return rec(arr, n-1, sum)+rec(arr, n, sum-arr[n-1]);
    }
    int dp(int[] arr, int n, int t){
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
                dp[i][j]=dp[i-1][j]+ dp[i][j-arr[i-1]];
            }
        }
        return dp[n][t];
    }
    public static void main(String[] args) {
        int[] arr= {1,2,3};
        int sum=5;
        int n=arr.length;
        System.out.println(new coinsWays().rec(arr, n, sum));
        System.out.println(new coinsWays().dp(arr, n, sum));
    }
}
