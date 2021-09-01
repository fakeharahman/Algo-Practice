// import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;

public class graycode{
    static List<Integer> ans;
    public static void main(String[] args) {
        int n=2;
        ans=new LinkedList<Integer>();
        // List<Integer> ans=new ArrayList<Integer>();
        int prev=0;
        ans.add(prev);
        int cur=0;
        for(int i=0; i<n; i++){
            
            for(int j=i+1; j<n; i++){
                
            }
            prev=prev^(1<<i);
            ans.add(prev);
        }
    }
    void rec(int n, int cur, int ans){
        if(n==0){
            ans.add(cur);
            return;
        }
        

    }
}