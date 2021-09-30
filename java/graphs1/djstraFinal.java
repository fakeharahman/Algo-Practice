package graphs1;
import java.util.*;
public class djstraFinal {
    class Edge {
        int to;
        int from, weight;

        Edge(int from, int to, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }
    }

    LinkedList<Edge>[] adj;
    int V;

    void init(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Edge>();
        }

    }

    void addEdge(int from, int to, int w) {
        Edge k = new Edge(to, from, w);
        Edge t = new Edge(from, to, w);
        adj[to].add(k);
        adj[from].add(t);
        // pq.add(t);
    }
    void shortest(int s){
        int[] dist=new int[V];
        boolean[] vis=new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(100, new PqComp());
        dist[s]=0;
        pq.add(new Edge(s,s,0));
        while(!pq.isEmpty()){
            Edge n=pq.remove();
            int node=n.to;
            if(vis[node]) continue;
            vis[node]=true;
            dist[node]=n.weight;
            for(int i=0; i<adj[node].size(); i++){
                int to=adj[node].get(i).to;
                if(!vis[to]){
                    int k=dist[node]+adj[node].get(i).weight;
                    pq.add(new Edge(s, to, k)); //remember to add the distance from source in pq 
                }
            }
            
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i+" "+dist[i]);
        }
    }

    void start() {
        addEdge(0, 1, 2);
        addEdge(0, 2, 6);
        addEdge(2, 3, 8);
        addEdge(1, 3, 5);
        addEdge(3, 5, 15);
        addEdge(3, 4, 10);
        addEdge(5, 4, 6);
        addEdge(5, 6, 6);
        addEdge(4, 6, 2);

        // addEdge(0, 7, 8);
        // addEdge(1, 2, 8);
        // addEdge(1, 7, 11);
        // addEdge(7, 8, 7);
        // addEdge(7, 6, 1);
        // addEdge(2, 8, 2);
        // addEdge(8, 6, 6);
        // addEdge(2, 3, 7);
        // addEdge(2, 5, 4);
        // addEdge(6, 5, 2);
        // addEdge(3, 5, 14);
        // addEdge(3, 4, 9);
        // addEdge(4, 5, 10);
        shortest(0);
      
    }

    public static void main(String[] args) {
        djstraFinal g=new djstraFinal();
        g.init(7);
        g.start();
    }

    public class PqComp implements Comparator<Edge> {
        public int compare(Edge a, Edge b) {
            if (a.weight > b.weight) {
                return 1;
            }
            if (a.weight == b.weight) {
                return 0;
            }
            return -1;
        }
    }
}
