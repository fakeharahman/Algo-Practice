// import java.util.Arrays;
package dp;

public class painters {
    int sum(int[] arr, int s, int l) {
        int sum = 0;
        for (int i = s; i < l; i++) {
            sum += arr[i];
        }
        return sum;
    }

    int rec(int[] p, int n, int k) {
        int max = Integer.MAX_VALUE;
        if (n == 0) {
            return p[0];
        }
        if (k == 1) {
            return sum(p, 0, n);
        }
        for (int i = 0; i < n; i++)
            max = Math.min(max, Math.max(sum(p, i, n), rec(p, i, k - 1)));
        return max;
    }

    int dp(int[] arr, int n, int k) {
        int dp[][] = new int[n + 1][k + 1];
        // for (int[] arr1 : dp)
        //     Arrays.fill(arr1, Integer.MAX_VALUE);
        // System.out.println(dp[0][0]);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                // if (j == 0|| i==0) {
                //     dp[i][j] = 0;
                //     System.out.print(dp[i][j] + " ");
                //     continue;
                // }
                if (i == 1) {
                    dp[i][j] = arr[0];
                    System.out.print(dp[i][j] + " ");
                    continue;
                }
                if (j == 1) {
                    dp[i][j] = sum(arr, 0, i);
                    System.out.print(dp[i][j] + " ");
                    continue;
                    
                } else {
                    int best = Integer.MAX_VALUE; 
                    for (int m = 1; m <= i; m++) {
                        best = Math.min(best, Math.max(sum(arr, m , i), dp[m][j - 1]));
                    }
                    dp[i][j]=best;
                }
                System.out.print(dp[i][j]+ ' ');
            }
            System.out.println();
        }
        return dp[n ][k ];
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 60, 50, 30, 40 };
        int n = arr.length;
        int k = 3;
        painters p = new painters();
        System.out.println(p.rec(arr, n, k));
        System.out.println(p.dp(arr, n, k));
    }
}
