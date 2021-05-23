package graphs;

import java.util.LinkedList;
import java.util.Stack;

public class TarjansAlgoStronglyConnectedComponents {
    public static class graph {
        int V;
        LinkedList<Integer>[] adj;

        graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }
        public void add(int from, int to){
            adj[from].add(to);
        }
    }

    public static void Scc(graph g) {
        int V = g.V;
        int id = 0;
        boolean[] inStack = new boolean[V];
        boolean[] vis = new boolean[V];
        int[] ids = new int[V];
        int[] lowLink = new int[V];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<V; i++){
            if(!vis[i])
            dfsUtil(g, i, vis, id, ids, lowLink, s, inStack);

        }

    }
    public static int count=0;
    public static int dfsUtil(graph g, int n, boolean[] vis, int id, int[] ids, int[] lowlink, Stack<Integer> s, boolean[] inStack){
        if(vis[n]){
            return n;
        }
        ids[n]=id;
        lowlink[n]=id;
        id++;
        vis[n]=true;
        s.push(n);
        inStack[n]=true;
        for(int i=0; i<g.adj[n].size(); i++){
            int prev=dfsUtil(g, g.adj[n].get(i), vis, id, ids, lowlink, s, inStack);
            if(inStack[prev]){
                lowlink[n]=Math.min(lowlink[prev], lowlink[n]);                
                System.out.println("prev "+ prev+" "+n);
                System.out.println(n+" "+lowlink[n]);
                if(lowlink[n]==ids[n]){
                    count++;
                    System.out.println(n);
                    while(s.peek()!=n){
                        int k=s.pop();
                        ids[k]=n;
                        inStack[k]=false;
                    }
                    int k=s.pop();
                    ids[k]=n;
                    inStack[k]=false;
                }
            }
            
        }
        System.out.println("n="+n);
        return n;
    }

    public static void main(String[] args) {
        graph g= new graph(8);
        // g.add(0, 1);
        // g.add(1, 2);
        // g.add(2, 1);
        g.add(3, 3);
        g.add( 6, 0);
        g.add( 6, 2);
        g.add( 3, 4);
        g.add( 6, 4);
        g.add( 2, 0);
        g.add( 0, 1);
        g.add( 4, 5);
        g.add( 5, 6);
        g.add( 3, 7);
        g.add( 7, 5);
        g.add( 1, 2);
        g.add( 7, 3);
        g.add( 5, 0);
       Scc(g);
       System.out.println("count "+count);
    }
}
