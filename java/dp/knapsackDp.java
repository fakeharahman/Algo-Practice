package dp;
public class knapsackDp {

    public static void main(String[] args) {
        int[] wt = { 1, 3, 8, 3 };
        int[] pr = { 9, 4, 5, 7 };
        int tot = 7;
        int[][] t = new int[wt.length + 1][tot + 1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                System.out.print(t[i][j]+ " ");

                    continue;
                }
                if(wt[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
                if(wt[i-1]<=j){
                    t[i][j]=Math.max(t[i-1][j], t[i-1][j-wt[i-1]]+ pr[i-1]);
                }
                System.out.print(t[i][j]+ " ");
            }
            System.out.println();
        }
    }
}