package graphs;
import java.awt.geom.Point2D;
import java.util.ArrayList;
public class miceAndOwls {
    public static class Mouse{
        Point2D point;
        Mouse(int x, int y){
            point =new Point2D.Double(x, y);
        }
    }
    public static class Hole{
        Point2D point;
        int cap;
        Hole(int x, int y, int capacity){
            point =new Point2D.Double(x, y);
            cap=capacity;
        }
    }

    public static class Edge {
        Edge residual;
        int flow;
        int capacity;
        int to, from;
        Edge(int to, int from, int capacity){
            this.to=to;
            this.from=from;
            this.capacity=capacity;
        }
        public int remainingCap() {
            return capacity-flow;
        }
        void augment(int b){
            flow+=b;
            residual.flow-=b;
        }
    }
    public static class graph{
        ArrayList<Edge>[] adj;
        int V;
        int maxFlow;
        int s;
        int t;
        int visToken=0;
        boolean[] vis;
        graph(int v, int s, int t){
            V=v;
            this.s=s;
            this.t=t;
            adj=new ArrayList[V];
            for(int i=0; i<v; i++){
                adj[i]=new ArrayList<Edge>();
            }
           
        }
        void addEdge(int from, int to, int cap){
            Edge e1=new Edge(to, from, cap);
            Edge e2=new Edge(from, to, 0);
            e1.residual=e2;
            e2.residual=e1;
            adj[from].add(e1);
            adj[to].add(e2);
        }
        void max(){
            int b=Integer.MAX_VALUE/2;
            // System.out.println(s+" "+t);
            while(b!=0){
                vis=new boolean[V];
                b=dfs(s, Integer.MAX_VALUE);
                maxFlow+=b;
                System.out.println(b);
            }
        }
        int dfs(int node, int f){
            if(node==t) return f;
            vis[node]=true;
            
            for(int i=0; i<adj[node].size(); i++){
                Edge e= adj[node].get(i);
                if(!vis[e.to]&&e.remainingCap()>0){
                    int d= dfs(e.to, Math.min(e.remainingCap(), f));
                   if(d>0){
                       e.augment(d);
                       return d;
                   }
                }
            }
            return 0;
        }
    }

    public static void solve(Mouse[] mice, Hole[] holes, int radius) {
        int M=mice.length;
        int H=holes.length;
        int n=M+H+2;
        int s=n-1;
        int t=n-2;
        graph g=new graph(M+H+2, s, t);
        for(int i=0; i<mice.length; i++){
            Mouse m=mice[i];
            g.addEdge(s, i, 1);
            for(int j=0; j<holes.length; j++){
                Hole h=holes[j];
                if(m.point.distance(h.point)<=radius){
                    g.addEdge(i, M+j, 1);
                }
            }
        }
        for(int j=0; j<holes.length; j++){
            Hole h=holes[j];
            g.addEdge(M+j, t, h.cap);
        }
        g.max();
        System.out.println(g.maxFlow);

    }
    
  
    
    public static void main(String[] args) {
        Mouse[] mice = {
            new Mouse(1, 0),
            new Mouse(0, 1),
            new Mouse(8, 1),
            new Mouse(12, 0),
            new Mouse(12, 4),
            new Mouse(15, 5)
          };
          Hole[] holes = {new Hole(1, 1, 1), new Hole(10, 2, 2), new Hole(14, 5, 1)};
          solve(mice, holes, 3);
    }
}
