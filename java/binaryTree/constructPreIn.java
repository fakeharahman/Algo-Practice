package binaryTree;

import java.util.Arrays;

// import binaryTree.diagonal.Node;

public class constructPreIn {
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
    // static Node root;
    static int preIndex;
    int search(int[] in, int x,int start, int end){
        for(int i = 0; i<in.length; i++){
            if(in[i]==x){
                return i;
            }
        }
        return -1;
    }
    Node cons(int[] in, int[] pre, int start, int end){
       if(start>end){
           return null;
       }
       int x= search(in, pre[preIndex], start, end);
       Node cur= new Node(pre[preIndex++]);
       if(start==end){
           return cur;
        }
       cur.left=cons(in, pre, start, x-1);
       cur.right=cons(in, pre, x+1, end);
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
        int[] in={4,2,5,1,3,6};
        int[] pre={1,2,4,5,3,6};
        constructPreIn cpi=new constructPreIn();
        // root=new Node(pre[0]);
        preIndex=0;
        Node root=cpi.cons(in, pre,0, in.length-1);
        cpi.printInorder(root);
    }
}
