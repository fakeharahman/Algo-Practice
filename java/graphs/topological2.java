package graphs;

import java.util.*;
public class topological2 {
    class Edge {
        int to;
        int from, weight;

        Edge(int from, int to, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }
    }
    int[] in;
    LinkedList<Edge>[] adj;
    int V;

    void addEdge(int from, int to, int w) {
        // Edge k = new Edge(to, from, w);
        Edge t = new Edge(from, to, w);
        in[to]++;
        // adj[to].add(k);
        adj[from].add(t);
        // pq.add(t);
    }

    void init(int v) {
        V = v;
        in=new int[V];
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Edge>();
        }

    }
    void topological(){
        int i;
        for(i=0; i<V; i++){
            if(in[i]==0){
                break;
            }
        }
        // for
    }
    public static void main(String[] args) {
        
    }
}
