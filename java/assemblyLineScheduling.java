public class assemblyLineScheduling {
    int a[][] = {{4, 5, 3, 2,11},
                {2, 10, 1, 4,12}};
    int t[][] = {{0, 7, 4, 5, 2},
                {0, 9, 2, 8, 3}};
    int e[] = {10, 12}, x[] = {18, 7};  
    int rec(int i, int j){
        if(j>=a[0].length) return 0;
        if(j==a[0].length-1) return a[i][j];
        int k=rec(i, j+1)+a[i][j];
        if(i==0){
            return Math.min(k, rec(i+1, j+1)+a[i][j]+t[i][j+1]);
        }
        return Math.min(k, rec(i-1, j+1)+a[i][j]+t[i][j+1]);
    }
    void carAssmbly(){
        int jn=a[0].length;
        a[0][0]+=e[0];
        a[1][0]+=e[1];
        a[0][jn-1]+=x[0];
        a[1][jn-1]+=x[1];
        System.out.println(Math.min(rec(0, 0), rec(1, 0)));
        int[][] dp=new int[2][jn];
        for(int j=0; j<jn; j++){
            for(int i=0; i<2; i++){
            if(j==0) {
                dp[i][j]=a[i][j];
                continue;
            }
            if(i==0){
                dp[i][j]=Math.min(dp[0][j-1], dp[1][j-1]+t[1][j])+a[i][j];
            }else{
                dp[i][j]=Math.min(dp[1][j-1], dp[0][j-1]+t[0][j])+a[i][j];
            }
        }
       } 
       System.out.println((dp[1][jn-1]));
    }
    public static void main(String[] args) {
          assemblyLineScheduling t=new assemblyLineScheduling();
          t.carAssmbly();
    }
}
