import java.util.Stack;

public class infixToPostfix {

    int comparisonVal(char c){
        if(c=='+'||c=='-'){
            return 1;
        }if(c=='/'||c=='*'){

            return 2;
        }
        return -1;
    }

    String conversion(String s){
        Stack<Character> st= new Stack<Character>();
        String ans="";
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                ans= ans + c;
            }else if(c=='('){
                st.push(c);
            }else if(c==')'){
                while(st.peek()!='('){
                    char ch=st.pop();
                    System.out.println(ch);
                    ans=ans+ch;
                }
                st.pop();
            }else if(st.empty()){
                st.push(c);
            }
            else{
                int top=comparisonVal(st.peek());
                int x= comparisonVal(c);
                if(x>top){
                    st.push(c);
                }else{
                    // ans=ans+c;
                    while(!st.empty()){
                        char ch=st.pop();
                        ans=ans+ch;
                    }
                    st.push(c);
                }
            }
            if(!st.empty())
            System.out.println(st.peek());
        }
        while(!st.empty()){
            char ch=st.pop();
            ans=ans+ch;
        }
        return ans;
    }
    public static void main(String[] args) {
        infixToPostfix itp=new infixToPostfix();
        String a="a+b+c+d";
        System.out.println(itp.conversion(a));
    }
}
