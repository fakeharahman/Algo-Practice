package dp;

public class EggDropping {
    static int rec(int n, int e){
        int min=Integer.MAX_VALUE;
        if(n==0){
            return 0;
        }
        if(n==1) return 1;
        if(e==1){
            return n;
        }
        for(int k=1; k<=n; k++){
            int b=rec(k-1, e-1)+1;
            int d=rec(n-k, e)+1;
            int temp=Math.max(b, d);
            min=Math.min(temp, min);
        }
        return min;
    }

    static int dp(int n, int e){
        int[][] dp=new int[n+1][e+1];
        for(int i=0; i<=n; i++){
            dp[i][1]=i;
        }
        for(int i=0; i<=e; i++){
            dp[1][i]=1;
            dp[0][i]=0;
        }
        for(int i=2; i<=n; i++){
            for(int j=2; j<=e; j++){
                int min=Integer.MAX_VALUE;
                for(int k=1; k<=i; k++){
                    int b=dp[k-1][j-1]+1;
                    int d=dp[i-k][j]+1;
                    int temp=Math.max(b, d);
                    min=Math.min(temp, min);
                }
                dp[i][j]=min;
                // System.out.println(dp[i][j]);
            }
        }
        return dp[n][e];
    }
    public static void main(String[] args) {
        int n=46;
        int e=2;
        // System.out.println(rec(n, e));
        System.out.println(dp(n, e));
    }
}
