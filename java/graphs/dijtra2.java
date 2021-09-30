package graphs;

import java.util.*;

public class dijtra2 {
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

    void addEdge(int from, int to, int w) {
        Edge k = new Edge(to, from, w);
        Edge t = new Edge(from, to, w);
        adj[to].add(k);
        adj[from].add(t);
        // pq.add(t);
    }

    void init(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Edge>();
        }

    }

    PriorityQueue<Edge> pq = new PriorityQueue<Edge>(100, new PqComp());
    int[] ans;
    boolean[] vis;

    void shortest(int s) {
        ans = new int[V];
        vis = new boolean[V];
        vis[s] = true;
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[s] = 0;
        for (int i = 0; i < adj[s].size(); i++) {
            pq.add(adj[s].get(i));
        }
        shortest();

    }

    void shortest() {
        Edge e = pq.poll();
        if (e == null)
            return;
        if (ans[e.to] > ans[e.from] + e.weight) {
            ans[e.to] = ans[e.from] + e.weight;
            for (int i = 0; i < adj[e.to].size(); i++) {
                Edge t = adj[e.to].get(i);
                    pq.add(t);
            }
        }

        shortest();
    }

    void start() {
        addEdge(0, 1, 4);
        addEdge(0, 7, 8);
        addEdge(1, 2, 8);
        addEdge(1, 7, 11);
        addEdge(7, 8, 7);
        addEdge(7, 6, 1);
        addEdge(2, 8, 2);
        addEdge(8, 6, 6);
        addEdge(2, 3, 7);
        addEdge(2, 5, 4);
        addEdge(6, 5, 2);
        addEdge(3, 5, 14);
        addEdge(3, 4, 9);
        addEdge(4, 5, 10);
        shortest(0);
        for (int i = 0; i < V; i++) {
            System.out.println(i+" "+ans[i]);
        }
    }

    public static void main(String[] args) {
        dijtra2 g = new dijtra2();
        g.init(9);
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
