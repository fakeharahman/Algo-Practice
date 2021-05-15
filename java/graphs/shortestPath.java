package graphs;

import java.util.HashMap;
import java.util.Stack;

public class shortestPath {
    public static class graph {
        int V;
        int[][] adj;

        graph(int v) {
            V = v;
            adj = new int[V][V];
        }

        void add(int from, int to, int weight) {
            adj[from][to] = weight;
        }

        public void dist(int start) {
            boolean vis[] = new boolean[V];
            Stack<Integer> s = new Stack<Integer>();
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    DFS(s, vis, i);
                }
            }
            int[] ans = new int[V];
            for (int i = 0; i < V; i++) {
                ans[i] = Integer.MAX_VALUE;
            }
            ans[start] = 0;
            distUtil(ans, start, s);
            for(int i=0; i<V; i++){
               System.out.println(ans[i]+ " "+ i);
            }
        }

        public void distUtil(int[] ans, int start, Stack<Integer> s) {
            while(s.peek()!=start){
                s.pop();

            }

            while(!s.isEmpty()){
                int k=s.pop();
                for(int i=0; i<V; i++){
                    if(adj[k][i]!=0){
                   int t= adj[k][i]+ans[k];
                   if(t<ans[i]){
                       ans[i]=t;
                   }
                }
                }
            }
        }

        public void DFS(Stack<Integer> s, boolean[] vis, int c) {
            if (vis[c])
                return;
            vis[c] = true;
            for (int i = 0; i < V; i++) {
                if (adj[c][i] != 0) {
                    // System.out.println(c+ " "+ i);
                    DFS(s, vis, i);
                }
            }
            s.add(c);
            // System.out.println(c);
        }
    }

    public static void main(String[] args) {
        graph g = new graph(8);
        g.add(1, 2, 3);
        g.add(1, 3, 6);
        g.add(2, 3, 4);
        g.add(2, 4, 4);
        g.add(3, 4, 8);
        g.add(2, 5, 11);
        g.add(4, 5, -4);
        g.add(4, 6, 5);
        g.add(4, 7, 2);
        g.add(3, 7, 11);
        g.add(6, 0, 1);
        g.add(5, 0, 9);
        g.add(7, 0, 2);
        g.dist(3);
    }
}
