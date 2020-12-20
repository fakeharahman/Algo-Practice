//imp
import java.util.Stack;

public class celebStack {
    int findCeleb(int[][]a){
        Stack<Integer> st= new Stack<Integer>();
        for(int i=0; i<a.length; i++){
            st.push(i);
        }
        while(st.size()!=1){
            int b=st.pop();
            int c=st.pop();
            System.out.println(c);
            if(a[b][c]==1&&a[c][b]==0){
                st.push(c);
            }
            // else if(a[b][c]==a[c][b]){
            //    return -1;
            // }
            else{
                st.push(b);
            }

        }
        return st.pop();
    }
    public static void main(String[] args) {
        int a[][]={{0, 1, 0, 0}, 
        {0, 0, 0, 0}, 
        {1, 1, 0, 0}, 
        {1, 1, 1, 0}};
       celebStack c=new celebStack();
       int t=c.findCeleb(a);
       System.out.println(t);
    }
}
