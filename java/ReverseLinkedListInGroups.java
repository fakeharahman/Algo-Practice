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
    // Node next=null;
    Node head=null;
    // Node prev=null;
    Node rev(Node root,int k){
        if(root==null) return null;
        Node prev=null;
        Node cur=root;
        Node next=null;
        int t=k;
        while(t!=0&&cur!=null){
            t--;
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            
            // cur=next;
        }
        // if(next!=null)
        if(next!=null){
            root.next=rev(next, k);
        }
        
        return prev;
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
        // head.next.next.next.next.next.next.next.next=new Node(11);
        print(rev(head, 3));
    }
    public static void main(String[] args) {
        ReverseLinkedListInGroups l=new ReverseLinkedListInGroups();
        l.construct();
        

    }
}
