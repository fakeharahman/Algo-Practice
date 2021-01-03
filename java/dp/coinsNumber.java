package dp;

public class coinsNumber {
    int c = 0;

    int count(int[] arr, int n, int sum) {
        if (sum == 0) {
            // return Math.min(a, b);
            return 0;
        }
        if (n == 0) {
            // c--;
            return Integer.MAX_VALUE-1;
        }
        if (arr[n - 1] > sum) {
            return count(arr, n - 1, sum);
        }
        // c++;
        // int x = ;
        // c--;
        // int y = ;
        return Math.min(count(arr, n, sum - arr[n - 1])+1, count(arr, n - 1, sum));
    }

    int dp(int[] arr, int n, int t) {
        int dp[][] = new int[n + 1][t + 1];
        for (int i = 0; i < t + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        // for (int i = 1; i < t + 1; i++) {
        //     if (i % arr[0] != 0) {
        //         dp[1][i] = Integer.MAX_VALUE-1;
        //     } else {
        //         dp[1][i]=i/arr[0];
        //     }
        // }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < t + 1; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] ,1 + dp[i][j - arr[i - 1]]);
            }
        }
        // return dp[n][t];
        return dp[n][t];
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,12,4,45,7,5};
        int n = arr.length;
        int sum = 30;
        System.out.println(new coinsNumber().count(arr, n, sum));
        System.out.println(new coinsNumber().dp(arr, n, sum));
    }
}
