package Code;

class TreeHCODE {
    public static void main(String[] args) {
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}
