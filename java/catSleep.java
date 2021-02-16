import java.util.Scanner;

public class catSleep {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            int n=s.nextInt();
            int k=s.nextInt();
            boolean isEven=false;
            if(n%2==0) isEven=true;
            int ans;        
             int m=k%(n+1);    
            if(isEven){
                ans=m;
            }else{
               
                ans=((m)-((k/n)%n));
                
                
            }

           System.out.println(ans);


            t--;
        }
       



    
    s.close();
    } 
}
