import java.util.Scanner;

public class kDivSum {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
        int n=s.nextInt();
        int k=s.nextInt();
        if(n>k){
            int temp=n%k;
            if(temp==0){
                k=n;
            }else
            k=n+k-temp;
        }
        int ans=k/n;
        if(k%n>0){
            ans++;
        }

        System.out.println(ans);
    t--;}
    s.close();
    }
}
