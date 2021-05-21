package graphs;

public class FloyedWarshellShortestDistance {
    public static class Graph {
        int V;
        Double adj[][];
        int[][] next;
        public Graph(int v) {
            V = v;
            adj = new Double[V][V];
            next=new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    adj[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        public void add(int from, int to, Double cost) {
            adj[from][to] = cost;
            next[from][to]=to;
        }

    }

    public static void shortestPath(Graph g) {
        Double[][] dp = new Double[g.V][g.V];
       
        for (int k = 0; k < g.V; k++) {
            for (int i = 0; i < g.V; i++) {
                for (int j = 0; j < g.V; j++) {
                    if (k == 0)
                        dp[i][j] = g.adj[i][j];
                    else {
                        if(dp[i][k] + dp[k][j]<dp[i][j]){
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                            g.next[i][j]=g.next[i][k];

                        }
                    }
                }
            }
        }
        int j=2;
        // System.out.print(g.next[1][j]);
        while(g.next[1][j]!=j){
            System.out.print(g.next[1][j]);
            j=g.next[1][j];
        }
        System.out.println(dp[1][2]);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.add(1, 2, 3.0);
        g.add(1, 3, 1.0);
        g.add(3, 2, 1.0);
        shortestPath(g);
    }
}
