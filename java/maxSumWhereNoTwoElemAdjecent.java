public class maxSumWhereNoTwoElemAdjecent {
    static int rec(int[] a, int i, boolean s){
        if(i>=a.length) return 0;
        if(s){
            return rec(a, i+1, false);
        }
        return Math.max(rec(a, i+1, true)+a[i], rec(a, i+1, false));
        // return 1;
    }
    static void dp(int[] a){
        int n=a.length;
        int dp[][]=new int[n+1][2];
        for(int i=0; i<=n; i++){
            for(int j=0; j<2; j++){
                if(i==0) dp[i][j]=0;
                else if(j==0){
                    dp[i][j]=dp[i-1][1]+a[i-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][1], dp[i-1][0]);
                }
            }
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
    public static void main(String[] args) {
        int arr[] = {1, 20, 3};
        // System.out.println(rec(arr, 0, false));
        dp(arr);
    }
}
