package graphs;

import java.util.LinkedList;
import java.util.List;

public class allPossiblePath {
    public static class graph {
        int V;
        int[][] adj;

        graph(int v) {
            V = v;
            adj = new int[V][V];
        }

        void add(int from, int to) {
            adj[from][to] = 1;
        }

       

    }

    public static  List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> vals = new LinkedList<Integer>();
        DFS(0, graph, vals, ans);
        System.out.println(ans);
        return ans;

    }

    public static  void DFS(int c, int[][] graph,  List<Integer> vals, List<List<Integer>> ans) {
        if (c == graph.length - 1) {
            vals.add(c);
            List<Integer> valsCopy = new LinkedList<Integer>(vals);
           ans.add(valsCopy);
            System.out.println(ans);
            System.out.println(vals);
            vals.remove(vals.size() - 1);
            return;
        }
        

        vals.add(c);
        for (int i = 0; i < graph[c].length; i++) {
          
                DFS(graph[c][i], graph, vals, ans);
            
        }
        vals.remove(vals.size() - 1);
        // System.out.println(c);
    }
    public static void main(String[] args) {
        // graph g = new graph(5);
        // g.add(0, 1);
        // g.add(0, 3);
        // g.add(0, 4);
        // g.add(3, 4);
        // g.add(1, 4);
        // g.add(1, 3);
        // g.add(1, 2);
        // g.add(2, 3);
        // g.allPathsSourceTarget();
        allPossiblePath g= new allPossiblePath();
        int[][] graph={{4,3,1},{3,2,4},{3},{4},{}};
        allPathsSourceTarget(graph);
    }
}
