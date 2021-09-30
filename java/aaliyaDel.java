public class aaliyaDel {
    public static void main(String[] args) {
        String a="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String b="AAAAABCDEFGHIJKSALMNOPQRSTUVWXSDYZZ"; //input

        int n=a.length();
        int m=b.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1; i<n+1;i++){
            for(int j=1; j<m+1; j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // System.out.println(dp[n][m]);
        // int ans=dp[n][m];
        int i=n;
        int j=m;
        int start;
        int end=m;
        while(dp[i][j]!=0){
            int now=dp[i][j];
            int nowj=j;
            if(a.charAt(i-1)==b.charAt(j-1)){
                i--;
                j--;
            }else{
                if(dp[i][j-1]>dp[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
            if(end==m&&now>dp[i][j]) end=nowj;
        }
        start=j;
        System.out.println(end-start+1);

    }
}
