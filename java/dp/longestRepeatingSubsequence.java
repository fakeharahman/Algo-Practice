package dp;

public class longestRepeatingSubsequence {
    int dp(char[] x, char[] y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    int max=0;
    int rec(char[] a, int n, String s1, String s2){
        if(n==0) {
            char[] x=s1.toCharArray();
            char[] y=s2.toCharArray();
            int k= s1.length();
            int m=s2.length();

            return dp(x, y, k, m);
        }
        return Math.max(rec(a, n-1, s1+a[n-1], s2), rec(a, n-1, s1, s2+a[n-1]));
    }
    int dp(char[] x, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x[i - 1] == x[j - 1]&& i!=j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    System.out.println(x[i-1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        String s="ttttt";
        int n= s.length();
        char[] a=s.toCharArray();
        System.out.println(new longestRepeatingSubsequence().rec(a, n, "", ""));
        System.out.println(new longestRepeatingSubsequence().dp(a, n));
    }
}
