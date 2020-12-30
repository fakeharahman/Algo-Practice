package dp;

public class minSubsetDif {
    int rec(int[] arr, int n, int sum, int tot) {
        if (n == 0) {
            return Math.abs(2 * sum - tot);
        }
        int x = Math.min(rec(arr, n - 1, sum, tot), rec(arr, n - 1, sum - arr[n - 1], tot));
        return x;
    }

    static int sum(int[] arr, int s, int l) {
        int sum = 0;
        for (int i = s; i <= l; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 1, 2, 3, 2, 1 };
        int n = arr.length, tot = 0;
        for (int i = 0; i < n; i++) {
            tot += arr[i];
        }
        System.out.println(new minSubsetDif().rec(arr, n, tot, tot));
        boolean[][] dp = new boolean[n + 1][tot / 2 + 1];
        for (int i = 0; i < tot / 2 + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = false;
        }
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < tot / 2 + 1; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }
        System.out.println(dp[n][tot / 2]);
        for (int i = tot / 2; i >= 0; i--) {
            if (dp[n][i] == true) {
                System.out.println(Math.abs(tot - 2 * i));
                break;
            }
        }

    }
}
