package graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class KrushalMST {
    class Edge {
        int to;
        int from, weight;

        Edge(int from, int to, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }
    }
    LinkedList<Edge>[] adj;
    int V;

    void init(int v){
        V=v;
        parent=new int[v];
        Arrays.fill(parent, -1);
        adj=new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<Edge>();
        }

    }

    void addEdge(int from, int to, int w){
        Edge k=new Edge(to, from, w);
        Edge t=new Edge(from, to, w);
        adj[to].add(k);
        adj[from].add(t);
        pq.add(k);
        // pq.add(t);
    }
    int[] parent;
    void union(int from, int to){
        parent[from]=to;
    }
    int find(int x){
        while(parent[x]!=-1){
            x=parent[x];
        }
        return x;
    }
    boolean hasCycles(ArrayList<Edge> e){
        parent=new int[V];
        Arrays.fill(parent, -1);
        for(int i=0; i<e.size(); i++){
            int to=find(e.get(i).to);
            int from=find(e.get(i).from);
            if(from==to){
                return true;
            }
            union(from, to);
        }
        return false;
    }
    void minMST(){
        boolean[] vis=new boolean[V];
        // int tot=0;
        int wt=0;
        ArrayList<Edge> e=new ArrayList<Edge>();
        while(e.size()!=V-2){
            if(pq.isEmpty()){
                System.out.println("graph cant be formed");
                return;
            }
            Edge k=pq.remove();
            System.out.println(k.weight+" "+wt);
            e.add(k);
            if(hasCycles(e)){
                e.remove(e.size()-1);
            }else{
                wt+=k.weight;
            }

        }
        System.out.println(wt);
    }
    PriorityQueue<Edge> pq=new PriorityQueue<Edge>(100, new PriorityComparator());
    class PriorityComparator implements Comparator<Edge>{
        public int compare(Edge x, Edge y){
            if(x.weight>y.weight){
                return 1;
            }
            if(y.weight<y.weight){
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        KrushalMST g=new KrushalMST();
         g.init(5);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 4, 1);
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
        g.minMST();
    }

}
