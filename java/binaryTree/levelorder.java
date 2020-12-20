package binaryTree;
// class Node
// {
//     int data;
//     Node left, right;
//     public Node(int item)
//     {
//         data = item;
//         left = right = null;
//     }
// }

public class levelorder {
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
    Node root;
 
    public levelorder()
    {
        root = null;
    }
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            level(root, i);
    }
    int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
    void level(Node root, int level){
        if(root==null){
            return;
        }
        if(level==1)
        System.out.println(root);
        else{
        level(root.left, level - 1);
        level(root.right, level - 1);
    }}
   public static void main(String[] args) {
    levelorder tree = new levelorder();
    tree.root= new Node(1);
    tree.root.left= new Node(2);
    tree.root.right= new Node(3);
    tree.root.left.left= new Node(4);
    tree.root.left.right= new Node(5);
     
    // System.out.println("Level order traversal of 
                            //   binary tree is ");
    tree.printLevelOrder();
   } 
}
