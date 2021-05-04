

package graphs;

import java.util.LinkedList;

public class LCA {
    static class Node {
        int data;
        LinkedList<Node> vert;

        public Node(int item) {
            data = item;
            vert = new LinkedList<Node>();
        }
    }
    Node root;
    int V;
    LCA(int v){
        V=v;
    }
    LinkedList<Integer> depth=new LinkedList<Integer>();
    LinkedList<Integer> nodes=new LinkedList<Integer>();
    
    public void euclianTraversal(Node center, int dep, int[] last) {
        nodes.add(center.data);
        depth.add(dep);
        System.out.println(center.data);
        for(int i=0; i<center.vert.size(); i++){
            euclianTraversal(center.vert.get(i), dep+1, last);
            System.out.println(center.data);
            nodes.add(center.data);
            depth.add(dep);
        }
        last[center.data]=nodes.size()-1;
    }
    public void lowestCommonAncestor(Node center, int x, int y) {
        int[] last=new int[V];
        euclianTraversal(center, 0, last);
        System.out.println(last[2]);
        System.out.println(nodes.size());
        int f=last[x];
        int l=last[y];
        if(last[x]>last[y]){
            f=last[y];  
            l=last[x];
        }
        int min=Integer.MAX_VALUE;
        int minIndex=0;
        for(int i=f; i<=l; i++){
            if(depth.get(i)<min){
                min=depth.get(i);
                minIndex=i;
            }
        }
        System.out.println("The lowest common aansestor is "+ nodes.get(minIndex));



    }
    public static void main(String[] args) {
        LCA tree=new LCA(7);
        tree.root=new Node(0);
        Node n=new Node(1);
        tree.root.vert.add(n);
        n.vert.add(new Node(3));
        n=new Node(2);
        tree.root.vert.add(n);
        Node m=new Node(4);
        m.vert.add(new Node(6));
        n.vert.add(m);
        n.vert.add(new Node(5));
        // System.out.println(tree.root.vert.get(0).vert.size());
        tree.lowestCommonAncestor(tree.root, 3, 3);
    }
}
