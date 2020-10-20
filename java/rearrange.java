class Solution {
    
    static void swap(int[] arr, int a, int b) {
     int temp=arr[a];
     arr[a]=arr[b];
     arr[b]=temp;

 }

 static int arrange(int[] arr, int n){
     int i=0, j=1;
    //  for(; j<n; j++){
    //     while(arr[i]>0){
    //         i++;
    //     }
    //     if(j>i&&arr[j]>=0){
    //         swap(arr, i,j);
    //         i++;
    //     }
        
        int[] arr1;
    //  }
    //  // System.out.print(i+ " "+ j);
     i = -1; 
    for ( j = 0; j < n; j++) 
    { 
        if (arr[j] < 0) 
        { 
            i++; 
            swap(arr, i,j); 
        } 
    }
     if(arr[i]>0){
         i++;
     }
      j=1;
//  while(i<n&&j<n){
//      swap(arr, i, j);
//          i++;
//          j=j+2;
//  }
    // System.out.print(i);
     return i;
 }
 
 static void rearrange(int arr[], int n) {
     // code here
     int i=0, j=0;
     int k=0;
     int[] arr1=new int[n];
     while(i<n&&j<n&&k<n){
         while(arr[i]<0&&i<n&&arr[i]!=arr[n-1]){
            // System.out.println("i= "+arr[i]);                
             i++;
         }
         while((arr[j]>=0)&&j<n-1){
            System.out.println("i= "+arr[j]);                
             j++;
         }
         if(i<n&&j<n&&k<n){
         System.out.println(i+" "+j+" ");
         arr1[k]=arr[i];
         i++;
         if(k+1<n)
         arr1[k+1]=arr[j];
         j++;
         k+=2;}

     }
     k=n;
     if(i!=n){
        while(i<n-1){
             while(arr[i]<0&&i<n-1){
            i++;
        }
        arr1[k]=arr[i];
        i++;
        k++;
        }
    }
     for(k=0; k<n; k++)
     System.out.print(arr1[k] + " ");
 }
 public static void main(String[] args) {
   int[] arr={9,4,-2,-1,5,0,-5,-3,2,8,8};
   int n=11;
   rearrange(arr, n);  
//    for(int i=0; i<n; i++){
//     System.out.print(arr[i]+" ");
//    }
 }}