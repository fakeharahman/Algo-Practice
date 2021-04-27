package graphs;

// import java.util.Iterator;
import java.util.LinkedList;

public class center {
    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    center(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    void treeCenters() {
        for(int i=0; i<V; i++){
            for(int j=0; j<adj[i].size(); j++){
                System.out.println(i + " "+ adj[i].get(j));
            }
        }
        int[] degree = new int[V];
        int[] leaves = new int[V];
        int k = 0;
        for (int i = 0; i < V; i++) {
            degree[i] = adj[i].size();
            if (degree[i] == 1 || degree[i] == 0) {
                leaves[k] = i;
                System.out.println(leaves[k]);
                k=k+1;
                degree[i] = 0;
            }
        }
        int count = k+1;
        while (count < V) {
            System.out.println("count="+ count);
            int nl = 0;
            int[] newLeaves = new int[V];
            for (int i = 0; i <= k; i++) {
                System.out.println(" "+leaves[i]);
                // System.out.println(" "+adj[2].size());
                for (int j = 0; j < adj[leaves[i]].size(); j++) {
                    // System.out.println("j=" + j + " " + i + " ");
                    // System.out.println(adj[leaves[i]].get(j)); //issue
                    // System.out.println("d="+ degree[1]);
                    // System.out.println("degree="+ degree[adj[leaves[i]].get(j)]);
                    // if (degree[adj[leaves[i]].get(j)] == 1) {
                    //     newLeaves[nl] = adj[leaves[i]].get(j);
                    //     System.out.println("leaves="+newLeaves[nl]);
                    //     nl=nl+1;
                    // } else {
                        
                        --degree[adj[leaves[i]].get(j)];
                        if (degree[adj[leaves[i]].get(j)] == 1) {
                            newLeaves[nl] = adj[leaves[i]].get(j);
                            System.out.println("leaves="+newLeaves[nl]);
                            nl=nl+1;
                        }
                    // }
                    System.out.println("degree="+ degree[adj[leaves[i]].get(j)]);
                }
                degree[leaves[i]] = 0;
            }
            System.out.println("nl="+nl);
            if (nl == 0) {
                break;
            }
            for (int i = 0; i < V; i++) {

                leaves[i] = newLeaves[i];
            }
            k = nl;
            count += nl+1;
            // System.out.println(count);
        }
        for (int i = 0; i < V; i++) {
            System.out.println(leaves[i]);
        }
        System.out.println(k);
    }

    public static void main(String[] args) {
        center g = new center(6);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 1);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 5);
        g.addEdge(5, 4);
        
        g.treeCenters();
        // g.addEdge(2, 3);
        // g.addEdge(3, 3);
        // boolean[] visited= new boolean[4];
        // System.out.println(visited[0]);
        // g.DFSUtil(2, visited);
    }
}
