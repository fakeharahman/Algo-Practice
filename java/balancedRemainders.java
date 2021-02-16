import java.util.Scanner;

public class balancedRemainders {
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
            int c1=0, c2=0, c0=0;
            for(int i=0; i<n; i++){
                if(a[i]%3==0) c0++;
                if(a[i]%3==1) c1++;
                if(a[i]%3==2) c2++;
            }
            int k=n/3;
            if(c0!=k){
                int x=c0-k;
                if(x>0){
                    c1+=x;
                    ans=ans+Math.abs(x);
                }else{
                    c2+=x;
                    ans=ans+Math.abs(x);
                }
            }
            if(c1!=k){
                int x=c1-k;
                if(x>0){
                    c2+=x;
                    ans=ans+Math.abs(x);
                }else{
                    ans=ans+Math.abs(x)*2;
                    
                }
            }
            System.out.println(ans);
            t--;
        }
        s.close();
    }
}
