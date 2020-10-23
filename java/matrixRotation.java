public class matrixRotation {

    public static void rotatate(int[][] a) {
        int R = 4, C = 4;
        int r = 0, c = 0;
        int prev;
        int cur;
        while (r < R && c < C) {
            if (r + 1 == R || c + 1 == C)
                break;
            prev = a[r + 1][c];
            for (int i = 0; i < C; i++) {
                cur = a[r][i];
                a[r][i] = prev;
                prev = cur;
            }
            r++;
            for (int i = r; i < R; i++) {
                cur = a[i][C - 1];
                a[i][C - 1] = prev;
                prev = cur;
            }
            C--;
            if(r<R){
            for (int i = C - 1; i >= 0; i--) {
                cur = a[R - 1][i];
                a[R - 1][i] = prev;
                prev = cur;
            }}
            R--;
            if(c<C){
            for (int i = R - 1; i >= 0; i--) {
                cur = a[i][c];
                a[i][c] = prev;
                prev = cur;
            }}
            c++;
            System.out.println(r + " " + c + " " + R + " " + C);
        }
    }

    public static void main(String[] args) {
        int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        rotatate(a);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(a[i][j] + " ");
            System.out.print("\n");
        }
    }
}
