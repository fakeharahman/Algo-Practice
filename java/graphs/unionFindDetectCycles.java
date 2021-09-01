package graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class unionFindDetectCycles {
    int V;
    LinkedList<Edge>[] adj;
    void init(int v){
        V=v;
        parent=new int[V];
        Arrays.fill(parent, -1);
        adj=new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<Edge>();
        }
    }
    int[] parent;
    public static class Edge{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.to=to;
            this.from=from;
            this.weight=weight;
        }
    }
    void union(int from, int to){
        parent[from]=to;
    }
    int find(int x){
        while(parent[x]!=-1){
            x=parent[x];
        }
        return x;
    }

    boolean hasCycles(){
        for(int i=0; i<V; i++){
            for(int j=0; j<adj[i].size(); j++){
                int x=find(adj[i].get(j).to);
                int y=find(adj[i].get(j).from);
                if(x==y){
                    System.out.println(adj[i].get(j).to+""+adj[i].get(j).from);
                    return true;
                }
                union(x,y);
            }
        }
        return false;
    }
    void addEdge(int from,int to, int weight){
        Edge e=new Edge(from, to, weight);
        adj[from].add(e);
        // adj[to].add(new Edge(to, from, weight));
    }
    public static void main(String[] args) {
    unionFindDetectCycles g=new unionFindDetectCycles();
    g.init(3);
    g.addEdge(0, 1, 5);
    g.addEdge(2, 1, 5);
    g.addEdge(0, 2, 5);
    System.out.println(g.hasCycles());
    for(int i:g.parent){
        System.out.print(i+" ");
    }
    }
}
