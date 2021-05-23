package graphs;

// import java.util.LinkedList;

public class findJudge2 {
    int V;
    boolean[][] vert;
    findJudge2(int v){
        V=v;
        vert=new boolean[V][V];
        
    }
   
    public static void main(String[] args) {
        int N = 2; int[][] trust= {{1,2}};
        findJudge2 s=new findJudge2(N+1);
        int[] out=new int[s.V];
        for(int i=0; i<trust.length; i++){
            // s.addEdge(trust[i][0], trust[i][1]);
            s.vert[trust[i][0]][trust[i][1]]=true;
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
        for(int i=1; i<s.vert.length; i++){
            if(i==center) continue;
            if(!s.vert[i][center]){
                System.out.println(i+" "+s.vert[i][center]);
            }
        }
        // for(int i=1; i<s.V; i++){
        //     if(i==center) continue;
        //     boolean exists=false;
        //     for(int j=0; j<s.vert[i].size(); j++){
        //         if(s.vert[i].get(j)==center){
        //             exists=true;
        //         }
        //     }
        //     System.out.println(i+" "+ exists);
        //     if(exists==false) System.out.println(-1);
        // }
        System.out.println(center);
    }

}

