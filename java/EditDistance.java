public class EditDistance {
    static void dp(char[] a, char[] b){
        int na=a.length;
        int nb=b.length;
        int[][] dp=new int[na+1][nb+1];
        for(int i=0; i<=na; i++){
            for(int j=0; j<=nb; j++){
                if(i==0||j==0) {dp[i][j]=0; continue;}
                if(a[i-1]==b[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
            }
        }
        int max=dp[na][nb];
        System.out.println(Math.max(na-max, nb-max));
    }
    public static void main(String[] args) {
        String str1 = "cat";
        String str2 = "cuut";
        dp(str1.toCharArray(), str2.toCharArray());
    }
}
