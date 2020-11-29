public class shortestPath {

    public static int path(int[][] a, int r, int c, int x, int y) {
        int rows=a.length;
        int cols=a[0].length;
        boolean vis[][]=new boolean[rows][cols];
        // int minSteps=100000;
        // if(a[r+1][c]==0&&a[r-1][c]==0&&a[r][c+1]==0&&a[r][c-1]==0) return minSteps;
        // if(r+1==a.length&&r-1<0&&c+1==a[0].length&&c-1<0) return minSteps;
        // path(a, r+1, c);
        // path(a, r-1, c);
        // path(a, r, c+1);
        // path(a, r, c-1);
        path(a, r, c, x, y, vis);
    }
    public static boolean isValid(int[][] a, int r, int c,, boolean[][] vis) {
        
    }
    public static int path(int[][] a, int r, int c, int x, int y, boolean[][] vis) {
        
    }
    public static void main(String[] args) {
        
    }
}
