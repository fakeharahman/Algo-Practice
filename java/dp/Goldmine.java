package dp;

public class Goldmine {
    static int rec(int[][] a, int m, int n) {
        if (n < 0 || m < 0) {
            return 0;
        }
        if (m >= a.length || n >= a[0].length) {
            return 0;
        }
        // System.out.println(a[m][n]);
        return Math.max(Math.max(rec(a, m - 1, n + 1), rec(a, m, n+1)), rec(a, m + 1, n + 1)) + a[m][n];
    }
    static int dp(int[][] a, int m, int n){
        int[][] dp=new int[m+1][n+1];
        int max=0;
        for(int j=0; j<=n; j++){
        for(int i=0; i<=m-1; i++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else{
                    
                    dp[i][j]=Math.max(dp[i][j-1], Math.max(dp[i-1][j-1], dp[i+1][j-1]))+a[i-1][j-1];
                }
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        
        int[][] a = 
        {{1, 3, 3},
        {2, 1, 4},
        {0, 6, 4}};
        int m = a.length;
        int n = a[0].length;
        int max = 0;
        System.out.println(dp(a, m, n));
        for (int i = 0; i < m; i++) {
            max = Math.max(max, rec(a, i, 0));
        }
        System.out.println(max);
    }
}
