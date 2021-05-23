package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstralazyShortestPath {
    int V;
    int[][] adj;
    DijkstralazyShortestPath(int v){
        V=v;
        adj=new int[V][V];
    }
    void add(int from, int to, int weight) {
        adj[from][to] = weight;
    }
    public void shortest(int s){
        Comparator<int[]> c=new PriorityComparator();
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(10, c);
        
        int[] dist = new int[V];
        boolean[] vis=new boolean[V];
        for(int i=0 ; i<V; i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[s]=0;
        pq.add(new int[]{s, 0});
        while(!pq.isEmpty()){
            int[] t=pq.poll();
            int node= t[0];
            vis[node]=true;
            if(t[1]>dist[node]){
                continue;
            }
            for(int i=0; i<V; i++){
                // System.out.println(vis[i]);
                if(vis[i]==true) continue;
                // System.out.println(adj[node][i]);
                if(adj[node][i]==0) continue;
                if((adj[node][i]+dist[node])<dist[i]){
                 
                    dist[i]=adj[node][i]+dist[node];
                    pq.add(new int[]{i, adj[node][i]+dist[node]});
                }
            }
        }
        for(int i=0 ; i<V; i++){
           System.out.println(dist[i]+" "+ i);
        }
    }
    public static void main(String[] args) {
        DijkstralazyShortestPath g = new DijkstralazyShortestPath(5);

        g.add(0, 1, 4);
        g.add(0, 2, 1);
        g.add(2, 3, 5);
        g.add(1, 3, 1);
        g.add(3, 4, 3);

        g.shortest(0);
    }
}


public class PriorityComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] x, int[] y) {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x[1] < y[1]) {
            return -1;
        }
        if (x[1] > y[1]) {
            return 1;
        }
        return 0;
    }
}