package binaryTree;

public class consFromArray {
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

    Node recur(int[] arr, int i){
        if(i>=arr.length) return null;
        Node root=new Node(arr[i]);
        root.left=recur(arr, 2*i+1);
        root.right=recur(arr, 2*i+2);
        return root;
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
        int arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        consFromArray a= new consFromArray();
        Node root=a.recur(arr, 0);
        a.printInorder(root);
    }
}
