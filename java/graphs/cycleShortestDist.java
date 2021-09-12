package graphs;
import java.util.*;
public class cycleShortestDist {
    int V;
    LinkedList<Edge>[] adj;
    int[] distance;
    void init(int v){
        V=v;
        parent=new int[V];
        Arrays.fill(parent, -1);
        // cycle=new boolean[v];
        adj=new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<Edge>();
        }
        visited=new boolean[v];
    }
    int[] parent;

    public static class Edge{
        int from, to;
        Edge(int from, int to){
            this.to=to;
            this.from=from;
            // this.weight=weight;
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
    Edge cycleEdge;
    boolean hasCycles(){
        for(int i=0; i<V; i++){
            for(int j=0; j<adj[i].size(); j++){
                int x=find(adj[i].get(j).to);
                int y=find(adj[i].get(j).from);
                if(x==y){
                    cycleEdge=adj[i].get(j);
                    cycle.add(adj[i].get(j).from);
                    visited[adj[i].get(j).from]=true;
                    adj[i].remove(j);
                    return true;
                }
                union(x,y);
            }
        }
        return false;
    }
    void removeCycle(){
        for(int i=0; i<adj[cycleEdge.to].size(); i++){
            int k=adj[cycleEdge.to].get(i).to;
            if(k==cycleEdge.from){
                adj[cycleEdge.to].remove(i);
                return;
            }
        }
    }
    // boolean[] cycle;
    ArrayList<Integer> cycle=new ArrayList<Integer>();
    boolean visited[];
    boolean findCycle(int n){
        if(n==cycleEdge.to){
            cycle.add(n);
            return true;
        }
        for(int i=0; i<adj[n].size(); i++){
            int k=adj[n].get(i).to;
            if(visited[k]) continue;
            visited[k]=true;
            if(findCycle(k)){
                cycle.add(k);
                return true;
            }
            visited[k]=false;
            // cycle.remove(cycle.size()-1);
        }
        return false;

    }
    void findDistance(){
        distance=new int[V];
        boolean vis[]=new boolean[V];
        for(int i=0; i<cycle.size(); i++){
            vis[cycle.get(i)]=true;
        }
        for(int i=0; i<cycle.size(); i++){
            int n=cycle.get(i);
            disUtil(n, 0, vis);    
        }
    }
    void disUtil(int n, int d, boolean[] vis){
        distance[n]=d;
        for(int i=0; i<adj[n].size(); i++){
            int k=adj[n].get(i).to;
            if(vis[k]){
                continue;
            }
            vis[k]=true;
            disUtil(k, d+1, vis);
        }
    }
    void addEdge(int from,int to){
        Edge e=new Edge(from, to);
        adj[from].add(e);
        // adj[to].add(new Edge(to, from, weight));
    }
    public static void main(String[] args) {
        cycleShortestDist g=new cycleShortestDist();
        g.init(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(1, 5);
        g.addEdge(2, 4);
        g.hasCycles();
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 0);
        g.addEdge(5, 1);
        g.addEdge(4, 2);



        // System.out.println(g.cycle.size());
        // for(int i=0; i<g.cycle.size(); i++){
        //     System.out.println(g.cycle.get(i));
        // }
            // g.init(gNodes+1);
            // for(int i=0; i<gFrom.size(); i++){
            //     g.addEdge(gFrom.get(i), gTo.get(i));
            // }
            // g.hasCycles();
            // for(int i=0; i<gFrom.size(); i++){
            //     g.addEdge(gTo.get(i), gFrom.get(i));
            // }
            // g.removeCycle();
            // g.findCycle(g.cycleEdge.from);

            // g.findDistance();

            // ArrayList<Integer> ans=new ArrayList<Integer>();
            // for(int i=1; i<g.distance.length; i++){
            //     ans.add(g.distance[i]);
            // }
            // return ans;

        // for(int i=0; i<g.distance.length; i++){
        //     System.out.println(g.distance[i]);
        // }
    }
}
