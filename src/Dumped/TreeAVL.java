package Dumped;

public class TreeAVL {

    public static void main(String[] args) {
        int[] arr = {32, 9, 0, 22, 89, 23};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<arr.length; i++){
            if(max < arr[i])
                max = arr[i];

            if (min > arr[i])
                min = arr[i];
        }

        System.out.print("The smallest Value in the given Array is: "+min);
        System.out.println("The Greatest Value in the given Array is: "+ max);
    }


    static class Node{
        private Node left;
        private Node right;
        private final int value;
        private int Height;
        Node(int data){
            this.value=data;
            this.Height =1;
        }
    }
    TreeAVL(){}
    private Node root;
    void hatch(int data){
        root = hatchTree(data, root);
    }

    private Node hatchTree(int data, Node root) {
        if (root==null){
            root= new Node(data);
            return root;
        }

        if ( data<root.value) root.left = hatchTree(data,root.left);
        if ( data>root.value ) root.right= hatchTree(data,root.right);

        root.Height= Math.max(height(root.left),height(root.right))+1;

        return CheckForRotation(root);
    }

    private Node CheckForRotation(Node root) {
        int check = height(root.left)-height(root.right); // Diff of nodes stored

        if (check > 1){ // if satisfy then it will be
            if (height(root.left.left)-height(root) >0) {
                return RightShift(root);
            }
            if (height(root.left.left)-height(root) <0) {
                root.left=LeftShift(root);
                return RightShift(root);
            }

        }

        if ( check < -1){
            if (height(root.right.left)-height(root.right.right)>0){
                root.right=RightShift(root.right);
                return LeftShift(root);
            }
            if (height(root.right.left)-height(root.right.right)<0){
                return LeftShift(root);
            }

        }

        return root;
    }

    private Node RightShift(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right=p;
        p.left=t;

        c.Height= Math.max(height(c.left),height(c.right))+1;
        p.Height= Math.max(height(p.left),height(p.right))+1;

        return c;
    }

    private Node LeftShift(Node p) {
        Node c = p.right;
        Node t = c.left;

        c.left=p;
        p.right=t;

        c.Height= Math.max(height(c.left),height(c.right))+1;
        p.Height= Math.max(height(p.left),height(p.right))+1;

        return c;
    }

    int height(){
        return height(root);
    }

    private int height(Node root) {
        if (root==null) return 0;
        return root.Height;
    }

    void start(int n){
        for (int i = 0; i < n; i++) {
            hatch(i);
        }
    }
}