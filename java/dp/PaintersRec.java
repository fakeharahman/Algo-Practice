package dp;

public class PaintersRec {
    int sum(int[] arr, int start, int end){
        int sum=0;
        for( int i=start; i<=end; i++){
            sum+=arr[i];
        }
        return sum;
    }
    int partition(int[] arr, int n, int k, int[][] dp){
        int ans=Integer.MAX_VALUE;
        if(n==1){
            return arr[0];
        }
        if(k==1){
            // if(dp[0][n-1]==0){
            //     dp[0][n-1]=sum(arr, 0, n-1);
            // }
            return sum(arr, 0, n-1);
        }
        for(int i=1; i<n; i++){
            // if(dp[i][n-1]==0){
            //     dp[i][n-1]=sum(arr, i, n-1);

            // }
            ans=Math.min(ans, Math.max(sum(arr, i, n-1), partition(arr, i, k-1, dp)));
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = { 10, 20, 60, 50, 30, 40 }; 
   
        // Calculate size of array. 
        int n = arr.length; 
        int[][] dp=new int[n][n];
            int k = 3; 
            PaintersRec r= new PaintersRec();
     System.out.println(r.partition(arr, n, k, dp)+ " "+ dp[0][0]); 
    }
}
