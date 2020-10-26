public class heapSort {
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
    public static int delete(int[] a, int n) {
        int key = a[1];
        a[1]=a[n-1];
        int i=1;
        int j=i*2;
        while(j<n-1){
            if(a[j+1]<a[j])
            j=j+1;
            if(a[i]>a[j]){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i=j;
                j=2*i;
            }else{break;}
        }
        return key;
    }

    public static void sort(int[] a) {
        int n=a.length;
        int j=0;
        for(int i =1; i<a.length; i++ ){
           int k= delete(a, n-j);
           a[n-i]=k;
           System.out.println(k+ " "+ (n-i));
           j++;
            
        }
    }

    public static void heapify(int[] a) {


        for(int i=1; i<a.length; i++){
            int key=a[i];
            int j=i;
            while(key<a[j/2]&& j>=0){
                // System.out.println(j);
                a[j]=a[j/2];
                j=j/2;
            }
            a[j]=key;
        //    int index=i+1;

       }
        
    }
    public static void main(String[] args) {
        int[] a={0,8,12,5,9,7,4,6};
        heapify(a);
        // delete(a, a.length);
        printArray(a);

        sort(a);

        printArray(a);
        
    }
}
