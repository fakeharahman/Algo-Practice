import java.util.Scanner;

public class hero {
   
    static String sol(int p, int h, int n, int[] mp, int[] mh){
        int high=0;
        for(int i=0; i<n; i++){
        //    int x=mh[i];
        if(high<mp[i]) high=mp[i];
        if(h<=0) return "NO";
           int times=0;
           if(mh[i]<p){
            times = 1;
           }else{
               if(mh[i]%p==0)
                times=(mh[i]/p);
                else{
                    times=mh[i]/p+1;
                }
            }
            // int temp=mh[i]-p*times;
            // if(temp>0) return "NO";

            h=h-mp[i]*times;
            
           
            // System.out.println(times + " "+ h);
        //    if(h==0&&i==n-1) return "YES";
        }
        if(h<=0){
            if(h+high>0){
                return "YES";
            }
            return "NO";
        }
        // if(h==0) return ""
        return "YES";
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
        int p=s.nextInt();
        int h=s.nextInt();
        int n=s.nextInt();
        int mp[] = new int[n];
        int mh[] = new int[n];
        for(int i=0; i<n; i++){
            mp[i]=s.nextInt();
        }
        for(int i=0; i<n; i++){
            mh[i]=s.nextInt();
        }
        // sort(mp, mh, 0, n-1);
      System.out.println(sol(p, h, n, mp, mh));
    t--;}
    s.close();
        // int p=1000;
        // int h=1000;
        // int n=4;
        // int[] mp={200,300,400,500};
        // int[] mh={1000};
        // System.out.println(sol(p, h, n, mp, mh));

    }
}
