import java.util.Scanner;

public class nonZero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            int[] a= new int[n];
            for(int i=0; i<n; i++){
                a[i]=sc.nextInt();
            }
            int sum=0;
            int ans=0;
            for(int i=0; i<n; i++){
                if(a[i]==0){
                    a[i]=1;
                    ans++;
                }
                sum+=a[i];
            }
            if(sum==0){
                ans++;
            }
            System.out.println(ans);
            t--;
        }
        sc.close();;
    }
    
}
