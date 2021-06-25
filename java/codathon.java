import java.util.LinkedList;
import java.util.Queue;

public class codathon {
    private int V;
    private LinkedList<Integer> adj[];
    codathon(int v){
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
    public static void main(String[] args) {
        
    }
}
