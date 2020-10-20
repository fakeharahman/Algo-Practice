public class pushZerosToEnd {
    public static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
   
    }
      public static void push(int[] arr, int n) {
           // code here
           int i=0, count =0;
           for(i=0; i<n; i++){
            if(arr[i]!=0){
                arr[count++]=arr[i];
                // count++;
            }
           
           }
           while(count<n){
            arr[count++]=0;
        }
        //    while(i<n-1){
        //        while(arr[i]!=0&&i<n-1){
        //            i++;
        //        }
        //        if(i>=n-1){
        //         return;
        //     }
        //        if(i+1<n)
        //        j=i+1;
        //        while(j<n-1&&arr[j]==0){
        //            j++;
        //        }
        //        swap(arr, i, j);
        //        i++;}
               
           }
           public static void main(String[] args) {
               int[] arr={3,3,0};
               int n=3;
               push(arr, n);
               for(int i=0; i<n; i++){
                   System.out.print(arr[i]+" " );
               }
            
           }
}
