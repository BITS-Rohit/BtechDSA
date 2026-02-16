package Code;

import java.util.Scanner;

import static java.lang.System.in;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int height;

    TreeNode(int data) {
        this.val = data;
        left = null;
        right = null;
    }
}

class Trees {
    private final Scanner sc = new Scanner(in);

    void UI() {
        System.out.println("1. Binary Tree (BT)");
        System.out.println("2. Binary Search Tree (BST)");
        System.out.println("3. Self-Balancing Tree (AVL)");
        // System.out.println("4. Red-Black Tree");
    }

    public static void main(String[] args) {
        Trees trees = new Trees();
        trees.UI();
        if (trees.sc.nextInt() == 1) {
            BT binaryTree = new BT();
            binaryTree.MakeBT();
        }
    }
}

class BT {
    private final Scanner sc = new Scanner(in);
    private TreeNode root;

    private void initializeRoot() {
        System.out.print("Enter prime root: ");
        int rootData = sc.nextInt();
        root = new TreeNode(rootData);
    }

    public int getroot() {
        return root == null ? null : root.val;
    }

    public void MakeBT() {
        initializeRoot();
        create(root);
    }

    private void create(TreeNode root) {
        System.out.println("Add left of " + root.val + " (enter 'yes' or 'no'): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            System.out.println("Enter left data of " + root.val + ": ");
            root.left = new TreeNode(sc.nextInt());
            create(root.left);
        }

        System.out.println("Add right of " + root.val + " (enter 'yes' or 'no'): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            System.out.println("Enter right data of " + root.val + ": ");
            root.right = new TreeNode(sc.nextInt());
            create(root.right);
        }
    }
}

class BST {
    private final Scanner sc = new Scanner(in);
    private TreeNode root;

    private void initializeRoot() {
        System.out.print("Enter prime root: ");
        int rootData = sc.nextInt();
        root = new TreeNode(rootData);
    }

    public Integer getRoot() {
        return root == null ? null : root.val;
    }

    public void makeBST() {
        initializeRoot();
        System.out.println("Enter numbers to add to BST, or type 'done' to finish:");
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            addNode(root, num);
        }
    }

    private void addNode(TreeNode current, int data) {
        if (data < current.val) {
            if (current.left == null) {
                current.left = new TreeNode(data);
            } else {
                addNode(current.left, data);
            }
        } else if (data > current.val) {
            if (current.right == null) {
                current.right = new TreeNode(data);
            } else {
                addNode(current.right, data);
            }
        } else {
            System.out.println(data + " is already present in the BST, duplicates are not allowed.");
        }
    }

    int getheight() {
        return giveheight(root);
    }

    private int giveheight(TreeNode root) {
        if (root == null) return 0;
        int left = giveheight(root.left);
        int right = giveheight(root.right);
        return Math.max(left, right) + 1;
    }

    boolean isBalanced(TreeNode node) {
        return checkHeight(node) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class AVL {
    private final Scanner sc = new Scanner(in);
    private TreeNode root;

    private void initializeRoot() {
        System.out.print("Enter prime root: ");
        int rootData = sc.nextInt();
        root = new TreeNode(rootData);
    }

    public Integer getRoot() {
        return root == null ? null : root.val;
    }

    public void makeAVL() {
        initializeRoot();
        System.out.println("Enter numbers to add to the AVL tree, or type 'done' to finish:");

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            root = addNode(root, num);
        }
    }


    private TreeNode addNode(TreeNode current, int data) {
        if (current == null) return new TreeNode(data);
        if (data < current.val) current.left = addNode(current.left, data);
        else if (data > current.val)current.right = addNode(current.right, data);
        else {
        System.out.println(data + " is already present in the BST, duplicates are not allowed.");
        return current;
        }

        current.height = Math.max(giveheight(current.left), giveheight(current.right)) + 1;
        int balance = giveheight(current.left) - giveheight(current.right);

        if (balance > 1) {
            if (giveheight(current.left.left) >= giveheight(current.left.right))
                return rightShift(current); // Left-Left case
            else {
                current.left = leftShift(current.left);
                return rightShift(current); // Left-Right case
            }
        }
        if (balance < -1) {
            if (giveheight(current.right.right) >= giveheight(current.right.left))
                return leftShift(current); // Right-Right case
            else {
                current.right = rightShift(current.right);
                return leftShift(current); // Right-Left case
            }
        }
        return current;
    }

    int getheight() {
        return giveheight(root);
    }

    private int giveheight(TreeNode root) {
        if (root == null) return 0;
        int left = giveheight(root.left);
        int right = giveheight(root.right);
        return Math.max(left, right) + 1;
    }

    boolean isBalanced(TreeNode node) {
        return checkHeight(node) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private TreeNode leftShift(TreeNode parent) {
        TreeNode child = parent.left;
        TreeNode temp = child.right;

        child.right = parent;
        parent.left = temp;

        child.height = Math.max(giveheight(child.left), giveheight(child.right)) + 1;
        parent.height = Math.max(giveheight(parent.left), giveheight(parent.right)) + 1;

        return child;
    }

    private TreeNode rightShift(TreeNode child) {
        TreeNode parent = child.right;
        TreeNode temp = parent.left;

        parent.left = child;
        child.right = temp;

        child.height = Math.max(giveheight(child.left), giveheight(child.right)) + 1;
        parent.height = Math.max(giveheight(parent.left), giveheight(parent.right)) + 1;

        return parent;
    }
}
