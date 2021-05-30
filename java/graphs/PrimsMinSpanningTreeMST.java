package graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimsMinSpanningTreeMST {
    public static class Graph{
        int V;
        int[][] adj;
        Graph(int v){
            V=v;
            adj=new int[V][V];
           
        }
        //undirected
        public void addEdge(int to, int from, int cost) {
            adj[to][from]=cost;
            adj[from][to]=cost;
        }
        public void mst() {
            PriorityQueue<int[]> pq=new PriorityQueue<int[]>(10,( a, b)-> Integer.compare(a[2], b[2]));
            int s=0;
            boolean[] vis=new boolean[V];
            for(int i=0; i<V; i++){
                int k=adj[s][i];
                if(k==0){
                    continue;
                }
                int[] t={s, i, adj[s][i]};
                pq.add(t);
            }
            vis[s]=true;
            while(!pq.isEmpty()){
                int[] t=pq.poll();
                if(vis[t[1]]) continue;
                for(int i=0; i<V; i++){
                    int k=adj[t[1]][i];
                   
                    if(k==0){
                        continue;
                    }
                    if(vis[i]){
                        continue;
                    }
                    int[] n={t[1], i, adj[t[1]][i]};
                    pq.add(n);
                }
                vis[t[1]]=true;
                System.out.println("["+ t[0]+","+t[1]+","+t[2]+"]");
                

            }
        }
    }
    public static void main(String[] args) {
        Graph g=new Graph(4);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 7);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 1, 6);
        g.addEdge(0, 2, 3);
        g.addEdge(0, 3, 3);
        g.mst();
    }
}
