package dp;

public class activities {
    static int c = 0;

    static int rec(int[] a, int n, int m, int prev, int count) {
        if (n < 0)
            return 0;
        if (n == 0) {
            return 1;
        }
        if (prev != a.length && count > a[prev])
            return 0;
        // if(count <a[m])
        // x=rec(a, n-1, m, m, count+1);
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == prev)
            temp += rec(a, n - 1, m, i, count + 1);
            else
            temp += rec(a, n - 1, i, i, 1);
        }
        return temp%1000000007;
    }
    static int newRec(int n, int[] a, int crn, int p, int c){
        if(crn > n) return 0;
        
        if(p > 0 && a[p-1] < c) return 0;
        
        if(crn == n) return 1;

        int ans = 0;
        for(int i = 0 ; i < a.length; i++){
			//if prev roll is same increase c else c will be 1 in else part
            if(p == i+1) 
                ans = (ans + newRec(n, a, crn+1, i+1, c+1)) ;
            else
                ans = (ans + newRec(n, a, crn+1, i+1, 1)) ;
        }
        
        return ans%1000000007;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int[] a = { 4, 4, 4 };
        System.out.println(rec(a, n, m - 1, m, 0));
        System.out.println(newRec(n, a, 0, 0, 0));

    }
}
