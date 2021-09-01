import java.util.Scanner;

public class PleasentPairs {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            int n=s.nextInt();
            int[] a=new int[n];
            for(int i=0; i<n; i++){
                a[i]=s.nextInt();
            }
            int ans=0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    if(i+j+2==a[i]*a[j]){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
            t--;
        }

       
        s.close();
    }
}
