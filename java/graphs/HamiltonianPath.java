package graphs;

import java.util.HashSet;
//all possible paths
import java.util.LinkedList;

public class HamiltonianPath {
    int[][] adj;
    int V;
    boolean vis[];
    int[] ans;


    void init(int v) {
        V = v;
        adj = new int[v][v];
        vis=new boolean[v];
        ans=new int[v];
    }

    void addEdge(int a, int b) {
        adj[a][b] = 1;
        adj[b][a] = 1;
    }

    void path() {
        ans[0]=0;
        vis[0]=true;
        pathUtil(0, 1);
    }

    void pathUtil(int last, int j) {
        if (j == V) {
            System.out.println(last);
            if (adj[last][0] == 1) {
                for (int k : ans) {
                    System.out.print(k);
                }
                System.out.println();
            }
            return;
        }
        for (int i = 1; i < V; i++) {
            if (adj[i][last] == 1 && !vis[i]) {
                ans[j]=i;
                vis[i]=true;
                pathUtil(i, j+1);
                vis[i]=false;
                // hs.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        HamiltonianPath g = new HamiltonianPath();
        g.init(5);
        // g.addEdge(0, 1);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(3, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        
        g.path();
    }
}
