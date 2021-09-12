public class ReverseLinkedListInGroups {
    class Node {
        int data;
        Node next;
     
        public Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    Node next=null;
    Node head=null;
    Node root=null;
    void rev(int k){
        next=head;
        Node prev=null;
        while(next!=null){
            Node t=revUtil(next, k);
            if(prev==null) prev=t;
            else
            prev.next=next;
        }
        
        // if(root==null){
        //     print(head);
        // }else{
        //     print(root);
        // }
    }
    Node revUtil(Node n, int k){
        if(n==null) {
            next=null;
            return null;}
        if(k==1){
            if(root==null){    
                root=n;
            }
            next=n.next;
            // revUtil(next, t, t);
            return n;
        }
        Node t=revUtil(n.next, k-1);
        if(t==null){
            return t;
        }
        t.next=n;
        return n;


    }

    void print(Node n){
        if(n==null)return;
        System.out.println(n.data);
        print(n.next);
    }

    void construct(){
        head=new Node(3);
        head.next=new Node(4);
        head.next.next=new Node(5);
        head.next.next.next=new Node(6);
        head.next.next.next.next=new Node(7);
        head.next.next.next.next.next=new Node(8);
        head.next.next.next.next.next.next=new Node(9);
        head.next.next.next.next.next.next.next=new Node(10);
        head.next.next.next.next.next.next.next.next=new Node(11);
    }
    public static void main(String[] args) {
        ReverseLinkedListInGroups l=new ReverseLinkedListInGroups();
        l.construct();
        l.rev(3);

    }
}
