
import java.util.*;

// import java.lang.*;
// import java.io.*;
public class maxEquiSum {

    public static int fun(int[] a, int n) {
        int i=0, j=n, isum=0, jsum=0;

       for( i=0; i<n ; i++){
           isum+=a[i];
       }
       for(j=n-1; j>=0; j--){
           jsum+=a[j];
           if(isum==jsum){
               return jsum;
            }
            isum=isum-a[j];
       }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {1,4,6,-3 };
        int n = a.length;
        int j=fun(a, n);
        System.out.print(j);
    }
}
