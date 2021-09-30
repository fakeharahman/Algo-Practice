package graphs1;

import java.util.*;

public class StronglyConnectedComponents {
    class Edge {
        int to;
        int from;

        Edge(int from, int to) {
            this.to = to;
            this.from = from;
        }
    }

    LinkedList<Edge>[] adj;
    int V;
    int color[];

    void init(int v) {
        V = v;
        vis = new boolean[v];
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Edge>();
        }

    }

    // StronglyConnectedComponents revg = new StronglyConnectedComponents();
    Stack<Integer> st = new Stack<Integer>();
    boolean[] vis;

    void addEdge(int from, int to) {
        Edge t = new Edge(from, to);
        adj[from].add(t);
        // revg.adj[to].add(new Edge(to, from));
    }
    StronglyConnectedComponents rev(){
        StronglyConnectedComponents g= new StronglyConnectedComponents();
        g.init(V);
        for(int i=0; i<V; i++){
            for(int j=0; j<adj[i].size(); j++){
                Edge k= adj[i].get(j);
                g.addEdge(k.to, k.from);
            }
        }
        return g;
    }
    void dfsUtil(int n) {
        if (vis[n] == true)
            return;
        vis[n] = true;

        for (int j = 0; j < adj[n].size(); j++) {
            dfsUtil(adj[n].get(j).to);
        }
        st.push(n);
    }
    void scc(){
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfsUtil(i);
            }
        }
        int count=0;
        StronglyConnectedComponents revg=rev();
        while(!st.empty()){
            int k=st.pop();
            if(revg.vis[k]) continue;
            revg.sccdfs(k);
            System.out.println();
            count++;
        }
        System.out.println(count);
    }
    void sccdfs(int n) {
        if (vis[n] == true)
            return;
        vis[n] = true;
        System.out.print(n+ " ");
        for (int j = 0; j < adj[n].size(); j++) {
            // System.out.println(adj[n].get(j).to+" "+ n);
            sccdfs(adj[n].get(j).to);
        }
    }

    public static void main(String[] args) {
        StronglyConnectedComponents g=new StronglyConnectedComponents();
        g.init(4);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 2);
        g.scc();
    }
}
