import java.util.Scanner;

public class dptree {
    static int[][][] dp;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int r=s.nextInt();
        int c=s.nextInt();
        String[][] a=new String[r][c];
        // int r=4;
        // int c=3;
        // String
        dp=new int[r][c][3];
        for(int i=0; i<r; i++){
            String ch=s.next();
            for(int j=0; j<c; j++){
            
                a[i][j]=ch.charAt(j)+"";
            }
        }
        for(int i=0; i<r; i++){
            if(a[i][0].charAt(0)=='.'){
                dp[i][0][0]=1;
                dp[i][0][1]=1;
                dp[i][0][2]=1;
            }
        }
        for(int j=0; j<c; j++){
            if(a[0][j].charAt(0)=='.'){
                dp[0][j][0]=1;
                dp[0][j][1]=1;
                dp[0][j][2]=1;
            }
        }
        dp=new int[r][c][3];
        for(int i=1; i<r; i++){
            for(int j=1; j<c; j++){
                if(a[i][j].charAt(0)=='#') continue;
                dp[i][j][0]=dp[i-1][j][0]+1;
                dp[i][j][1]=dp[i][j-1][1]+1;
                dp[i][j][2]=dp[i-1][j-1][2]+1;
                
            }
        }
        rec(a, 0, 0);
        System.out.println(ans);
    }
    static int ans=0;
    public static int rec(String[][] a, int i, int j){
        if(i>=a.length|| j>=a[0].length) return 0;
        // System.out.println(a[i][j]=="#");
        if(a[i][j].charAt(0)=='#') return 0;
        if(i==a.length-1&&j==a[0].length-1){
            // ans++;
            return 1;
        }
      return rec(a, i+1, j)+rec(a, i, j+1)+rec(a, i+1, j+1);
    }
}
