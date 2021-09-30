package graphs1;

public class floydWarshallShortestPathFromAll {
    final static int INF = 99999, V = 4;

    void shortestPath(int[][] g) {
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = g[i][j];
            }
        }
        for (int k = 0; k < V; k++) { // intermidiate
            for (int i = 0; i < V; i++) { // source
                for (int j = 0; j < V; j++) { // dest
                    if(dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
        floydWarshallShortestPathFromAll g = new floydWarshallShortestPathFromAll();
        g.shortestPath(graph);

    }
}
