package binaryTree;



public class diagonal {
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
    void printLevel(Node root){
        for(int i=1; i<=3; i++){
            eachLevel(root, i);
            System.out.println("");
        }
    }

    void eachLevel(Node root, int level){
        if(root==null){
            return;
        }
        if(level==1){
            System.out.print(root.data + " ");
            eachLevel(root.right, level);
        }else{
            eachLevel(root.left, level-1);
            eachLevel(root.right, level);
    }

    }

    public static void main(String[] args) {
        diagonal t=new diagonal();
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.left.right.right.left=new Node(40);
        t.printLevel(root);
        
    }
}
