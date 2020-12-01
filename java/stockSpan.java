import java.util.Stack;

public class stockSpan {

    void getSpan(int[] a){
        int[] s=new int[a.length];
        Stack<Integer> st= new Stack<Integer>();
        s[0]=1;
        st.push(0);
        for(int i =1 ; i<a.length; i++){
            while(!st.isEmpty()&&a[st.peek()]<=a[i]){
                st.pop();
            }
            s[i]=i-st.peek();
            st.push(i);
        }
        for(int i: s){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int[] a = {100, 80, 60, 70, 60, 75, 85};
        stockSpan s= new stockSpan();
        s.getSpan(a);
    }
}
