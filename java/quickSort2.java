public class quickSort2 {
    static int pivot(int[] a, int low, int high){
        int i=low;
        int j=high-1;
        int pivot=a[high];
        while(i<j){
            if(a[i]>pivot&&a[j]<pivot){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
                j--;
            }else if(a[j]>pivot) j++;
            else i++;
            
        }
        j++;
        int temp=a[j];
        a[j]=a[high];
        a[high]=temp;
        return j;
    }
    static void quickSort(int[] a, int low, int high){
        if(high<=low) return;
        int p=pivot(a, low, high);
        quickSort(a, low, p-1);
        quickSort(a, p+1, high);
    }
    public static void main(String[] args) {
        int a[] = {10, 80, 30, 90, 40, 50, 70};
        // System.out.println(pivot(a, 0, a.length-1));
        quickSort(a, 0, a.length-1);
        
    }
}
