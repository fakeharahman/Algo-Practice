package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class isomorphic {
    int root;

    static class Node {
        int data;
        LinkedList<Node> vert;

        public Node(int item) {
            data = item;
            vert = new LinkedList<Node>();
        }
    }

    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    isomorphic(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    int findCenter() {
        int[] degree = new int[V];
        LinkedList<Integer> leaves = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            degree[i] = (adj[i].size());
            if (degree[i] == 1) {
                leaves.add(i);
                degree[i] = 0;
            }
        }
        int count = leaves.size();
        while (count < V) {
            LinkedList<Integer> newLeaves = new LinkedList<Integer>();
            for (int i = 0; i < leaves.size(); i++) {
                int x = leaves.get(i);
                for (int j = 0; j < adj[x].size(); j++) {
                    int d = adj[x].get(j);
                    degree[d]--;
                    if (degree[d] == 1) {
                        newLeaves.add(d);
                    }
                }
                degree[x] = 0;
            }
            count += newLeaves.size();
            leaves = newLeaves;
        }
        return leaves.get(0);

    }

    void DFSUtil(int v, boolean[] visited, Node center) {
        if (visited[v]) {
            return;
        }
        System.out.println(v);
        // System.out.println(v);
        visited[v] = true;
        // Iterator <Integer> i = adj[s].listIterator();
        Node node = new Node(v);
        center.vert.addLast(node);
        for (int i = 0; i < adj[v].size(); i++) {
            if (!visited[adj[v].get(i)])
                DFSUtil(i, visited, center.vert.get(i));
        }
    }

    void TreeUtil(Node center, boolean[] visited) {

        System.out.println(center.data);
        visited[center.data] = true;
        // Node node=new Node(v);
        // center.vert.addLast(node);
        // Iterator <Integer> i = adj[s].listIterator();
        int k = center.vert.size();
        System.out.println(k);
        for (int i = 0; i < k; i++) {
            if (!visited[center.vert.get(i).data])
                TreeUtil(center.vert.get(i), visited);
        }
    }

    Node r = null;

    Node tree(int c, boolean[] vis) {
        if (vis[c]) {
            return null;
        }
        Node center = new Node(c);
        if (r == null) {
            r = center;
        }
        // boolean[] vis=new boolean[V];
        vis[c] = true;
        // DFSUtil(c, vis, center);
        int s = adj[c].size();
        for (int i = 0; i < s; i++) {
            if (vis[adj[c].get(i)]) {

            } else {
                Node n = tree(adj[c].get(i), vis);
                center.vert.add(n);
            }
        }
        // System.out.println("val="+c);
        // System.out.println("size="+ s);
        return center;
        // TreeUtil(center, vis);

    }

    String encoding(Node c) {
        // System.out.println("size="+ c.vert.size());

        int l=0;
        ArrayList<String> labels=new ArrayList<String>();
        String s = "";
        for (int i = 0; i < c.vert.size(); i++) {
            Node k = c.vert.get(i);
            String str = encoding(k);
            // System.out.println(str+ " s="+ s);
            if(str=="") continue;
            labels.add(str);
            if (str.length() > s.length()) {
                s = str + s;
            } else {
                s = s + str;
            }
            // System.out.println(s);
        }
        Collections.sort(labels, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // TODO: Argument validation (nullity, length)
                return s1.length() - s2.length();// comparision
            }
        });
        
        System.out.println(c.data);
        // System.out.println(s);
        return "(" + String.join("", labels) + ")";

    }

    void convert(Node c) {
        if (c == null) {
            return;
        }

    }

    public static void main(String[] args) {
        isomorphic g = new isomorphic(7);
        isomorphic g1 = new isomorphic(7);
        g.addEdge(3, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(4, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 6);
        g.addEdge(6, 5);

        g1.addEdge(3, 2);
        g1.addEdge(2, 3);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(4, 3);
        g1.addEdge(3, 4);
        g1.addEdge(1, 0);
        g1.addEdge(0, 1);
        g1.addEdge(2, 5);
        g1.addEdge(5, 2);
        g1.addEdge(2, 6);
        g1.addEdge(6, 2);
        int c1=g1.findCenter();
        int c = (g.findCenter());
        System.out.println(c1);
        boolean[] vis = new boolean[g.V];
        boolean[] vis1 = new boolean[g1.V];

        g.tree(c, vis);
        g1.tree(c1, vis1);
        String encoding=g.encoding(g.r);
        String encoding1=g1.encoding(g1.r);
        System.out.println(encoding);
        System.out.println(encoding1);
        if(encoding1.equals(encoding)){
            System.out.println("The graphs are isomorphic");
        }else{
            System.out.println("Graphs are not isomorphic");
        }
    }
}
