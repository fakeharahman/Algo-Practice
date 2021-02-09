import java.util.Scanner;

public class lexographically {
    static String sol(String s){
        int n=s.length();
        String ans="";
        for(int i=0; i<n; i++){
            if(i%2==0){
                if(s.charAt(i)=='a'){
                    ans+="b";
                }else{
                    ans+="a";
                }
            }else{
                if(s.charAt(i)=='z'){
                    ans+="y";
                }else{
                    ans+="z";
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            String st=s.next();
            System.out.println(sol(st));
    t--;}
    s.close();
        // String s="az";
        // System.out.println(sol(s));
    }
}
