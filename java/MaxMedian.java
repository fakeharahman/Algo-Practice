// import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMedian {

    static int rec(int[] a, int i, int j, int k, int[][] m){
        int max=Integer.MIN_VALUE;
        if(j-i+1<k){
            return 0;
        }
        if(i>j){
            return 0;
        }
        if(m[i][j]!=0){
            return m[i][j];
        }
        if(j-i+1==k){
            return findMedian(a, i, j);
        }
        for(int l=i; l<j; l++){
            int temp=Math.max(rec(a, i, l, k, m), rec(a, l+1, j, k, m));
            max=Math.max(max, Math.max(findMedian(a, i, j), temp));
        }
        // System.out.println(max);
        m[i][j]=max;
        return max;
    }

    static int dp(int[] a, int n, int k){
        int[][] dp= new int[n+1][n+1];  
        int last=Integer.MIN_VALUE;   
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=Integer.MIN_VALUE;
                if(j-i+1<k){
                    dp[i][j]= 0;
                }
                else if(i>j){
                    dp[i][j]= 0;
                }
                else if(j-i+1==k){
                    dp[i][j]= findMedian(a, i, j);
                }
                else{
                    for(int l=i; l<j; l++){
                        int temp=Math.max(dp[i][l], dp[l][j]);
                        dp[i][j]=Math.max(dp[i][j], Math.max(findMedian(a, i, j), temp));
                    }
                }
                if(dp[i][j]>last)
                last=dp[i][j];
            }
        }
        return last;
    }
    static int findMedian(int[] a, int i, int j){
        int[] arr=new int[j-i+1];
        // Arrays.sort(arr);
        int l=0;
        for(int k=i; k<=j; k++){
            arr[l]=a[k];
            l++;
        }
        Arrays.sort(arr);
        // for(int t=0; t<arr.length; t++){
        //     System.out.print(arr[t]);
        // }
        // System.out.println(i + " "+ j+ " "+arr[((arr.length+1)/2)-1]+ " "+ (((arr.length+1)/2)-1) );
        return arr[((arr.length+1)/2)-1];

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i]=s.nextInt();
            }      
            // int[][] m= new int[n+1][n+1];     
            // System.out.println(rec(a, 0, n-1, k, m));
            System.out.println(dp(a, n, k));
        s.close();
    }
}
