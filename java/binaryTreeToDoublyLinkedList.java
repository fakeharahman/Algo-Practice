public class binaryTreeToDoublyLinkedList {
    class Node {
        int data;
        Node left, right;
     
        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    Node head = null;
    void BToDLL(Node root){
        if(root==null){
            return;
        }
        BToDLL(root.right);
        if(head==null){
            head=root;
        }else{
            head.left=root;
            root.right=head;
            head=root;
        }
        BToDLL(root.left);
        
    }
    void printList(Node head)
    {
        System.out.println("Extracted Double Linked List is : ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }
    void build(){
        root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.right = new Node(4);
        root.left.left = new Node(1);
        root.right.right = new Node(8);
        root.left.left.right = new Node(2);
        root.left.left.left = new Node(0);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(9);
    }
    public static void main(String[] args) {
        binaryTreeToDoublyLinkedList tree=new binaryTreeToDoublyLinkedList();
        tree.build();
        tree.BToDLL(tree.root);
        tree.printList(tree.head);
    }
}
