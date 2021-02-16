import java.util.Scanner;

public class heroFight {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            int n=s.nextInt();
            int[] a =new int[n];
           int lowest=Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                a[i]=s.nextInt();
                if(a[i]<lowest){
                    lowest=a[i];
                } 
            }
            int f=0;
            for(int i=0; i<n; i++){
               if(a[i]==lowest){
                   f++;
               }
            }
            // System.out.println("Lowest = "+ lowest);
            System.out.println(n-f);


            t--;
        }
       



    
    s.close();
    } 
}
