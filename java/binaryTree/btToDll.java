package binaryTree;

// import org.graalvm.compiler.graph.Node.Successor;

public class btToDll {
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
    Node rot;
    static Node head=null;
    static Node prev= null;
    void convert(Node root){
        if( root == null){
            return;
        }
        convert(root.left);
        System.out.println(root.data);
        if(prev==null){
            head =root;
            prev=root;
        }else{
            prev.right=root;
            root.left=prev;
            prev=root;
        }
        //find inorder successor

        convert(root.right);
    }
    
    // void sucessor(Node root, int x){
    //     sucessor(root.left,x);
    //     if(prev.data==x){
    //         succ = root;
    //         prev=null;
    //         return;
    //     }
    //     sucessor(root.right,x);
    // }
    void printList(Node node)  
    { 
        while (node != null)  
        { 
            System.out.print(node.data + " "); 
            node = node.right; 
        } 
    } 
    void print(Node node){
        if(node==null) return;
        print(node.left);
        System.out.println(node.data);
        print(node.right);
    }
    public static void main(String[] args) {
        btToDll tree= new btToDll();
        tree.rot = new Node(10); 
        tree.rot.left = new Node(12); 
        tree.rot.right = new Node(15); 
        tree.rot.left.left = new Node(25); 
        tree.rot.left.right = new Node(30); 
        tree.rot.right.left = new Node(36); 
        tree.print(tree.rot);
        tree.convert(tree.rot);
        tree.printList(head);
    }
}
