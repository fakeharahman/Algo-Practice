package graphs;

public class BellmanFordShortestDist {
    public static class Edge {
        double cost;
        int from, to;

        public Edge(int from, int to, double cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }

    public static void bellmanFord(int V, int E, Edge[] edges) {
        double[] dist = new double[V];
        java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[0] = 0;
        boolean relaxedAnEdge = true;
        

        for (int i = 0; (i < V - 1)&& relaxedAnEdge; i++) {
            relaxedAnEdge=false;
            for (int j = 0; j < edges.length; j++) {
                int from = edges[j].from;
                int to = edges[j].to;
                if (dist[to] > dist[from] + edges[j].cost) {
                    dist[to] = dist[from] + edges[j].cost;
                    relaxedAnEdge=true;
                }
            }
        }
        relaxedAnEdge=true;
        for (int i = 0;( i < V - 1)&& relaxedAnEdge; i++) {
            relaxedAnEdge=false;
            for (int j = 0; j < edges.length; j++) {
                int from = edges[j].from;
                int to = edges[j].to;
                System.out.println(dist[to] > dist[from] + edges[j].cost);
                if (dist[to] > dist[from] + edges[j].cost) {
                    dist[to] = Double.NEGATIVE_INFINITY;
                    relaxedAnEdge=true;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " " + i);
        }
    }

    public static void main(String[] args) {
        int E = 10, V = 9, start = 0;

        Edge edges[] = new Edge[E];
        edges[0] = new Edge(0, 1, 1);
        edges[1] = new Edge(1, 2, 1);
        edges[2] = new Edge(2, 4, 1);
        edges[3] = new Edge(4, 3, -3);
        edges[4] = new Edge(3, 2, 1);
        edges[5] = new Edge(1, 5, 4);
        edges[6] = new Edge(1, 6, 4);
        edges[7] = new Edge(5, 6, 5);
        edges[8] = new Edge(6, 7, 4);
        edges[9] = new Edge(5, 7, 3);
        bellmanFord(V, E, edges);
    }
}
