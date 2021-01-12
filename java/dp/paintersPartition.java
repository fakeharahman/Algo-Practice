package dp;

public class paintersPartition {
    int rec(int[] a, int i, int j, int p) {
        int min = Integer.MAX_VALUE;
        if (i > j) {
            return 0;
        }
        if (p == 1) {
            return sum(a, i, j);
        }
        for (int k = i; k <= j; k++) {
            int temp = Math.max(sum(a, i, k), rec(a, k + 1, j, p - 1));
            min = Math.min(temp, min);
        }
        return min;
    }

    int sum(int[] a, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += a[k];
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] a={ 10, 20, 60, 50, 30, 40 }; 
        int n=a.length;
        int p=3;
        System.out.println(new paintersPartition().rec(a, 0, n-1, p));
    }
}
