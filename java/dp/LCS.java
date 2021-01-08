package dp;

public class LCS {
    int rec(char[] x, char[] y, int n, int m){
        if(n==0|| m==0){
            return 0;
        }
        if(y[m-1]==x[n-1]){
            return rec(x, y, n-1, m-1)+1;
        }
        else
        return Math.max(rec(x, y, n-1, m), rec(x, y, n, m-1));
        
    }
    int dp(char[] x, char[] y, int n, int m){
        int[][] dp=new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            dp[i][0]=0;
        }
        for(int i=0; i<m+1; i++){
            dp[0][i]=0;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(x[i-1]==y[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1="agbcba";
        String s2="abcbga";

        char[] x=s1.toCharArray();
        char[] y=s2.toCharArray();
        int xl=x.length;
        int yl=y.length;
        System.out.println(xl-new LCS().rec(x, y, xl, yl));
        System.out.println(xl+yl-2*new LCS().dp(x, y, xl, yl));
    }
}
