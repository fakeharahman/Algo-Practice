package dp;

public class targetSumPrint {

    static void target(int[] a, int n, int sum){
        boolean[][] dp=new boolean[sum+1][n+1];
        for(int i=0; i<n+1; i++){
            dp[0][i]=true;
        }
        for(int i=0; i<sum+1; i++){
            dp[i][0]=false;
        }
        dp[0][0]=true;
        for(int i=1; i<sum+1; i++){
            for(int j=1; j<n+1; j++){
                dp[i][j]=dp[i-a[j-1]][j-1] || dp[i][j-1];
            }
        }
        for(int i=n; i>0; i--){
            if(dp[sum][i]==true){
                // int l=sum, m=i;
            }
        }
        
    }
    public static void main(String[] args) {
        int a[]={5,4,7,1,3};
        int n=a.length;
        int sum=10;
       target(a, n, sum);
        
    }
}
