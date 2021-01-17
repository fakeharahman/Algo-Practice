package dp;

import java.util.Arrays;

public class palindromePartition {
    int rec(char[] a, int i, int j, int[][] dp) {
        int min = Integer.MAX_VALUE;
        if (i == j) {
            return 0;
        }
        if(isPalindrome(a, i, j) )return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for (int k = i; k < j; k++) {
            // if(dp[i][k]==-1){
            //     dp[i][k]=rec(a, i, k, dp);
            // }
            // if(dp[k+1][j]==-1){
            //     dp[k+1][j]=rec(a, k+1, j, dp);
            // }
           int temp=1+rec(a, i, k, dp)+rec(a, k+1, j, dp);
           min=Math.min(min, temp);
        //    System.out.println(min);
        }
        dp[i][j]=min;
        return min;
    }

    boolean isPalindrome(char[] a, int i, int j) {
        while (i <= j) {
            if (a[i++] != a[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abacdc";
        char[] a = s.toCharArray();
        int n = s.length();
        int[][] dp=new int[n][n];
    for(int[] arr1 : dp) 
    Arrays.fill(arr1, -1);
        System.out.println(new palindromePartition().rec(a, 0, n - 1, dp));
    }
}
