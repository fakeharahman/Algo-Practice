package graphs;

import java.util.LinkedList;

public class findJudge {
    int V;
    LinkedList<Integer> vert[];
    findJudge(int v){
        V=v;
        vert=new LinkedList[V];
        for(int i=0; i<V; i++){
            vert[i]=new LinkedList<Integer>();
        }
    }
    void addEdge(int u, int v){
        vert[u].add(v);
    }
    public static void main(String[] args) {
        int N = 3; int[][] trust= {{1,3}};
        findJudge s=new findJudge(N+1);
        int[] out=new int[s.V];
        for(int i=0; i<trust.length; i++){
            s.addEdge(trust[i][0], trust[i][1]);
            out[trust[i][0]]+=1;
        }
        int center=-1;
         for(int i=1; i<out.length; i++){
            if(out[i]==0){
                center=i;
            }
        }
        if(center == -1){
            System.out.println(-1);
        }
        for(int i=1; i<s.V; i++){
            if(i==center) continue;
            boolean exists=false;
            for(int j=0; j<s.vert[i].size(); j++){
                if(s.vert[i].get(j)==center){
                    exists=true;
                }
            }
            System.out.println(i+" "+ exists);
            if(exists==false) System.out.println(-1);
        }
        System.out.println(center);
    }

}
