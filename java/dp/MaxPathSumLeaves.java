package dp;

public class MaxPathSumLeaves {
    static class Node{
        int data;
        Node left, right;
        Node(int x){
            data=x;
            left=right=null;
        }
    }
    Node root;
    static int max=Integer.MIN_VALUE;
    static int rec(Node n){
        if(n==null){
            return 0;
        }
        int lsum=rec(n.left);
        int rsum=rec(n.right);
        // int lheight= heightSum(n.left);
        // int rheight=heightSum(n.right);
        int temp;
        if(isLeaf(n)){
            temp=n.data;
            return temp;
        }
        else if(n.left!=null&&n.right!=null){
            temp=Math.max(lsum, rsum)+n.data;
            max=Math.max(max, lsum+rsum+n.data);
            return temp;
        }else{
            temp=n.left==null?rsum+n.data: lsum+n.data;
            return temp;
        }
        // int res=Math.max(lsum+rsum+n.data, temp);
        
    }
    static boolean isLeaf(Node n){
        if(n.left==null&&n.right==null){
            return true;
        }
        return false;
    }
    static int heightSum(Node n){
        if(n==null){
            return 0;
        }
        return Math.max(heightSum(n.left), heightSum(n.right))+n.data;
    }
    public static void main(String[] args) {
        MaxPathSumLeaves tree=new MaxPathSumLeaves();
        tree.root = new Node(6); 
        tree.root.left = new Node(-9); 
        tree.root.right = new Node(-10); 
        // tree.root.left.left = new Node(-8); 
        // tree.root.left.right = new Node(1); 
        // tree.root.left.left.left = new Node(2); 
        // tree.root.left.left.right = new Node(6); 
        // tree.root.right.left = new Node(3); 
        // tree.root.right.right = new Node(9); 
        // tree.root.right.right.right = new Node(0); 
        // tree.root.right.right.right.left = new Node(4); 
        // tree.root.right.right.right.right = new Node(-1); 
        // tree.root.right.right.right.right.left = new Node(10); 
        rec(tree.root);
        System.out.println(max);
    }
}
