package graphs;

import java.util.LinkedList;

public class topologicalSort {

    int V;
    LinkedList<Integer> adj[];

    topologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }

    public LinkedList sort() {
        LinkedList<Integer> ans = new LinkedList<>();
        boolean[] vis= new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dps(i, ans, vis);
            }
        }
        return ans;

    }

    public void dps(int c, LinkedList ans, boolean[] vis) {
        vis[c]=true;
        for (int i = 0; i < adj[c].size(); i++) {
            int k=adj[c].get(i);
            if(!vis[k]){
                dps(k, ans, vis);
            }
        }
        System.out.println(c);
        ans.add(c);
    }

    public static void main(String[] args) {
        topologicalSort g=new topologicalSort(9);
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
        g.sort();
    }
}
