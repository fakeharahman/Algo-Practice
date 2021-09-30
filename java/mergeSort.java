import java.util.Arrays;

public class mergeSort {
    
    static void merge(int[] a, int l, int h, int k){
        // int a1[] =Arrays.copyOfRange(a, l, k);
        // int a2[]=Arrays.copyOfRange(a, k+1, h);
        int n1=k-l+1;
        int n2=h-k;
        int a1[] = new int[n1];
        int a2[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            a1[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            a2[j] = a[k + 1 + j];

        int i=0;
        int j=0;
        while(i<a1.length&&j<a2.length){
            if(a1[i]<=a2[j]){
                a[l++]=a1[i++];
            }else{
                a[l++]=a2[j++];
            }
        }
        while(i<a1.length){
            a[l++]=a1[i++];
        }
        while(j<a2.length){
            a[l++]=a2[j++];
        }
        for(int t=0; t<a.length; t++){
            System.out.print(a[t]+" ");
        }
        System.out.println();
    }
    static void sort(int[] a, int i, int j){
        if(i==j) return;
        if(i>j) return;
        int k=(i+j)/2;
        System.out.println(i+" "+ j+" "+ k);
        sort(a, i, k);
        sort(a, k+1, j);
        merge(a, i, j, k);
    }
    public static void main(String[] args) {
        int a[] = {10, 80, 30, 90, 40, 50, 70};
        sort(a, 0, a.length-1);
        // merge(a, 0, a.length-1, 3);
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
