package dp;

public class resourceCollection {

    static int rec(int[][] a, int[][] b, int i, int n){
        if(i<0){
            return suma(a, b, 0, a[0].length-1, n);
        }
        if(n<0){
            return 0;
        }
        int x=sumb(a, b, 0, i, n)+suma(a, b, i+1, a[0].length-1, n);
        int temp= Math.max(rec(a, b, i, n-1)+x, rec(a, b, i-1, n));
        return temp;
        
    }
    static int suma(int[][] a, int[][] b, int i, int j, int n){
        int sum=0;
        for(int k=i; k<=j; k++){
            sum+=a[n][k];
        }
        return sum;
    }
    static int sumb(int[][] a, int[][] b, int i, int j, int n){
        int sum=0;
        for(int k=i; k<=j; k++){
            sum+=b[n][k];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] a={{1,0,1}};
        int[][] b={{2,1,0}};
        System.out.println(rec(a, b, a[0].length-1, a.length-1));
        
    }
}
