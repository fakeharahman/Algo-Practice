package dp;

public class equalsum {
    boolean rec(int[] arr, int n, int sum){
        // int sum1=0;
        // int sum2=0;
        if(n==0){
            if(sum==0){
                return true;
            }
            return false;
        }
        // boolean x=rec(arr, n-1, sum1+arr[n-1], sum2)||rec(arr, n-1, sum1, sum2);
        boolean y=rec(arr, n-1, sum)||rec(arr, n-1, sum-arr[n-1]);
        return y;
    }
    public static void main(String[] args) {
        int[] arr={1,5,0,6};
        int n=arr.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }
        if(sum%2==0){
            System.out.println(new equalsum().rec(arr, n, sum/2));
            boolean[][] dp=new boolean[n+1][sum/2+1];
        dp[0][0]= true;
        for(int i=1 ; i<n+1; i++){
            dp[i][0]=true;
        }
        for(int i=1 ; i<sum/2+1; i++){
            dp[0][i]=false;
        }
        for(int i=1 ; i<n+1; i++){
            for( int j=1; j<sum/2+1; j++){
                if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j]; 
                }else
                dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
            }
        }
        System.out.println(dp[n][sum/2]);
        }else{
            System.out.println(false);
           
        }
        
    }
}
