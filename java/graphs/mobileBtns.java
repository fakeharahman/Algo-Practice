package graphs;

import java.util.ArrayList;
import java.util.List;

public class mobileBtns{
    static List<String> ans=new ArrayList<String>();
    static String[] list={"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    // public List<String> letterCombinations(String digits) { 
    //     dfs(digits, "");
    //     return ans;
        
    // }
    public static void dfs(String d, String cur){
        if(d==""){
            ans.add(cur);
            System.out.println(cur);
            return;
        }
        int k=Integer.parseInt(d.charAt(0)+"");
        // System.out.println(list[k-2]);
        for(int i=0; i<list[k-2].length(); i++){
            dfs(d.substring(1), cur+list[k-2].charAt(i));
        }
    }
    public static void main(String[] args) {
        dfs("23", "");
    }
}