package dp;


public class WeightedJob {

    static int rec(int[][] a, int n, int s) {
        if (n < 0) {
            return 0;
        }
        if(a[n][0]<s){
            return rec(a, n - 1, s);
        }
        return Math.max(a[n][2] + rec(a, n - 1, a[n][1]), rec(a, n - 1, s));
    }

      
    public static void main(String[] args) {
        int[][] a={
            {6, 19, 100},
            {3, 5, 20},
            {2, 100, 200},
            {1, 2, 50} ,
        };
        int n=a.length;
        System.out.println(rec(a, n-1, -1));
    }
}
