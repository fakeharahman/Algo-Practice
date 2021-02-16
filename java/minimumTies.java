import java.util.Scanner;

public class minimumTies {
    static int ans[];
   static int flag=0;
    static void rec(int n, int[] arr, int[] sc){
        if(flag==1) return;
        if(n==0){
            if(isEqual(sc)){
                ans=arr;
                flag =1;
            }
            return;
        }

    }
    static boolean isEqual(int[] sc){
        int x=sc[1];
        for(int i=2; i<sc.length; i++){
            if(sc[i]!=x){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            int n=s.nextInt();
            int[] a = new int[n+1];



            t--;
        }
    }
}
