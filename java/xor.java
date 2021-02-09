//codenation question 5 importatnt
public class xor {

    static int sol(int[] a, int n) {
        int[][] m = new int[n + 1][31];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 31; j++) {
                int x = getBit(a[i], j);
                m[i][j] = x;
            }
        }
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < n; j++) {
                if (m[j][i] == 1) {
                    ans += Math.pow(2, i);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 6,5,4 };
        int n = a.length;
        System.out.println(sol(a, n));
    }

    static int getBit(int n, int k) {
        return (n >> k) & 1;
    }
}
