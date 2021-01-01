package dp;

public class RodCutting {
    int rec(int[] w, int[] p, int n, int k) {
        if (k == 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if(w[n-1]>k){
            return rec(w, p, n-1, k);
        }
        return Math.max(rec(w, p, n - 1, k), rec(w, p, n, k - w[n - 1]) + p[n - 1]);
    }
    int dp(int[] w, int[] p, int n, int k){
        int dp[][]=new int[n+1][k+1];
        for(int i=0; i<n+1; i++){
            dp[i][0]=0;
        }
        for(int i=0; i<k+1; i++){
            dp[0][i]=0;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<k+1; j++){
               if(w[i-1]>j){
                   dp[i][j]=dp[i-1][j];
               }else{
                   dp[i][j]=Math.max(dp[i][j-w[i-1]]+p[i-1], dp[i-1][j]);
               }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int[] w={1,2,3,4,5,6,7,8};
        int[] p={1,5,8,9,0,17,17,20};
        int k=8;
        int n=w.length;
        System.out.println(new RodCutting().rec(w, p, n, k));
        System.out.println(new RodCutting().dp(w, p, n, k));
    }
}
