public class minJumps {
    // public static int min(int[] a) {
    //     int min=0, n=a.length, r=n-1;
        
        
    //     return min;
    // }
    public static int mindJumps(int arr[], int l, int h) 
    { 
        // Base case: when source 
        // and destination are same 
        if (h == l) 
            return 0; 
  
        // When nothing is reachable 
        // from the given source 
        // if (arr[l] == 0) 
        //     return Integer.MAX_VALUE; 
  
        // Traverse through all the points 
        // reachable from arr[l]. Recursively 
        // get the minimum number of jumps 
        // needed to reach arr[h] from these 
        // reachable points. 
        int min = Integer.MAX_VALUE; 
        for (int i = l + 1; i <= h && i <= l + arr[l]; 
             i++) { 
            int jumps = mindJumps(arr, i, h); 
            System.out.println(jumps+" "+min);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min) 
                min = jumps + 1; 
        } 
        return min; 
    } 
    

    // public static int rec(int[] a,int i, int min, int jump) {
    //     // if(i>=a.length) 
    //     if(i==a.length-1){
    //         return 0;
    //     }
    //     // int min=1000;
    //     for(int j=i+1; j<a.length&&j<=j+a[j]; j++){
            
    //     }
    // }
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,1,1};
        int k=mindJumps(arr,0, arr.length-1);
        // int k=rec(arr,0);
        System.out.print(k);
    }
}
