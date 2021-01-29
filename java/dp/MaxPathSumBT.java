package dp;

public class MaxPathSumBT {
static class Node{
    int val;
    Node left, right;
    Node(int x){
        val=x;
        left=right=null;
    }
}
Node root;

static int sol=Integer.MIN_VALUE;
   static int rec(Node n){
    if(n==null ){
        return 0;
     }
     int ldia=rec(n.left);
     int rdia=rec(n.right);
     int temp=Math.max(n.val, Math.max(ldia, rdia)+n.val);
     int res=Math.max(temp, ldia+rdia+n.val);
     sol=Math.max(sol, res);
     return temp;
        // return Math.max(lheight+rheight+n.data, Math.max(ldia, rdia));

    } 
    static boolean isLeaf(Node n){
        if(n.left==null&&n.right==null){
            return true;
        }
        return false;
    }
    static int height(Node n){
        if(n==null){
            return 0;
        }
        return Math.max(height(n.left), height(n.right))+1;
    }
    static int heightSum(Node n){
        if(n==null){
            return 0;
        }
        return Math.max(heightSum(n.left), heightSum(n.right))+n.val;
    }
    public static void main(String[] args) {
        MaxPathSumBT tree=new MaxPathSumBT();
        tree.root = new Node(-2); 
        tree.root.left = new Node(1); 
        // tree.root.right = new Node(20); 
        // tree.root.left.left = new Node(-8); 
        // tree.root.left.right = new Node(1); 
        // tree.root.left.left.left = new Node(2); 
        // tree.root.left.left.right = new Node(6); 
        // tree.root.right.left = new Node(14); 
        // tree.root.right.right = new Node(7); 
        // tree.root.right.right.right = new Node(0); 
        // tree.root.right.right.right.left = new Node(4); 
        // tree.root.right.right.right.right = new Node(-1); 
        // tree.root.right.right.right.right.left = new Node(10); 
        // tree.root.right.right.right.right.left = new Node(10); 
        int ans=rec(tree.root);
        System.out.println(sol);
        System.out.println(ans);
    }
}
