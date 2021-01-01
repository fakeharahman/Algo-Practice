package dp;

public class tergetSum {
    int rec(int[] arr, int n, int cur, int sum){
        if(n==0){
            if(cur==sum){
                return 1;
            }
            return 0;
        }
        return rec(arr, n-1, cur-arr[n-1], sum)+ rec(arr, n-1, cur+arr[n-1], sum);
    }
    public static void main(String[] args) {
        int arr[]={1,1,2,3};
        int n= arr.length;
        int sum=1;
        System.out.println(new tergetSum().rec(arr, n, 0, sum));
    
    }
}
