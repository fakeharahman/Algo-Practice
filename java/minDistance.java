public class minDistance {
    public static int min(int[] a, int x, int y) {
        int cur=0, min=10000000, lastSeen=0, p=0, l=-1, n=a.length, hasFound=0;

        while(l<n && p<n){
            // System.out.println("cur  "+ cur + " "+ l +" "+ lastSeen);
            if(lastSeen!=0&&(a[l]==x||a[l]==y)){

                if(lastSeen!=a[l]){
                    p=l;
                    // System.out.println("haha "+ cur);
                    // hasFound=0;
                    lastSeen=a[l];
                min=Math.min(cur, min);
                cur = 0;
            }
            }
            if((a[p]==x||a[p]==y)&&hasFound==0){
                lastSeen=a[p];
                l=p;
                hasFound=1;
            }
            if(hasFound==0){
                p++;
            }else{
                l++;
                cur++;
            }
        }
        
        // for(int i=0;i<a.length; i++){
        

        // }
        return min;
    }
    public static void main(String[] args) {
      int[] a=  {3,5,4,2,6,3,0,0,5,4,8,3};
      int x=3, y=6;
      int ans = min(a, x, y);
      System.out.println(ans);
    }
}
