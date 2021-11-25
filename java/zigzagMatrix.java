public class zigzagMatrix {
    static boolean valid(int n, int m, int i, int j) {
        if (i >= n || j >= m || i < 0 || j < 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        boolean down = false;
        int i = 0, j = 0;
        while (true) {
            System.out.println(a[i][j] + " ");
            if (i == n - 1 && j == m - 1)
                break;
            if (down) {
                if (!valid(n, m, i + 1, j - 1)) {
                    if (valid(n, m, i + 1, j)) {
                        i++;
                        down = !down;
                    } else {
                        j++;
                        down = !down;
                    }
                } else {
                    i++;
                    j--;
                }
            } else {
                if (!valid(n, m, i - 1, j + 1)) {
                    if (valid(n, m, i, j + 1)) {
                        j++;
                        down = !down;
                    } else {
                        i++;
                        down = !down;
                    }
                } else {

                    i--;
                    j++;
                }
            }
        }

    }
}
