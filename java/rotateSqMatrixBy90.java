public class rotateSqMatrixBy90 {
    static void rotate(int[][] a){
        int n=a.length;
        for(int i=0; i<n/2; i++){
            for(int j=i; j<n-i-1; j++){
                int temp=a[i][j]; 
                a[i][j]=a[j][n-i-1];
                a[j][n-i-1]=a[n-1-i][n-1-j];
                a[n-1-i][n-1-j]=a[n-1-j][i];
                a[n-1-j][i]=temp;
            }
        }
        displayMatrix(n, a);
    }

    static void displayMatrix(
        int N, int mat[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                    " " + mat[i][j]);
 
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        int[][] a={
            {1, 2},
            {4, 5}
        };
        rotate(a);
    }
}
