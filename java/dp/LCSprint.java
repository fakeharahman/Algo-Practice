package dp;

public class LCSprint {
    String rec(char[] x, char[] y, int n, int m){
        if(n==0|| m==0){
            return "";
        }
        if(y[m-1]==x[n-1]){
            return rec(x, y, n-1, m-1)+y[m-1];
        }
        else{
            if(rec(x, y, n-1, m).length()>rec(x, y, n, m-1).length()){
                return rec(x, y, n-1, m);
            }else{
                return rec(x, y, n, m-1);
            }
        }
        // return Math.max(rec(x, y, n-1, m), rec(x, y, n, m-1));
        
    }
    String dp(char[] x, char[] y, int n, int m){
        String[][] dp=new String[n+1][m+1];
        for(int i=0; i<n+1; i++){
            dp[i][0]="";
        }
        for(int i=0; i<m+1; i++){
            dp[0][i]="";
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(x[i-1]==y[j-1]){
                    dp[i][j]=dp[i-1][j-1]+x[i-1];
                }else{
                    if(dp[i-1][j].length()>dp[i][j-1].length()){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
                    // dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "akcgbcdgk";

        char[] x=s1.toCharArray();
        char[] y=s2.toCharArray();
        int n=x.length;
        int m=y.length;
        System.out.println(new LCSprint().rec(x, y, n, m));
        System.out.println(new LCSprint().dp(x, y, n, m));
    }
}
