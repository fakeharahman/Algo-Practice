public class pari {
    int ans=0;
    int rec(int root, int par){
        // if(root==null) return;
        int max=0;
        for(int i=0; i<adj[root].size(); i++){ //loop over all the childen and save the max
            max=Math.max(rec(root.child[i], root.stones));
        }
        max=Math.max(par, max);
        root.stones=max-1-root.stones;
        
        return root.stones
    } 
}

