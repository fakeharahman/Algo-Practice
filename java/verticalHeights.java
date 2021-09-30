public class verticalHeights {
    class Node{
        int data;
        Node left=null,right=null;
        Node(int d){
            data=d;
        }
    }
    void construct(){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.right=new Node(4);
        root.right.left=new Node(5);
        root.left.right.left=new Node(1);
        sum(root, 0, -1);
        System.out.println(sum);
        // System.out.println(maxR+Math.abs(minL)+1);
        // int pos=Math.abs(minL);
    }
    public static void main(String[] args) {
        verticalHeights v=new verticalHeights();
        v.construct();
    }
    int minL=0;
    int maxR=0;
    void rec(Node n, int h){
        if(n==null) return;
        minL=Math.min(h, minL);
        maxR=Math.max(h, maxR);
        rec(n.left, h-1);
        rec(n.right, h+1);
    }
    int sum=0;
    void sum(Node n, int h, int k){
        if(n==null) return;
        if(h==k) sum+=n.data;
        sum(n.left, h-1, k);
        sum(n.right, h+1, k);
    }
}
