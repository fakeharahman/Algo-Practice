package dp;

public class equal1and0 {
    static int rec(int[][] a, int si, int sj, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length) {
            return 0;
        }
        if (si < 0 || sj < 0 || si >= a.length || sj >= a[0].length) {
            return 0;
        }
        int cur = 0;
        if (check(a, si, sj, i, j)) {
            cur = (i-si+1)*(j-sj+1);
        }
        int temp = Math.max(rec(a, si, sj, i + 1, j), rec(a, si, sj, i, j + 1));
        return Math.max(temp, cur);
    }

    static boolean check(int[][] a, int si, int sj, int i, int j){
        int sum=0;
        for(int k=si; k<=i; k++){
            for(int l=sj; l<=j; l++){
                sum+=a[k][l];
            }
        }
        if(sum==((i-si+1)*(j-sj+1))/2) {
            // System.out.println(sum+ " "+ (i+" "+(i-si+1))+ " "+ (j+ " "+(j-sj+1)));
            return true;
        };
        return false;
    }

    public static void main(String[] args) {
        int[][] a = { {0, 0, 1, 1},
        {0, 1, 1, 1} };
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                max = Math.max(max, rec(a, 0,0,0,0));
            }
        }
        System.out.println(max);
    }
}
