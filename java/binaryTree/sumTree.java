package binaryTree;

public class sumTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root; 

    void conv(Node node){
        // int l=0, r=0;
        if(node.left==null|| node.right==null||node==null)return;
        int lsum=node.left.data, rsum=node.right.data;
        conv(node.left);
        conv(node.right);
        if(node.left.left==null&&node.left.right==null){
            node.left.data=0;
        }
        if(node.right.left==null&&node.right.right==null){
            node.right.data=0;
        }
        node.data=lsum+rsum+node.left.data+node.right.data;
        

        }
        void printInorder(Node node)  
        { 
            if (node == null) 
                return; 
            printInorder(node.left); 
            System.out.print(node.data + " "); 
            printInorder(node.right); 
        } 

    public static void main(String[] args) {
        sumTree tree=new sumTree();
        tree.root = new Node(10); 
        tree.root.left = new Node(-2); 
        tree.root.right = new Node(6); 
        tree.root.left.left = new Node(8); 
        tree.root.left.right = new Node(-4); 
        tree.root.right.left = new Node(7); 
        tree.root.right.right = new Node(5); 
        tree.conv(tree.root);
        tree.printInorder(tree.root);
    }
}
