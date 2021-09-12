public class SortLinkedListFromAbsVal {
    class Node{
        int data;
        Node next=null;
        Node(int x){
            data=x;
        }
    }
    Node root;
    Node head;
    Node sortUtil(Node n){
        if(n==null) return n;
        Node t=sortUtil(n.next);
        n.next=t;
        if(n.data<0){
            n.next=head;
            head=n;
            return t;
        }
        return n;
    }
    void sortUtil2(Node n, Node prev){
        if(n==null) return;
        if(n.data<0&&prev!=null){
            prev.next=n.next;
            n.next=head;
            head=n;
            sortUtil2(prev.next, prev);
            return;
        }
        sortUtil2(n.next, n);
    }
    void print(Node n){
        if(n==null)return;
        System.out.println(n.data);
        print(n.next);
    }
    void init(){
        head=new Node(-1);
        head.next=new Node(-2);
        head.next.next=new Node(-4);
        // head.next.next.next=new Node(3);
        // head.next.next.next.next=new Node(-2);
        // head.next.next.next.next.next=new Node(1);
        // head.next.next.next.next.next.next=new Node(0);
        sortUtil2(head, null);
        print(head);

    }
    public static void main(String[] args) {
        SortLinkedListFromAbsVal t=new SortLinkedListFromAbsVal();
        t.init();
    }
}
