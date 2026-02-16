package Dumped;

public class AVL {

    public static class Node {
        private final int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
            this.height++; // Initialize height to 1
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public AVL() {}

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        } else {
            return node; // Duplicate values are not allowed
        }

        // Update the height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Balance the node
        return balance(node);
    }

    private Node balance(Node node) {
        int balance = height(node.left) - height(node.right);

        if (balance > 1) {
            // Left heavy
            if (height(node.left.left) >= height(node.left.right)) {
                // Left-left case
                return rightRotate(node);
            } else {
                // Left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) {
            // Right heavy
            if (height(node.right.right) >= height(node.right.left)) {
                // Right-right case
                return leftRotate(node);
            } else {
                // Right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // Return new root
        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return new root
        return y;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public static void main(String[] args) {
        AVL tree = new AVL();

        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }

        tree.display();
        System.out.println("Height: " + tree.height());
        System.out.println("Balanced: " + tree.balanced());
        System.out.println();
        // Test with larger input
        AVL largeTree = new AVL();
        int[] largeInput = new int[10000];
        for (int i = 0; i < 10000; i++) {
            largeInput[i] = i;
        }
        largeTree.populateSorted(largeInput);
        System.out.println("Height of large tree: " + largeTree.height());
        System.out.println("Balanced: " + largeTree.balanced());
    }
}