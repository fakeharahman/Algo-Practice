import java.util.Scanner;

public class denseArray {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            int n=s.nextInt();
            int[] a = new int[n];
            int ans=0;
            for(int i=0; i<n; i++){
                a[i]=s.nextInt();
            }
            for(int i=0; i<n-1; i++){
                int min=Math.min(a[i], a[i+1]);
                int max=Math.max(a[i], a[i+1]);
                while(min*2<max){
                    min=min*2;
                    ans++;
                }
                
            }
            System.out.println(ans);

            t--;
        }
        s.close();
    }
}
