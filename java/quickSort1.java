import java.util.*;

public class quickSort1 {

     static int partiton(int[] arr,int l,int r,int p){
        while(l<=r){
            while(arr[l]<p){
                l++;
            }
            // System.out.print(r);
            while(arr[r]>p){
                r--;
            }
            if(l<=r){
                int temp=arr[l];
                arr[l++]=arr[r];
                arr[r--]=temp;
            }
        }
        // int temp=arr[l];
        // arr[l]=arr[(l+r)/2];
        // arr[(l+r)/2]=temp;
        return l;
    }
     static void quickSort(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int pivot=arr[(l+r)/2];
        int p = partiton(arr, l, r , pivot);
        quickSort(arr, l, p-1); //pivot is the aage wala point
        quickSort(arr, p, r);
        
    }
    public static void main(String[] args) {
        int[] arr = {1,2,7,8,9,13,3,4};
        int n= arr.length;
        quickSort(arr, 0, n-1);
            for(int i=0; i<n; i++){
                System.out.print(arr[i]+ " ");
            }
    }
}
