package graphs;

import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;

public class MaxFlowFordFulkerson {
    public static class Edge{
        Edge residual;
        int to;
        int from;
        int capacity;
        int flow;
        Edge(int from, int to, int cap){
            this.from=from;
            this.to=to;
            capacity=cap;
        }
        public boolean isResidual(){
            return capacity==0;
        }
        void augment(int bottleNeck){
            flow+=bottleNeck;
            residual.flow-=bottleNeck;
        }
        public int flowCap(){
            return capacity-flow;
        }
    }
    public static class graph{
        int n;
        int s;
        int t;  
        List<Edge>[] adj;

        int visToken=0;
        int[] vis;

        int maxFlow;
        boolean soved =false;

        graph(int n, int s, int t){
            this.n=n;
            this.s=s;
            this.t=t;
            adj=new ArrayList[n];
            vis=new int[n];
            for(int i=0; i<n; i++){
                adj[i]=new ArrayList<Edge>();
            }

        }
        public void addEdge(int s, int e, int w){
            Edge e1=new Edge(s, e, w);
            Edge e2=new Edge(e, s, 0);  //residual
            e1.residual=e2;
            e2.residual=e1;
            adj[s].add(e1);
            adj[e].add(e2);
        }
        public void maxFlow() {
            int flow=Integer.MAX_VALUE/2;
            while(flow!=0){
                visToken++;
                flow=dfs(s, Integer.MAX_VALUE/2);
                maxFlow+=flow;
                System.out.println(flow);
            }
        }
        public int dfs(int node, int f){
            if(node==t) return f;
            vis[node]++;
            for(Edge edge: adj[node]){
                if(vis[edge.to]<visToken && edge.flowCap()>0){
                    // System.out.println(edge.from+ " "+ edge.to+" "+ edge.flowCap());
                    int b=dfs(edge.to, Math.min(f, edge.flowCap()));
                    if(b>0){
                        edge.augment(b);
                        return b;
                    }
                }
            }
            return 0;
        }
        

    }
    public static void main(String[] args) {
        
        int n=12;
        int s=n-2;
        int t=n-1;
        graph solver=new graph(n, s, t);
        solver.addEdge(s, 0, 10);
        solver.addEdge(s, 1, 10);
    
        // Sink edges
        solver.addEdge(2, t, 10);
        solver.addEdge(3, t, 10);
    
        // Middle edges
        solver.addEdge(0, 1, 2);
        solver.addEdge(0, 2, 4);
        solver.addEdge(0, 3, 8);
        solver.addEdge(1, 3, 9);
        solver.addEdge(3, 2, 6);
        solver.maxFlow();
        System.out.println(solver.maxFlow);
    }
}
