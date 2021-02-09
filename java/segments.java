import java.util.Scanner;

public class segments {
    static int sol(int[] a, int n){
        int x=0, y=0;
        int xp=-1, yp=-1;
        for(int i=0; i<n; i++){
            if(xp!=a[i]){
                x++;
                xp=a[i];
            }else if(yp!=a[i]){
                y++;
                yp=a[i];
            }
            
        }
        return x+y;
    }
    // static int px=-1, py=-1;
    // static int rec(int[] a, int n){
    //     if(n==0){
    //         return 0;
    //     }

    // }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n= s.nextInt();
        int[] a= new int[n];
        for(int i=0; i<n; i++){
            a[i]=s.nextInt();
        }
        // int a[]={1,2,3,1,2,2};
        System.out.println(sol(a, a.length));
        s.close();
    }
}
