package dp;

public class HighwayBillboard {
    static int rec(int[] m, int[] c, int n, int t, int prev){
        if(n<0){
            return 0;
        }
        if(prev- m[n]<=t){
            return rec(m, c, n-1, t, prev);
        }
        return Math.max(rec(m, c, n-1, t, m[n])+c[n], rec(m, c, n-1, t, prev));
    }
    static int dp(int[] m, int[] c, int t, int tot){
        int n=m.length;
        int dp[] = new int[tot+1];
        // for(int i=0; i<n+1; i++){
        //     dp[i][0]=0;
        // }
        int j=0;
        int max=0;
        for(int i=1; i<tot+1; i++){
            if(j>=n){
                break;
               }
           if(i!=m[j]){
            dp[i]=dp[i-1];
           }else{
               dp[i]=Math.max(dp[i-1], dp[i-t-1]+c[j]);
               max=dp[i];
               j++;
           }
        }
        // for(int i=1; i<n+1; i++){
        //     for(int j=1; j<tot+1; j++){
                
        //     }
        // }
        return max;
    }
    public static void main(String[] args) {
        int m[] = {6, 7, 12, 13, 14};
       int c[] = {5, 6, 5,  3,  1};
       int t=5;
       int tot=15;
       int prev=10000;
       System.out.println(rec(m, c, m.length-1, t, prev));
        System.out.println(dp(m, c, t, tot));
    }
}
