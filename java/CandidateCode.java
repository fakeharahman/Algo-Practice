import java.io.*;
import java.util.*;
public class CandidateCode {
    LinkedList<Integer>[] adj;
    int V;
    void init(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<Integer>();
        }
    }
    void addEdge(int a, int b){
        adj[a].add(b);
        adj[b].add(a);
    }
    int find(HashSet<Integer> ho){
        Integer[] arr= ho.toArray(new Integer[ho.size()]);
        int n=arr[0];
        Queue<Integer> q=new LinkedList<Integer>();
        int hos=ho.size()-1;
        boolean vis[]=new boolean[V];
        HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
        q.add(n);
        vis[n]=true;
        int max=0;
        int maxEle=n;
        int cur=0;
        hm.put(n, 0);
        while(!q.isEmpty()){
            int k=q.remove();
            // System.out.println(k);
            for(int i=0; i<adj[k].size(); i++){
                int t=adj[k].get(i);
                if(!vis[t]){
                    q.add(t);
                    hm.put(t, hm.get(k)+1);
                    vis[t]=true;
                    if(ho.contains(t)){
                        hos--;
                        if(hos==0){
                            max=hm.get(t);
                            maxEle=t;
                            break;
                        }
                    }
                }
            }
            if(max!=0) break;
            cur++;
        }
        ho.remove(n);
        ho.remove(maxEle);
        return max;
    }
    void dis(HashSet<Integer> ho){
        int ans=0;
        while(ho.size()!=0){
            ans+=find(ho);
            // System.out.println(ans);
        }
        System.out.println(ans);
    }
    public static void main(String args[] ) throws Exception {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int h=s.nextInt();
        CandidateCode g= new CandidateCode();
        // int ho[]=new int[h];
        HashSet<Integer> ho=new HashSet<Integer>();
        for(int i=0; i<h; i++){
            ho.add(s.nextInt());
        }
        g.init(n+1);
        for(int i=0; i<n-1; i++){
            g.addEdge(s.nextInt(), s.nextInt());
        }
        g.dis(ho);
    	//Write code here

   }
}