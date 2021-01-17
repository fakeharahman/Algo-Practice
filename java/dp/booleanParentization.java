package dp;

import java.util.Arrays;

public class booleanParentization {
    static int max = Integer.MIN_VALUE;
    static int c = 0;
    static int[][][] dp = new int[100][100][2];

    int rec2(char[] a, int i, int j, boolean isTrue) {
        int ans = 0;
        if (i == j) {
            if (isTrue) {
                return a[i] == 'T' ? 1 : 0;
            } else {
                return a[i] == 'F' ? 1 : 0;
            }
        }
        if (dp[i][j][getNumfrombool(isTrue)] != -1)
            return dp[i][j][getNumfrombool(isTrue)];

        for (int k = i + 1; k < j; k = k + 2) {
            int lt = rec2(a, i, k - 1, true);
            int lf = rec2(a, i, k - 1, false);
            int rt = rec2(a, k + 1, j, true);
            int rf = rec2(a, k + 1, j, false);
            if (a[k] == '|') {
                if (isTrue) {
                    ans += lt * rf + lf * rt + lt * rt;
                } else {
                    ans += lf * rf;
                }
            }
            if (a[k] == '&') {
                if (isTrue) {
                    ans += lt * rt;
                } else {
                    ans += lt * rf + lf * rt + lf * rf;
                }
            }
            if (a[k] == '^') {
                if (isTrue) {
                    ans += lt * rf + lf * rt;
                } else {
                    ans += lf * rf + lt * rt;
                }
            }

        }
        dp[i][j][getNumfrombool(isTrue)] = ans;
        return ans;
    }

    int dp(char[] a, int n) {
        int[][] t = new int[n + 1][n + 1];
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            t[i][i] = a[i] == 'T' ? 1 : 0;
            f[i][i] = a[i] == 'F' ? 1 : 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j){
                    continue;
                }
                int lt = t[i][j-1];
                int lf = f[i][j-1];
                int rt = t[i+1][j];
                int rf = f[i+1][j];
                t[i][j] = lt * rf + lf * rt + lt * rt;

            }
        }

        return t[n][n];

    }

    // char rec(char[] a, int i, int j, int count) {
    // if (i == j)
    // return a[i];
    // for (int k = i + 1; k < j; k = k + 2) {
    // boolean temp = getOperation(rec(a, i, k - 1, count), rec(a, k + 1, j, count),
    // a[k]);
    // // if(k==2) System.out.println(getOperation(a[4], a[6], a[5]));
    // if (temp) {
    // count++;
    // c++;
    // System.out.print(k + " " + i + " " + j);
    // }
    // System.out.println();
    // max = Math.max(count, max);
    // }
    // return a[i];
    // }

    static int getNumfrombool(boolean isTrue) {
        if (isTrue)
            return 1;
        else
            return 0;
    }

    boolean getOperation(char a, char b, char x) {
        boolean m = getTF(a), n = getTF(b);
        switch (x) {
            case '&':
                return m & n;
            case '|':
                return m | n;
            case '^':
                return m ^ n;
            default:
                return true;
        }

    }

    boolean getTF(char a) {
        if (a == 'F')
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        String s = "T|T&F^T";
        char[] a = s.toCharArray();
        int n = a.length;
        for (int[][] arr1 : dp) {
            for (int[] arr2 : arr1)
                Arrays.fill(arr2, -1);
        }
        int ans = new booleanParentization().rec2(a, 0, n - 1, true);
        System.out.println(dp[0][0][0]);
        System.out.println(ans);
    }
}
