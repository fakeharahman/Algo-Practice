import java.util.Scanner;

public class prettyPermutations {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            int n=s.nextInt();
            int[] ans=new int[n];
            // System.out.print(n+" ");
            int k=0;
            // int m=n;
            // if(n%2!=0){
            //     m=n-1;
            // }
            for(int i=1; i<n; i=i+2){
               ans[k++]=i+1;
               ans[k++]=i;
            }
            if(n%2!=0){
                int temp=n;
                ans[n-1]=ans[n-2];
                ans[n-2]=temp;
            }
            for(int i=0; i<n; i++){
                System.out.println(ans[i]);
             }
            t--;
        }

       
        s.close();

    }
}
