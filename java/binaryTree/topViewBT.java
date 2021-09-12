package binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class topViewBT {
    class Node{
        int val, height;
        Node left=null, right=null;
        Node(int v){
            val=v;
        }
    }
    HashMap<Integer, Node> m=new HashMap<Integer, Node>();

    void dfs(Node n, int h, int pl){
        if(n==null) return;
        
        n.height=h;
        if(!m.containsKey(pl)){
            m.put(pl, n);
        }else{
            int prevH=m.get(pl).height;
            if(prevH>h){
                m.replace(pl, n);
            }
        }
        dfs(n.left, h+1, pl-1);
        dfs(n.right, h+1, pl+1);
    }
    void print(){
        
        List<Integer> sortedKeys = new ArrayList<Integer>(m.size());
        sortedKeys.addAll(m.keySet());
        Collections.sort(sortedKeys);
        System.out.println(sortedKeys.size());
        for(int i: sortedKeys){
            System.out.println(m.get(i).val);
        }
    }
    void topView(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        dfs(root, 0, 0);
        print();
    }
    public static void main(String[] args) {
        topViewBT t=new topViewBT();
        t.topView();
    }
}
