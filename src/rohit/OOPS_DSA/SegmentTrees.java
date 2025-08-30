package rohit.OOPS_DSA;

public class SegmentTrees {

    public static void main(String[] args) {
        int[] arr = {3,8,6,7,-2,-8,4,9};
        SegmentTrees tree = new SegmentTrees(arr);
        System.out.println(tree.SumQuery(2,6));
        tree.update(1,2);
        System.out.println(tree.SumQuery(2,6));

    }

    private static class Node{
        int data;
        Node left;
        Node right;
        int startInterval;
        int endInterval;
        Node(int startInterval, int endInterval ){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }

    Node root;

    SegmentTrees(int[] arr){
        // Create a tree using this array
        this.root=Make(arr,0,arr.length-1);
    }

    private Node Make(int[] arr, int start, int end) {
        if (start==end){
            Node leaf = new Node(start,end);
            leaf.data= arr[start];
            return leaf;
        }
        Node node = new Node(start,end);
        int mid = (start+end)/2;
        node.left= Make(arr,start,mid);
        node.right= Make(arr,mid+1,end);

        node.data=node.left.data+node.right.data;

        return node;
    }

    int SumQuery(int si, int ei){
        return query(root,si,ei);
    }

    private int query(Node node, int si, int ei) {

        if (node.startInterval>=si && node.endInterval<=ei){
            return node.data;
        } else if (node.startInterval>ei || node.endInterval<si) {
            return 0;
        }else {
            return query(node.left,si,ei) + query(node.right, si , ei );
        }
    }

    void update(int value, int index){
        root.data = update(root,value,index);
    }

    private int update(Node node , int value , int index ){
        if (index>= node.startInterval && index<= node.endInterval ){
            if (index==node.startInterval && index == node.endInterval) {
                return node.data = value;
            }
            else {
                int leftAns = update(node.left, value,index);
                int rightAns = update(node.right,value,index);

                return node.data= leftAns + rightAns;
            }
        }
        return node.data;
    }
}
