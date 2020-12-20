package binaryTree;

public class constructLevelIn {
    // static int levIndex=0;
    static class Node
    {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    int search(int[] in, int x,int start, int end){
        for(int i = 0; i<in.length; i++){
            if(in[i]==x){
                return i;
            }
        }
        return -1;
    }
    Node recur(int[] in, int[] lev, int start, int end, int levIndex){
        if (start > end) 
        return null; 
        Node cur=new Node(lev[levIndex]);
        if(start==end){
            return cur;
        }
        int x=-1;
        while(levIndex<=end&&x==-1){
            x=search(in, lev[levIndex++], start, end);
        }
        cur.left=recur(in, lev, start, x-1, levIndex);
        cur.right=recur(in, lev, x+1, end, levIndex);
        return cur;
    }
    void printInorder(Node node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.data + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
    public static void main(String[] args) {
        int[] in={4, 8, 10, 12, 14, 20, 22};
        int[] lev={20, 8, 22, 4, 12, 10, 14};
        constructLevelIn cil=new constructLevelIn();
        Node root=cil.recur(in, lev, 0, in.length-1, 0);
        cil.printInorder(root);

    }
}
