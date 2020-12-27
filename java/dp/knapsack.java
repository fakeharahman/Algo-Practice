package dp;
import java.util.Arrays;

public class knapsack {
    int rec(int[] wt, int[] pr, int tot, int i, int[][] t){
        int max=-1;
        if( i>=wt.length){
            return 0;
        }
        if(wt[i]>tot){
            if(t[tot][i+1]==-1){
                t[tot][i+1]=rec(wt, pr, tot,  i+1, t);
            }
            return t[tot][i+1];
        }
        if(t[tot][i+1]==-1){
            t[tot][i+1]=rec(wt, pr, tot,  i+1, t);
        }
        if(t[tot-wt[i]][i+1]==-1){
            t[tot-wt[i]][i+1]=rec(wt, pr, tot-wt[i],  i+1, t);
        }
        // if(w+wt[i]>tot)
        // return 0;
        if(tot-wt[i]<0) return 0;
        max=Math.max(max, Math.max(t[tot][i+1], t[tot-wt[i]][i+1]+ pr[i]));
        return max;
     
    }
    public static void main(String[] args) {
        int[] wt = { 1, 3, 8, 3 };
        int[] pr = { 9, 4, 5, 7 };
        int tot = 5;
        knapsack k=new knapsack();
        int[][] t=new int[tot+1][wt.length+1];
        
        for(int[] arr1 : t) 
            Arrays.fill(arr1, -1);
            // System.out.println(t[0][1]);
       
        System.out.println(k.rec(wt, pr, tot, 0, t));
        
            
    }
}
