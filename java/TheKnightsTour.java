public class TheKnightsTour {
    static int[][] ans;
    static int count;
    static void rec(int i, int j, int k){
        if(i>=ans.length|| j>=ans.length|| i<0||j<0) return;
        if(ans[i][j]!=0) return;
        if(count==ans.length*ans.length) return;
        ans[i][j]=k++;
        count++;
        // System.out.println(count+" "+i+" "+j);
        rec(i+2, j+1, k+1);
        if(count==ans.length*ans.length) return;
        rec(i-2, j+1, k+1);
        if(count==ans.length*ans.length) return;
        rec(i+2, j-1, k+1);
        if(count==ans.length*ans.length) return;
        rec(i-2, j-1, k+1);
        if(count==ans.length*ans.length) return;

        rec(i+1, j+2, k+1);
        if(count==ans.length*ans.length) return;
        rec(i-1, j+2, k+1);
        if(count==ans.length*ans.length) return;
        rec(i+1, j-2, k+1);
        if(count==ans.length*ans.length) return;
        rec(i-1, j-2, k+1);
        if(count==ans.length*ans.length) return;
        if(count!= ans.length*ans.length){
            ans[i][j]=0;
            count--;
        }

    }
    public static void main(String[] args) {
        int n=8;
        count=0;
        ans=new int[n][n];
        rec(0, 0, 1);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
