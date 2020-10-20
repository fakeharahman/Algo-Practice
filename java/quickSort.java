import java.util.*;

public class quickSort {

     static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

    }

     static int partition(int[] arr, int l, int h) {
        int pivot=arr[l];
        int i=l;
        int j=h;
        do{
            do{
                j--;
            }while(arr[j]>pivot);
            do{
                i++;
            }while(arr[i]<=pivot);
            if(i<j){
                swap(arr, i, j);
            }
        }while(i<j);
        swap(arr, j, l);
        return j;
    }

    public static void sorting(int[] arr, int l, int r) {
        if(l<r){
            int j=partition(arr, l, r);
            sorting(arr, l, j);
            sorting(arr, j+1, r);
        }
        
    }
  public static void main(String[] args) {
        int[] arr={5,7,6,9,4,8,1,2,3, 5000};
        // partition(arr, 0, 9);
        sorting(arr, 0, 9);
        for(int i=0; i<arr.length-1; i++){
            System.out.print(arr[i]);
        }
    }
}
