package dp;

public class subset {
    int rec(int[] arr, int t, int n){
        // System.out.println(t);
        int x;
        if(t==0){
            // System.out.println('1');
            return 1;
        }
        if(n==0){
            // System.out.println('1');
            return -1;

        }
        if(arr[n-1]>t){
            return rec(arr, t, n-1);
        }else{
            // return Math.max(a, b)
            x=rec(arr, t, n-1);
            if(x!=1){

                x=rec(arr, t-arr[n-1], n-1);
            }
        }
        return x;

    }
    public static void main(String[] args) {
        int[] arr= {2,3,7,12,1};
        int t=11;
        int n=arr.length;
        subset ss=new subset();
        System.out.println(ss.rec(arr, t, n));
        int[][] dp=new int[n+1][t+1];
        for(int i=0; i<t+1; i++){
            dp[0][i]=-1;
        }
        for(int i=0; i<n+1; i++){
            dp[i][0]=1;
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<t+1; j++){
                if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    int x=dp[i-1][j];
                    if(x!=1){
                        x=dp[i-1][j-arr[i-1]];
                        // System.out.println(x);
                    }
                    dp[i][j]=x;
                }
            }
        }
        System.out.println(dp[n][t]);
    }
}
