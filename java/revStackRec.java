import java.util.Stack;

public class revStackRec {
    void insertAtBottom(Stack<Integer> st,int x){
        if(st.isEmpty()){
            st.push(x);
            // return;
        }
        else{
        int t=st.pop();
        insertAtBottom(st, x);
        st.push(t);
    }
    }
    void rev(Stack<Integer> st){
        if(st.isEmpty()) return;
        int x=st.pop();
        rev(st);
        insertAtBottom(st, x);
        //  st.push(x);
    }
 public static void main(String[] args) {
     Stack<Integer> st= new Stack<Integer>();
     st.push(3);
     st.push(6);
     st.push(9);
     st.push(12);
     revStackRec r=new revStackRec();
     r.rev(st);
     while(!st.empty())
     System.out.println(st.pop());
 }   
}
