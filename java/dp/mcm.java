package dp;

public class mcm {
    int rec(int[] a, int i, int j){
        int min=Integer.MAX_VALUE;
        if(i>=j){
            return 0;
        }
        for(int k=i; k<j;k++){
            int temp=rec(a, i, k)+ a[k]*a[i-1]*a[j]+rec(a, k+1, j);
            min=Math.min(temp, min);
        }
        return min;
    }
    public static void main(String[] args) {
        int[] a={10,30,5,60};
        int n=a.length;
        System.out.println(new mcm().rec(a, 1, n-1));
    }
}
