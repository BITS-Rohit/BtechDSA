package rohit.OOPS_DSA;

public class SBT {

    public static void main(String[] args) {
        SBT tree = new SBT();

        for (int i = 0; i < 1000; i++) {
            tree.BST(i);
        }
        tree.balanced();
        System.out.println(tree.getheight());
    }

    static class node{
        private final int value;
        private node left;
        private node right;
        private int height;

        node(int data){
            this.value= data;
            this.height=1;
        }
    }
    SBT(){}

    private node root;

    int getheight(){
        return height(root);
    }

    private int height(node nod) {
        if (nod == null){
            return -1;
        }
        return nod.height;
    }

    void BST(int data){
        root= FillBST(data,root);
    }

    private node FillBST(int data, node node) {
        if (node==null){
            return new node(data);
        }
        if (data<node.value) {
            node.left = FillBST(data,node.left);
//            node.left.height=Math.max(height(node.left.left),height(node.left.right))+1;
        }
        if (data>node.value) {
            node.right= FillBST(data,node.right);
//            node.right.height= Math.max(height(node.right.left),height(node.right.right))+1;
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return Balanced(node);
    }

    private node Balanced(node node) {
        int balance = height(node.left)-height(node.right);

        if (balance>1){
            if (height(node.left.left)-height(node.left.right)>0){
                return RS(node);
            }
            if (height(node.left.left)-height(node.left.right)<0){
                node.left = LS(node.left);
                return RS(node);
            }
        }
        if (balance<-1){
            if (height(node.right.left)-height(node.right.right)<0){
                return LS(node);
            }
            if (height(node.right.left)-height(node.right.right)>0){
                node.right=RS(node.right);
                return LS(node);
            }
        }
        return node;
    }

    private node RS(node p) {
        node c = p.left ;
        node t = c.right;

        c.right=p;
        p.left=t;

        c.height=Math.max(height(c.left),height(c.right)+1);
        p.height=Math.max(height(p.left),height(p.right)+1);

        return c;
    }


    private node LS(node p) {
        node c = p.right;
        node t = c.left;

        c.left=p;
        p.right=t;

        c.height=Math.max(height(c.left),height(c.right)+1);
        p.height=Math.max(height(p.left),height(p.right)+1);

        return c;
    }
    public boolean Balanced() {
        return balanced(root);
    }
    public void balanced() {
        balanced(root);
    }
    private boolean balanced(node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
}
