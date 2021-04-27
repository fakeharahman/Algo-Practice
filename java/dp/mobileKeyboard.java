package dp;

public class mobileKeyboard {
    static int dp[][][] = new int[10][10][30];

    static int rec(char[][] a, int n, int i, int j, int s) {
        // if(s==n){
        // return 1;
        // }

        s++;
        if (i >= a.length || i < 0 || j >= a[0].length || j < 0) {
            return 0;
        }
        if (a[i][j] == '#') {
            return 0;
        }
        if (dp[i][j][s] != 0) {
            return dp[i][j][s];
        }
        if (s == n) {
            return 1;
        }
        dp[i][j][s]=  rec(a, n, i, j, s) + rec(a, n, i - 1, j, s) + rec(a, n, i + 1, j, s) + rec(a, n, i, j - 1, s)
                + rec(a, n, i, j + 1, s);
        return  dp[i][j][s];
    }

    public static void main(String[] args) {
        int arr[] = new int[10];
        char[][] a = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '#', '0', '#' } };
        int n = 3;
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == '#') {
                    continue;
                }
                int k = Integer.parseInt(a[i][j] + "");
                if (arr[k] == 0) {
                    arr[k] = rec(a, n, i, j, 0);
                }
                // if (k == 1) {
                //     arr[7] = arr[3] = arr[9] = arr[1];
                // }
                // if (k == 2) {
                //     arr[4] = arr[6] = arr[2];
                // }
                // if (k == 5) {
                //     arr[8] = arr[5];
                // }
                c += arr[k];
            }
        }
        System.out.println(c);
    }
}
