package dp;
//important check again
public class LongestCommonSubstring {
    int rec(char[] x, char[] y, int n, int m, int count) {
        // System.out.println(count);
        if (n == 0 || m == 0) {
            return count;
        }
        if (x[n - 1] == y[m - 1]) {
            return rec(x, y, n - 1, m - 1, count + 1);
        }
        return Math.max(count, Math.max(rec(x, y, n - 1, m, 0), rec(x, y, n, m - 1, 0)));
    }

    int dp(char[] x, char[] y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // System.out.println(count);
                if(x[i-1]==y[j-1]){
                    // count=dp[i-1][j-1];
                    dp[i][j]=dp[i-1][j-1]+1;
                    count=Math.max(count, dp[i][j]);
                }
                else{

                    // count=0;
                    dp[i][j]=0;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abcgcdgk";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int n = x.length;
        int m = y.length;
        System.out.println(new LongestCommonSubstring().rec(x, y, n, m, 0));
        System.out.println(new LongestCommonSubstring().dp(x, y, n, m));
    }
}
