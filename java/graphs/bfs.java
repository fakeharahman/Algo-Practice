package graphs;

// import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    private int V;
    private LinkedList<Integer> adj[];
    bfs(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0; i<V; i++){
            adj[i]=new LinkedList<Integer>();
        }
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }
     int[] sol(int v){
        Queue<Integer> q=new LinkedList<Integer>();
        int[] prev=new int[V];
        q.add(v);
        boolean[] visited=new boolean[V];
        visited[v]=true;
        while(q.size()!=0){
            int x=q.remove();
            for(int i: adj[x]){
                if(visited[i]==true) continue;
                
                
                // System.out.println(i);
                q.add(i);
                visited[i]=true;
                prev[i]=x;
            }
        }
        return prev;
    }
    int[] shortestDis(int[] prev, int a, int b){
        int[] path=new int[V];
        int i=0;
        while(b!=a&&b!=0){
            path[i++]=b;
            b=prev[b];
        }
        path[i]=b;
        // System.out.println(b);
        int[] t={};
        if(b==0){
            return t;
        }
        return path;
        // System.out.println(a);
    }
    public static void main(String[] args) {
        bfs g=new bfs(6);
        g.addEdge(4, 1);
        g.addEdge(4, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(5, 5);
        int a=3;
        int b=1;
        int[] prev=g.sol(a);
        int[] ans=g.shortestDis(prev, a,b);
        for(int i=ans.length-1; i>=0; i--){
            if(ans[i]!=0)
            System.out.println(ans[i]);
        }

    }
}
