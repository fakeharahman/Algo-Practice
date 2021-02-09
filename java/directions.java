import java.util.HashMap;
import java.util.Scanner;

public class directions {
    static String sol(char[] a, int x, int y){
        HashMap<String,Integer> m=new HashMap<String,Integer>();
        m.put("U", 0);
        m.put("D", 0);
        m.put("L", 0);
        m.put("R", 0);
        int x1=0, y1=0;
        for(int i=0; i<a.length; i++){
            if(a[i]=='R'){
                x1+=1;
               m.put("R", m.get("R")+1) ;
                
            }
            if(a[i]=='L'){
                x1-=1;
                m.put("L", m.get("L")+1) ;
            }
            if(a[i]=='U'){
                y1+=1;
                m.put("U", m.get("U")+1) ;
            }
            if(a[i]=='D'){
                y1-=1;
                m.put("D", m.get("D")+1) ;
            }
        }
        if(x1==x&&y1==y){
            return "YES";
        }
        int dx=(x-x1);
        int dy=(y-y1);
        // boolean h=false;
        int u=0;
        int v=0;
        if(dy<0){
             u=m.get("U");
        }else if(dy>=0){
            u=m.get("D");
        }
        if(dx<0){
            v=m.get("R");
        }
        else{
            v=m.get("L");
        }
        if(u>=Math.abs(dy)&&v>=Math.abs(dx)){
            return "YES";
        }else{
            return "NO";
        }

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
        int x=s.nextInt();
        int y=s.nextInt();
        String str = s.next();
        char a[]= str.toCharArray();
        System.out.println(sol(a, x, y));
        
        // int[] arr= {5,3,1};
        // int n=3;
        // int k=1;
      
        
    t--;}
    s.close();
    }
        // int x=1;
        // int y=1;
        // String s1="UDDDRLLL";
       
    // }
}
          