package binaryTree;

import java.util.Arrays;

public class inPreToPost {
    int search(int[] in, int x, int n){
        for(int i = 0; i<in.length; i++){
            if(in[i]==x){
                return i;
            }
        }
        return -1;
    }
    void rec(int[] pre, int[] in, int n){
        int root=search(in, pre[0], n);
        if(root!=0){
            rec(Arrays.copyOfRange(pre, 1, n), in, root);
        }
        if(root!=n-1){
            rec(Arrays.copyOfRange(pre, root+1, n), Arrays.copyOfRange(in, root+1, n), n-root-1);
        }
        System.out.println(in[root]);

    }
    public static void main(String[] args) {
        int[] in={4,2,5,1,3,6};
        int[] pre={1,2,4,5,3,6};
        inPreToPost con=new inPreToPost();
        con.rec(pre, in, pre.length);
    }
}
