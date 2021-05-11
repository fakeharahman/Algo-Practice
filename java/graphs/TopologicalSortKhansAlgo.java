package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortKhansAlgo {
    int V;
    LinkedList<Integer> adj[];

    TopologicalSortKhansAlgo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    public void sort(int c) {
        int[] d = new int[V];
        boolean[] vis = new boolean[V];
        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                dfs(i, vis, d);

            }
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0; i<d.length; i++){
            // System.out.println(d[i]);
            if(d[i]==0){
                q.add(i);
            }
        }
        topological(q, d);

    }
    public void topological(Queue<Integer> q, int[] d) {
        LinkedList<Integer> ans=new LinkedList<Integer>();
        while(!q.isEmpty()){
            int k=q.remove();
            System.out.println(k);
            ans.add(k);
            for(int i=0; i<adj[k].size(); i++){
                int v=adj[k].get(i);
                d[v]-=1;
                if(d[v]==0){
                    q.add(v);
                }
                
            }
        }
      
            for(int i=0; i<V; i++){
                if(d[i]!=0){
                    System.out.println("These is a cycle in this graph!");
                    break;
                }
            }
          
       


    }

    public void dfs(int c, boolean[] vis, int[] d) {
        if(vis[c]) return;
        vis[c]=true;
        for (int i = 0; i < adj[c].size(); i++) {
            int k=adj[c].get(i);
            d[k]+=1;
            dfs(k, vis, d);
        }
    }

    public static void main(String[] args) {
        TopologicalSortKhansAlgo g = new TopologicalSortKhansAlgo(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(5, 8);
        g.addEdge(6, 8);
        g.addEdge(8, 3);
        g.sort(3);
    }
}
