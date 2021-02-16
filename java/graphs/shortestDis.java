import java.util.LinkedList;
import java.util.Queue;

public class shortestDis {
    static int shortestPath(int[][] m, int r, int c){ // 2 start, 1 wall, 0 floor, 3 exit in matrix m
        int sc=0, sr=0; //start row and col
        int[] rv={0,0,1,-1}, cv={1,-1,0,0}; //direction vectors
        boolean[][] visited=new boolean[r+1][c+1];
        Queue<Integer> rq=new LinkedList<Integer>();
        Queue<Integer> cq=new LinkedList<Integer>();
        rq.add(sr);
        cq.add(sc);
        visited[sr][sc]=true;
        int steps =0, nodes_in_next_layer=0, nodes_left_in_layer=1;
        while(!rq.isEmpty()){
            int rr=rq.remove();
            int cc=cq.remove();
            if(m[rr][cc]==3) return steps;    
            for(int i=0; i<4; i++){
                int dr=rr+rv[i];
                int dc=cc+cv[i];
                if(dr<0||dr>r ||dc<0||dc>c) continue;
                if(visited[dr][dc]) continue;
                if(m[dr][dc]==1) continue;
                rq.add(dr);
                cq.add(dc);
                visited[dr][dc]=true;
                nodes_in_next_layer++;
            }
            nodes_left_in_layer--;
            if(nodes_left_in_layer==0){
                nodes_left_in_layer=nodes_in_next_layer;
                nodes_in_next_layer=0;
                steps++;
            }
        }
        return -1;  
    }
    public static void main(String[] args) {
        int[][] m = { // 2 start, 1 wall, 0 floor, 3 exit
         { 2, 0, 0, 1, 0, 0, 0 },
         { 0, 1, 0, 0, 0, 1, 0 },
         { 0, 1, 0, 0, 0, 0, 0 },
         { 0, 0, 1, 1, 0, 0, 0 },
         { 1, 0, 1, 3, 0, 1, 0 }
        };
        System.out.println(shortestPath(m, m.length-1, m[0].length-1));
    }
}