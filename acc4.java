import java.util.Stack;

public class acc4 {
    public static void main(String[] args) {
        Stack<Character> st=new Stack<>();
        String s="()";
        boolean flag=false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=')') st.push(s.charAt(i));
            else{
                if(st.peek()=='('){
                    flag=true;
                    System.out.println("Input string contains duplicate parenthesis");
                    break;
                }else{
                    while(st.peek()!='(') st.pop();
                    st.pop();
                }
            }
        }
        if(!flag)
        System.out.println("Input string does not contain duplicate parenthesis");
    }
}
