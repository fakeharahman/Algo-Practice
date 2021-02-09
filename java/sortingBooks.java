import java.util.HashMap;
import java.util.Scanner;
public class sortingBooks {
   static int sol(int a[], int n){
        
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
        int ans=0;
        int last=a[n-1];
        for(int i=0; i<n; i++){
            if(m.get(a[i])==null){
                int c=0;
                int x=a[i];
                while(i<n&&a[i]==x){
                    i++;
                    c++;
                }
                i--;
                m.put(a[i], c);
            }else{
                int k=m.get(a[i]);
                int c=0;
                int x=a[i];
                while(i<n&&a[i]==x){
                    i++;
                    c++;
                }
                i--;
                if(i==n-1){
                    ans+=k;
                }else{
                    ans+=k+1;
                }
               
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a={1,2,2,1,1};
        int n=a.length;
        System.out.println(sol(a, n));

    }
}
