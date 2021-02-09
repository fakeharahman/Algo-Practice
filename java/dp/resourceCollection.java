package dp;

public class resourceCollection {

    static int rec(int[][] a, int[][] b, int i, int n){
        if(i<0){
            return suma(a, b, 0, a[0].length-1, n);
        }
        if(n<0){
            return 0;
        }
        int x=sumb(a, b, 0, i, n)+suma(a, b, i+1, a[0].length-1, n);
        int temp= Math.max(rec(a, b, i, n-1)+x, rec(a, b, i-1, n));
        return temp;
        
    }
    static int suma(int[][] a, int[][] b, int i, int j, int n){
        int sum=0;
        for(int k=i; k<=j; k++){
            sum+=a[n][k];
        }
        return sum;
    }
    static int sumb(int[][] a, int[][] b, int i, int j, int n){
        int sum=0;
        for(int k=i; k<=j; k++){
            sum+=b[n][k];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] a={{1,0,1}};
        int[][] b={{2,1,0}};
        System.out.println(rec(a, b, a[0].length-1, a.length-1));
        int n=a.length;
        int m=a[0].length;
        // System.out.println(m+n);
        int[][] dp=new int[n+1][m+1];
        // for(int i=0; i<m; i++ ){
        //     dp[i][0]=0;
        // }
        // for(int i=0; i<n; i++ ){
        //     dp[0][i]=suma(a, b, 0, a[0].length-1, i);
        // }
        for(int i=0; i<n; i++ ){
            for(int j=0; j<m; j++ ){
                
                if(j==0){
                   dp[i][0]=suma(a, b, 0, a[0].length-1, i);
                   System.out.println(dp[i][j]);
                   
               }
                else if(i==0){
                    dp[0][j]=0;
                }
                else{
                    int sa=suma(a, b, j+1, m-1, i);
                    int sb=sumb(a, b, 0, j, i);
                    System.out.println(sb+" "+sa);
                    int x= sa+sb;
                    dp[i][j]=Math.max(dp[i-1][j]+x, dp[i][j-1]);
                }
            }
        }
        // System.out.println(8&2&10);
        System.out.println(dp[n-1][m-1]);
    }
}
