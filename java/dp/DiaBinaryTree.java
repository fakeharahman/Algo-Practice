package dp;

public class DiaBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    static int rec(Node n) {
        if (n == null)
            return 0;

        return Math.max(height(n.left) + height(n.right) + 1, Math.max(rec(n.left), rec(n.right)));

    }

    static int res = Integer.MIN_VALUE;

    static int rec2(Node n) {
        if (n == null)
            return 0;
        int temp = Math.max(rec2(n.left), rec2(n.right)) + 1;
        int ans = Math.max(temp, rec2(n.left)+ rec2(n.right) + 1);
        res=Math.max(res, ans);
        return temp;

        // return Math.max(height(n.left) + height(n.right) + 1, Math.max(rec(n.left), rec(n.right)));

    }

    static int height(Node n) {
        if (n == null)
            return 0;
        return Math.max(height(n.left), height(n.right)) + 1;
    }

    public static void main(String[] args) {
        DiaBinaryTree tree = new DiaBinaryTree();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(-4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.left = new Node(1);
        tree.root.right.right.right.left.left = new Node(1);
        tree.root.right.right.right.left.right = new Node(1);
        tree.root.right.right.right.left.right.left = new Node(1);
        System.out.println(rec(tree.root));
        rec2(tree.root);
        System.out.println(res);
        // System.out.println(height(tree.root));
    }
}
