package graphs;

import java.util.*;

public class DetectNegCyclesBellmanFord {
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
    // int dist[];
    ArrayList<Edge> edges = new ArrayList<Edge>();

    void init(int v) {
        V = v;

        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Edge>();
        }

    }

    void addEdge(int from, int to, int w) {
        Edge k = new Edge(to, from, w);
        // Edge t=new Edge(from, to, w);
        adj[to].add(k);
        // adj[from].add(t);
        edges.add(k);
        // pq.add(t);
    }

    boolean hasNegCycles(int[] dist, int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for (int v = 0; v < V - 1; v++) {
            for (int i = 0; i < edges.size(); i++) {
                Edge k = edges.get(i);
                if (dist[k.from] != Integer.MAX_VALUE && dist[k.to] > dist[k.from] + k.weight) {
                    dist[k.to] = dist[k.from] + k.weight;
                }
            }
        }
        for (int i = 0; i < edges.size(); i++) {
            Edge k = edges.get(i);
            if (dist[k.from] != Integer.MAX_VALUE && dist[k.to] > dist[k.from] + k.weight) {
                // System.out.println("Has neg cycles");
                return true;
            }
        }
        return false;
        // System.out.println("Has no cyles");
    }

    void neg() {
        // boolean visAll=false;
        boolean[] vis = new boolean[V];
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (hasNegCycles(dist, i)) {
                    System.out.println("has neg cycles");
                    return;
                }
                for (int j = 0; j < V; j++) {
                    if (dist[j] != Integer.MAX_VALUE) {
                        vis[j] = true;
                    }
                }
            }

        }
        System.out.println("doesnt have");

    }

    public static void main(String[] args) {
        DetectNegCyclesBellmanFord g = new DetectNegCyclesBellmanFord();
        // all edges should be connected to 0
        g.init(6);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 0, 1);
        // g.addEdge(3, 2, 4);
        // g.addEdge(4, 5, -1);
        // g.addEdge(5, 4, -1);
        g.neg();
    }
}
