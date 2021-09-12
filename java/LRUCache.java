import java.util.HashMap;

public class LRUCache {
    class dlNode{
        int val;
        int key;
        dlNode front=null, back=null;
        dlNode(int k, int v){
            val=v;
            key=k;
        }
    }
    dlNode head=null;
    dlNode tail=null;
    int size=2;
    void put(int k, int v){
        if(!h.containsKey(k)){
            if(h.size()==size){
                removeTail();
            }
            dlNode d=new dlNode(k, v);
            if(head==null){
                head=tail=d;
                h.put(k, d);
                return;
            }
            h.size();
            d.front=head;
            head.back=d;
            head=d;
            h.put(k, d);
        }else{
            dlNode d=h.get(k);
            if(d==head) return;
            removeNode(d);
            d.front=head;
            head.back=d;
            head=d;
        }
        System.out.println(head.val+" "+tail.val);
    }
    int get(int k){
        if(!h.containsKey(k)){
            return -1;
        }
        dlNode d=h.get(k);
        if(d==head) return d.val;
        removeNode(d);
        d.front=head;
        head.back=d;
        head=d;
        return d.val;
    }
    void removeNode(dlNode n){
        if(n==tail) {
            removeTail();
            return;
        }
        n.back.front=n.front;
        n.front.back=n.back;

    }
    void removeTail(){
        if(tail==head){
            tail=head=null;
            return;
        }
        tail=tail.back;
        tail.front=null;
        h.remove(tail.key);
    }
    HashMap<Integer, dlNode> h=new HashMap<Integer, dlNode>();
    // void put(int key, int value){

    // }
    public static void main(String[] args) {
        LRUCache l=new LRUCache();
        l.put(1, 1);
        l.put(2, 2);
        System.out.println(l.get(1));
        // l.put(1, 1);
    }
}
