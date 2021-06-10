package graphs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;
// import graphs.MaxFlowFordFulkerson;
public class EdmondKarpAlgoMaxFlow {
    public static class graph{
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
        int n;
        int s;
        int t;  
        List<Edge>[] adj;

        int visToken=0;
        boolean[] vis;

        int maxFlow;
        boolean soved =false;

        graph(int n, int s, int t){
            this.n=n;
            this.s=s;
            this.t=t;
            adj=new ArrayList[n];
            vis=new boolean[n];
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
        void solve(){
            int f=-1;
            visToken=1;
            while(f!=0){
                f=bfs();
                maxFlow+=f;
                vis=new boolean[n];
                // visToken++;
                System.out.println(f);
            }
            System.out.println(maxFlow);
        }
        int bfs(){
            Queue<Integer> qq=new ArrayDeque<Integer>();
            Edge[] prev=new Edge[n];
            qq.add(s);
            vis[s]=true;
            while(!qq.isEmpty()){
                int node=qq.poll();
                if(node==t){
                    break;
                }
               
                for(int i=0; i<adj[node].size(); i++){
                    Edge temp=adj[node].get(i);
                    if(vis[temp.to]) continue;
                    if(temp.flowCap()<=0) continue;
                    vis[temp.to]=true;
                    prev[temp.to]=temp;
                    qq.add(temp.to);
                }
               
            }
            if(prev[t]==null) return 0;
            int i=t;
            int b=Integer.MAX_VALUE;
            while(i!=s){
                b=Math.min(b, prev[i].flowCap());
                i=prev[i].from;
            }
            i=t;
            while(i!=s){
                prev[i].augment(b);
                i=prev[i].from;
            }
            return b;
        }
        

    }
  
   
    public static void main(String[] args) {
        int n = 6;
        int s = n - 1;
        int t = n - 2;
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
    solver.solve();
    }
}
