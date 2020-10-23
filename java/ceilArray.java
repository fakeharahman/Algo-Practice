public class ceilArray {


    public static void main(String[] args) {
        int[] a = {1, 2, 8, 10, 10, 12, 19};
        int k=5;
        int n = a.length;
        int  r=n-1, l=0; 
        int ans=-1;
        int ceil=-1, floor=-1;
        while(r>=l){
            int i=(r+l)/2;
            if(k==a[i]){
                ans=i;
                ceil=a[i];
                floor=a[i];
                break;
            }
            if(k>a[i]){
                l=i+1;
            }
            else{
                r=i-1;
            }
            // System.out.println( " "+l+" "+ r);
        }
        // System.out.print(ans+ " "+l+" "+ r);
        if(ans==-1){
            ceil=a[l];
            floor=a[r];
        }
        // int j=fun(a, n);
        System.out.print(ceil+" "+ floor);
    }
}
