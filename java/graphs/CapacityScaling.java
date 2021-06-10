package graphs;
import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;
class CapacityScaling {

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
            int maxEdge=Integer.MIN_VALUE;
            public void addEdge(int s, int e, int w){
                Edge e1=new Edge(s, e, w);
                Edge e2=new Edge(e, s, 0);  //residual
                e1.residual=e2;
                e2.residual=e1;
                adj[s].add(e1);
                adj[e].add(e2);
                if(w>maxEdge){
                    maxEdge=w;
                }
            }
            void solve(){
              int k=1;
              while(k<maxEdge){
                k<<=1;
              }
              k>>=1;
              maxFlow=0;
            //   for(int b=0; k>0; k/=2){
            //       do{
            //           vis=new boolean[n];
            //           b=capScaling(s, Integer.MAX_VALUE, k);
            //           maxFlow+=b;
            //       }while(b!=0);
            //   }
              while(k>0){
                  int b=0;
                  do{
                      vis=new boolean[n];
                      b=capScaling(s, Integer.MAX_VALUE, k);
                      maxFlow+=b;
                      System.out.println("k="+k);
                    }while(b!=0);
                    k/=2;
              }
              System.out.println(maxFlow);

            }
            int capScaling(int node, int b, int k){
                if(node==t){
                    return b;
                }
                vis[node]=true;
                for(Edge e : adj[node]){
                    // if(e.flowCap()<k) continue;
                    // if(vis[e.to]) continue;
                    if(e.flowCap()>=k&& !vis[e.to]){

                        System.out.print(e.to+" ");
                        int btlneck=capScaling(e.to, Math.min(b, e.flowCap()), k);
                        if(btlneck>0){
                            e.augment(btlneck);
                            return btlneck;
                        }
                    }
                }
                return 0;
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
