import java.util.LinkedList;
import java.util.List;

public class combinationSumLeetCode {
    public static void rec(List<List<Integer>> ans, int[] A, int t, int i, List<Integer> cur){
        if(i>=A.length) return;
        if(t<0) return;
        if(t==0){
            // if(ans.size()==0){
            //     List<Integer> temp=new LinkedList<Integer>(cur);
            //     ans.add(temp);
            // }else{
                if(ans.size()==0||!cur.equals(ans.get(ans.size()-1))){
                    List<Integer> temp=new LinkedList<Integer>(cur);
                    ans.add(temp);
                }
            // }
            return;
        }
        if(t>=A[i]){
            cur.add(A[i]);
            // System.out.println(A[i]);
            rec(ans, A, t-A[i], i, cur);
            cur.remove(cur.size()-1);
        }
        rec(ans, A, t, i+1, cur);
        
    }
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> ans
    // }
    public static void main(String[] args) {
        List<List<Integer>> ans=new LinkedList<List<Integer>>();
        int[] A={2,3,5};
        int t=8;
        List<Integer> cur=new LinkedList<Integer>();
        rec(ans, A, t, 0, cur);
        // System.out.println(ans.get(0).size());
        for(int i=0; i<ans.size(); i++){
            for(int j=0; j<ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}
