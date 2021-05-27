package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class EulerianPath {
    public static class graph {
        int V;
        LinkedList<Integer>[] adj;

        graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w); // Add w to v's list.
        }

        int[] in;
        int[] out;
        ArrayList<Integer> ans;
        

        public void eulerianPath() {
            in = new int[V];
            out = new int[V];
            ans = new ArrayList<Integer>();
            boolean[] vis=new boolean[V];
            for(int i=0;i<V; i++){
                if(!vis[i]) 
                dfs(i, vis);
            }
            int start=-1, end=-1;
            for(int i=0;i<V; i++){
                int temp=out[i]-in[i];
                if(temp!=0){
                    if(temp>0){
                        if(start!=-1){
                            System.out.println("There is no path");
                            return;
                          
                        }else{
                            start=i;
                        }
                        if(end!=-1){
                            System.out.println("There is no path");
                           return;
                        }else{
                            end=i;
                        }
                    }
                }
                // System.out.println(out[i]);
            }
            if(start==-1) start=0;
            vis=new boolean[V];
            path(start);
          

        }

        public void path(int c) {
            // if(out[c]==0){
            //     System.out.println(c);
            //     return;
            // }       
            while(out[c]!=0){
                int k=adj[c].get(out[c]-1);
                out[c]--;
                path(k);
            }    
                
            
            // System.out.println(c+" "+ out[c]);
           
                System.out.println(c);
           
        }

        

        public void dfs(int c, boolean[] vis) {
            if(vis[c]) return;
            vis[c]=true;
            for(int i=0; i<adj[c].size(); i++){
                int k=adj[c].get(i);
                in[k]++;
                out[c]++;
                dfs(k, vis);
            }

        }

    }

    public static void main(String[] args) {
        graph g=new graph(4);
        g.addEdge(3, 1);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        // g.addEdge(3, 3);
        // g.addEdge(3, 1);
        // g.addEdge(2, 3);

        g.eulerianPath();

    }
}
