package dp;

public class supers {
    String rec(char[] x, char[] y, int n, int m, String str) {
        if (n == 0 && m != 0) {
            return rec(x, y, n, m - 1, str) + y[m - 1];
        }
        if (n != 0 && m == 0) {
            return rec(x, y, n - 1, m, str) + x[n - 1];
        }
        if (n == 0 && m == 0) {
            return "";
        }
        if (x[n - 1] == y[m - 1]) {
            return rec(x, y, n - 1, m - 1, str) + x[n - 1];
        }
        // System.out.println();
        if (rec(x, y, n - 1, m, str + x[n - 1]).length() < rec(x, y, n, m - 1, str + y[m - 1]).length()) {
            return rec(x, y, n - 1, m, str) + x[n - 1];
        } else {
            return rec(x, y, n, m - 1, str) + y[m - 1];
        }
        // return str;
    }

    String dp(char[] x, char[] y, int n, int m) {
        String[][] dp = new String[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = "";
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + y[j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + x[i - 1];
                } else if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + x[i - 1];
                } else if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
                    dp[i][j] = dp[i][j - 1] + y[j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] + x[i - 1];
                }
            }
        }
        return dp[n][m];
    }

    void dp2(char[] x, char[] y, int n, int m) {
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
        int i = n, j = m;
        String s = "";
        while (i != 0 && j != 0) {
            // System.out.println(i+ " "+ j);
            if (x[i-1] == y[j-1]) {
                s = x[i-1]+s;
                i--;
               j--;
            } else {
                s=x[i-1]+s;
                s=y[j-1]+s;
                if(dp[i-1][j]>dp[i][j-1]){
                    // s=x[i-1]+s;
                    i--;
                }else{
                    
                    j--;
                }
            }
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "eke";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int n = x.length;
        int m = y.length;
        System.out.println(new supers().rec(x, y, n, m, ""));
        System.out.println(new supers().dp(x, y, n, m));
        new supers().dp2(x, y, n, m);
    }
}
