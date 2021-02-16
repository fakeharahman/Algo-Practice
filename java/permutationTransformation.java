import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class permutationTransformation {
   static class Node 
{ 
    int key; 
    Node left, right; 
  
    public Node(int item) 
    { 
        key = item; 
        left = right = null; 
    } 
} 
     static Node root; 
  
    permutationTransformation() 
    { 
        root = null; 
    } 
    // static int[] ans;

    static Node createTree(int[] a, int i, int j, int[] ans, int h){
        if(i>j){
            return null;
        }
        if(i==j){
            ans[i]=h;
            return new Node(a[i]);
        }
        int x=findMax(a, i, j);
        ans[x]=h;
        Node n=new Node(a[x]);
        n.left=createTree(a, i, x-1, ans, h+1);
        n.right=createTree(a, x+1, j, ans, h+1);
        return n;

    }

    static int findMax(int a[], int i, int j){
        int max=Integer.MIN_VALUE;
        int maxI=-1;
        for(int k=i; k<=j; k++){
            if(a[k]>max){
                max=a[k];
                maxI=k;
            }
        }
        return maxI;
    }

    static void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.key + " "); 
    } 

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t!=0){
            int n=s.nextInt();
            int[] a = new int[n];
            // int ans=0;
            int max=Integer.MIN_VALUE;
            int maxIndex;
            for(int i=0; i<n; i++){
                a[i]=s.nextInt();
                if(a[i]>max){
                    max=a[i];
                    maxIndex=i;
                }
            }
            int[] ans=new int[n];
            root=createTree(a, 0, n-1, ans, 0);
            for(int i=0; i<n; i++){
                System.out.println(ans[i]);
            }
            // Map<Integer, Integer> m=new HashMap<Integer, Integer>();

            // printPostorder(root);
            t--;
        }
        s.close();
    }
}
