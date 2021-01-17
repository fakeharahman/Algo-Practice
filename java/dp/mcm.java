package dp;

import java.util.Arrays;

public class mcm {
    int rec(int[] a, int i, int j, int[][] dp){
        int min=Integer.MAX_VALUE;
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i; k<j;k++){
            int temp=rec(a, i, k, dp)+ a[k]*a[i-1]*a[j]+rec(a, k+1, j, dp);
            min=Math.min(temp, min);
        }
        dp[i][j]=min;
        return min;
    }
    public static void main(String[] args) {
        int[] a={10,30,5,60};
        int n=a.length;
        int[][] dp=new int[n][n];
        for(int[] arr1 : dp) 
        Arrays.fill(arr1, -1);
        System.out.println(new mcm().rec(a, 1, n-1, dp));
    }
}
