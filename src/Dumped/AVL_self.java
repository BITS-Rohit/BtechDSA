package Dumped;

public class AVL_self {
    private static class Node{
        private Node left;
        private Node right;
        private final int data;
        private int height;
        Node(int data){
            this.data=data;

        }
    }
    AVL_self(){}
    boolean isEmpty(){
        return root==null;
    }
    void start(){
        for (int i = 0; i < 100; i++) {
            this.insert(i);
        }
    }
    Node root;
    void insert(int value){
        root=insert(value,root);
    }
    private Node insert(int value, Node node){
        if (node==null){
            node=new Node(value);
            return node;
        }

        if (value<node.data){
            node.left=insert(value,node.left);
        }
        if (value>node.data){
            node.right=insert(value,node.right);
        }
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left)-height(node.right)>1){
            //left case
            if (height(node.left.left)-height(node.left.right)>0){
                //left-left case
                return rightRotate(node);
            }
            if (height(node.left.left)-height(node.left.right)<0){
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left)-height(node.right)<-1){
            if (height(node.right.left)-height(node.right.right)<0){
                return leftRotate(node);
            }
            if (height(node.right.left)-height(node.right.right)>0){
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right=p;
        p.left=t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.left;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    int height(){
        return height(root);
    }
    private int height(Node node){
        if (node==null){
            return -1;
        }
        return node.height;
    }

    public static void main(String[] args) {
        AVL_self tree = new AVL_self();
        tree.start();
        System.out.println(tree.height());
    }
}
