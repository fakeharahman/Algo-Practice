package dp;
// divide subset to 2 parts and get min dif
// imp
public class noSubsetDif {
    int rec(int[] arr, int n, int sum, int tot, int dif) {
        if (n == 0) {
            if (Math.abs(tot - 2 * sum) == dif) {
                return 1;
            } else {
                return 0;
            }
        }
        int count = rec(arr, n - 1, sum, tot, dif) + rec(arr, n - 1, sum - arr[n - 1], tot, dif);
        return count;

    }

    int rec2(int[] arr, int n, int tot) {

        if (n == 0) {
            if (tot == 0) {
                return 1;
            }
            return 0;
        }
        return rec2(arr, n - 1, tot) + rec2(arr, n - 1, tot - arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 3,2,1,1 };
        int n = arr.length;
        int dif = 1;
        int tot = 0;
        // int z=0;
        for (int i = 0; i < n; i++) {
            tot += arr[i];
            // if(arr[i]==0){
            //     z++;
            // }
            //when in dp, pow(2, z)*ans;
        }
        if ((tot + dif) % 2 != 0) {
            System.out.println(0);
        } else {
            System.out.println(new noSubsetDif().rec2(arr, n, (tot + dif) / 2));
        }
        int[][] dp = new int[n + 1][tot + 1];
        System.out.println(new noSubsetDif().rec(arr, n, tot, tot, dif) / 2);
        dp[0][0] = 1;

    }
}
