package graphs;
import java.util.*;

public class isBipartite {
    class Edge {
        int to;
        int from;

        Edge(int from, int to) {
            this.to = to;
            this.from = from;
        }
    }
    LinkedList<Edge>[] adj;
    int V;
    int color[];
    void init(int v){
        V=v;
        color=new int[v];
        adj=new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<Edge>();
        }

    }
    void addEdge(int from, int to){
        Edge k=new Edge(to, from);
        Edge t=new Edge(from, to);
        adj[to].add(k);
        adj[from].add(t);
        // pq.add(t);
    }
    boolean isBipart(){
        int c=2;
        color[0]=1;
        for(int i=0; i<V; i++){
            for(int j=0; j<adj[i].size(); j++){
                Edge e=adj[i].get(j);
                System.out.println(e.from+" "+e.to+" "+color[0]);
                if(color[e.to]!=0&&color[e.to]!=c){
                    return false;
                }
               
                color[e.to]=c;
            }
            if(c==2) c=1;
            else c=2;
        }
        return true;
    }
    public static void main(String[] args) {
        isBipartite g=new isBipartite();
        g.init(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 0);
        System.out.println(g.isBipart());
        for(int i=0; i<g.color.length; i++){
            System.out.print(g.color[i]+ " ");
        }
    }
}
