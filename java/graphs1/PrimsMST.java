package graphs1;
//wrong answer
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

// import graphs.PrimsMST.Edge;

public class PrimsMST {
    int V;
    LinkedList<Edge>[] adj;
    void init(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<Edge>();
        }
    }
    
    public static class Edge{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.to=to;
            this.from=from;
            this.weight=weight;
        }
    }

    class PriorityComparator implements Comparator<Edge>{
        public int compare(Edge a, Edge b){
            if(a.weight<b.weight){
                return -1;
            }
            if(a.weight>b.weight){
                return 1;
            }
            return 0;
        }
    }
    Edge minEdge=null;
    PriorityQueue<Edge> pq= new PriorityQueue<Edge>(100, new PriorityComparator());
    void addEdge(int from,int to, int weight){
        Edge e=new Edge(from, to, weight);
        adj[from].add(e);
        adj[to].add(new Edge(to, from, weight));
        if(minEdge==null||minEdge.weight>weight){
            minEdge=e;

        }
    }

    void minCost(){
        int ans=0;
        int tot=0;
        boolean[] vis=new boolean[V];
        vis[minEdge.to]=true;
        for(int i=0; i<adj[minEdge.to].size(); i++){
            Edge next=adj[minEdge.to].get(i);
            if(!vis[next.to]){
                pq.add(next);
            }
        }
        // vis[minEdge.from]=true;
        // for(int i=0; i<adj[minEdge.from].size(); i++){
        //     Edge next=adj[minEdge.to].get(i);
        //     if(!vis[next.to]){
        //         pq.add(next);
        //     }
        // }
        while(tot!=V-2){ //V-1
            if(pq.isEmpty()){
                System.out.println("Graph cant be formed");
                return;
            }
            while(vis[pq.peek().to]){
                pq.remove();
            }
            Edge newEdge= pq.remove();
            vis[newEdge.to]=true;
            tot++;
            ans+=newEdge.weight;
            System.out.println(newEdge.weight);
            for(int i=0; i<adj[newEdge.to].size(); i++){
                Edge next=adj[newEdge.to].get(i);
                if(!vis[next.to]){
                    pq.add(next);
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        PrimsMST g=new PrimsMST();
        g.init(5);
        g.addEdge(1, 0, 10);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(3, 2, 4);
        // g.addEdge(1, 2, 28);
        // g.addEdge(2, 3, 16);
        // g.addEdge(2, 7, 14);
        // g.addEdge(3, 4, 12);
        // g.addEdge(4, 7, 18);
        // g.addEdge(4, 5, 22);
        // g.addEdge(5, 7, 24);
        // g.addEdge(5, 6, 25);
        // g.addEdge(6, 1, 10);
        // g.addEdge(8, 8, 8);
        g.minCost();
        // g.adj[1].add(new Edge(4, 5, 22));
        // g.adj[1].add(new Edge(4, 5, 22));
    }
}

