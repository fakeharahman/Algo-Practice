package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class dps {
    private int V;
    private LinkedList<Integer> adj[];
    @SuppressWarnings("unchecked") dps(int v){
        V=v;
        adj=new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }
    void DFSUtil(int v, boolean[] visited){
        if(visited[v]){
            return;
        }
        System.out.println(v);
        visited[v]=true;
        // Iterator <Integer> i = adj[s].listIterator();
        for(int i: adj[v]){
            if(!visited[i])
            DFSUtil(i, visited);
        }
    }
    public static void main(String[] args) {
        dps g=new dps(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        boolean[] visited= new boolean[4];
        // System.out.println(visited[0]);
        g.DFSUtil(2, visited);

    }
}
