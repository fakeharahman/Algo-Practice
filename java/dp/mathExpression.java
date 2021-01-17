package dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class mathExpression {
    static String rec(int[] a, char[] e, int i, int j, String[][] dp){
        // int max=Integer.MIN_VALUE;
        String maxString=""+ Integer.MIN_VALUE;
        int sum=0;
        if(i==j){
            return a[i]+ "";
        }
        if(dp[i][j]!=""){
            return dp[i][j];
        }
        for(int k=i; k<j; k++){
            for(int x=0; x<e.length; x++){
                String left=rec(a, e, i, k,dp);
                String right=rec(a, e, k+1, j, dp);
                String ans=left+ e[x]+right; 
                sum =eval(ans, 0, ans.length()-1);    
                int max=eval(maxString, 0, maxString.length()-1);
                if(max<sum){
                    maxString=ans;
                }
            }
        }
        dp[i][j]=maxString;
        return maxString;
    }
    static int comparisonVal(char c){
        if(c=='+'||c=='-'){
            return 1;
        }if(c=='/'||c=='*'){

            return 2;
        }
        return -1;
    }
    static int eval(String s, int i, int j){
        Stack<Character> st= new Stack<>();
        String ans="";
        
        for(int k=i; k<=j; k++){
           char c= s.charAt(k);
          
            if(Character.isDigit(c)){
                ans+=c;
            }else{
                
                while(!st.isEmpty()){
                    if(comparisonVal(st.peek())>=comparisonVal(c))
                    ans+=st.pop();
                    else break;
                }
                st.push(c);
            }
        }
        while(!st.empty()){
            ans+=st.pop();
        }
        // System.out.println(ans);
        Stack<Integer> stack= new Stack<>();
        for(int k=0; k<ans.length(); k++){
            char c= ans.charAt(k);
            // System.out.println(c);
            if(Character.isDigit(c)){
                int ch=Integer.parseInt(c+ "");
                stack.push(ch);
                // System.out.println(stack.peek());
            }else{
                int sum=0;
                int a=stack.pop();
                int b=stack.pop();
                // System.out.println(a+" "+b+ c);
                if(c=='+'){
                    sum=a+b;
                }
                if(c=='-'){
                    sum=b-a;
                }
                if(c=='*'){
                    sum=a*b;
                }
                stack.push(sum);
            }
            // if(!stack.empty())
            // System.out.println(stack.peek());
        }
        return stack.pop();
    }

    static String dp(int[] p, char[] e){
        int n=p.length;
        String m[][] = new String[n][n]; 
  
        int i, j, k, L;
         String q; 
  
        for (i = 1; i < n; i++) 
            m[i][i] = ""; 
  
        // L is chain length. 
        for (L = 2; L < n; L++)  
        { 
            for (i = 1; i < n - L + 1; i++)  
            { 
                j = i + L - 1; 
                if (j == n) 
                    continue; 
                m[i][j] = Integer.MIN_VALUE +""; 
                for (k = i; k <= j - 1; k++)  
                { 
                    // q = cost/scalar multiplications 
                    for (int x=0; x<e.length; x++){
                        q=m[i][k]+e[x]+m[k+1][j];
                        System.out.println(q);
                        if(eval(q, 0, q.length()-1)>eval(m[i][j], 0, m[i][j].length()-1)){
                            m[i][j]=q;
                        }
                    }
                } 
            } 
        } 
  
        return m[1][n - 1]; 
    } 
  
  static String fn(int[] a, char[] e){
      String s="";
      boolean hasAdd=false;
      boolean hasSub=false;
      boolean hasMul=false;
      for(int i=0; i<e.length; i++){
          hasAdd=e[i]=='+' || hasAdd;
          hasSub=e[i]=='-' || hasSub;
          hasMul=e[i]=='*' || hasMul;
      }
    //   System.out.println(hasSub);

      for(int i=0; i<a.length-1; i++){
          if((hasAdd||hasSub)&&hasMul){
              char o=hasAdd?'+':'-';
              if(a[i+1]==0||a[i]==0){
                  s+=a[i]+""+o;
                }else if(a[i]==1||a[i+1]==1){
                    if(hasAdd){
                        s+=a[i]+""+o;
                    }else{
                        s+=a[i]+""+'*';
                    }
                }
                else{
                    s+=a[i]+""+'*';
                }
          }else if(hasMul&&!(hasAdd||hasSub)){
            s+=a[i]+""+'*';
          }
          else if(!hasMul&&hasAdd){
            s+=a[i]+""+'+';
          }else{
            s+=a[i]+""+'-';
          }
        // System.out.println(s+ a[i]);
      }
      return s+a[a.length-1];
  }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a =new int[n];
        for(int i=0; i<n; i++){
            a[i]=sc.nextInt();
        }
        String s=sc.next();
        char[] e=s.toCharArray();
        // int[] a={2,3,1,0};
        // int n=a.length;
        // char[] e={ '*', '-'};
        // String[][] dp=new String[n+1][n+1];
        // for (String[] arr1 : dp) {
        //         Arrays.fill(arr1, "");
        // }
        // System.out.println(rec(a, e, 0, n-1, dp));
        System.out.println(fn(a, e));
        // System.out.println(dp(a, e));
        sc.close();
        // System.out.println(eval("1", 0, 0));
    }
}
