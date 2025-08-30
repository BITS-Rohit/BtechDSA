package Code;

import java.util.*;

class CBTInserter {
    TreeNode root;
    Queue<TreeNode> q;

    public CBTInserter(TreeNode root) {
        if (root == null) root = null;
        this.root = root;
        q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode top = q.peek();
            if (top.left != null) q.offer(top.left);
            if (top.right != null) q.offer(top.right);
            q.poll();
            if (q.peek().left == null && q.peek().right == null) break;
        }
    }

    public int insert(int val) {
        TreeNode parent = q.peek();
        TreeNode node = new TreeNode(val);
        if (parent.left == null) parent.left = node;
        if (parent.right == null) parent.right = node;
        q.poll();
        q.offer(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

class codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder encoded = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) encoded.append("null,");
            else {
                encoded.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        encoded.setLength(encoded.length() - 1);
        return encoded.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] lists = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(lists[0]));
        queue.offer(root);

        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!lists[idx].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(lists[idx]));
                queue.offer(node.left);
            }
            idx++;
            if (!lists[idx].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(lists[idx]));
                queue.offer(node.right);
            }
            idx++;
        }
        return root;
    }
}

class BFS {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Node head;

    void orderPrint(Node head) {
        if (head == null) return;

        Queue<Node> order = new LinkedList<>();
        order.add(head);

        while (!order.isEmpty()) {
            Node current = order.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                order.add(current.left);
            }

            if (current.right != null) {
                order.add(current.right);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> order = new LinkedList<>();

        order.offer(root);
        while (!order.isEmpty()) {
            int levelsize = order.size();
            List<Integer> current = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                TreeNode curNode = order.poll();
                current.add(curNode.val);
                if (curNode.left != null) order.offer(curNode.left);
                if (curNode.right != null) order.offer(curNode.right);
            }
            result.add(current);
        }
        return result;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            double sum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            result.add(sum / level);
        }
        return result;
    }

    int successor(TreeNode root, int key) {
        if (root == null) return Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
                if (curNode.val == key) break;
            }
        }
        return queue.peek().val;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean checker = true;

        while (!queue.isEmpty()) {
            int level = queue.size();
            int idx = level - 1;
            List<Integer> current = new ArrayList<>(level);
            for (int i = 0; i < level; i++) {
                TreeNode curNode = queue.poll();
                if (checker) current.add(curNode.val);
                else current.add(idx--, curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            result.add(current);
            checker = !checker;
        }
        return result;
    }

    public Node connect(Node root) {
        if (root == null) return new Node();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            int counter = (int) Math.pow(2, idx++);
            for (int i = 0; i < level; i++) {
                Node curNode = queue.poll();
                if (counter == i + 1) curNode.next = null;
                else curNode.next = queue.peek();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
        }
        return root;
    }

    Node connectnew(Node root) {
        if (root == null) return null;
        Node leftmost = root;
        while (leftmost.left != null) {
            Node current = leftmost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
                if (i == level - 1) result.add(curNode.val);
            }
        }
        return result;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> order = new LinkedList<>();
        order.offer(root);
        boolean fx = false, fy = false;
        while (!order.isEmpty()) {
            int levelsize = order.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode node = order.poll();
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)) {
                        return false; // They are siblings, not cousins
                    }
                }
                if (node.val == x) fx = true;
                if (node.val == y) fy = true;
                if (node.left != null) order.offer(node.left);
                if (node.right != null) order.offer(node.right);
            }
            if (fx && fy) return true;
            if (fx || fy) return false;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> order = new LinkedList<>();
        order.offer(root);
        while (!order.isEmpty()) {
            int levelsize = order.size();
            List<Integer> array = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                TreeNode curNode = order.poll();
                if (curNode != null) {
                    array.add(curNode.val);
                    order.offer(curNode.left);
                    order.offer(curNode.right);
                } else array.add(null);
            }
            int left = 0, right = array.size() - 1;
            while (left <= right) {
                if (!Objects.equals(array.get(left), array.get(right))) return false;
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> order = new LinkedList<>();
        Queue<TreeNode> order2 = new LinkedList<>();
        order.offer(p);
        order2.offer(q);
        while (!order.isEmpty()) {
            int levelsize = order.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode curNode = order.poll();
                TreeNode curNode2 = order2.poll();
                if (curNode.val != curNode2.val) return false;
                if (curNode.left != null && curNode2.left != null) {
                    order.offer(curNode.left);
                    order2.offer(curNode2.left);
                } else if (curNode.left != null || curNode2.left != null) return false;
                if (curNode.right != null && curNode2.right != null) {
                    order.offer(curNode.right);
                    order2.offer(curNode2.right);
                } else if (curNode.right != null || curNode2.right != null) return false;
            }
        }
        return true;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums);
        TreeNode root = null;
        for (int num : nums) {
            if (root == null) root = new TreeNode(num);
            else addNode(root, num);
        }
        return root;
    }

    private void addNode(TreeNode current, int data) {
        if (data < current.val) {
            if (current.left == null) {
                current.left = new TreeNode(data);
            } else addNode(current.left, data);
        } else if (data > current.val) {
            if (current.right == null) {
                current.right = new TreeNode(data);
            } else addNode(current.right, data);
        }
    }
}

class DFS {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    int height(TreeNode root) {
        if (root == null) return 0;

        int lefth = height(root.left);
        int righth = height(root.right);

        int dia = lefth = righth + 1;
        diameter = Math.max(dia, diameter);

        return Math.max(lefth, righth) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode l = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = l;
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int lefth = height(root.left);
        int righth = height(root.right);

        return Math.max(lefth, righth) + 1;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        // -10 -3 0 5 9
        return buildbst(nums, 0, nums.length - 1);
    }

    private TreeNode buildbst(int[] nums, int s, int e) {
        if (s > e) return null;
        int mid = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildbst(nums, s, mid - 1);
        node.right = buildbst(nums, mid + 1, e);
        return node;
    }

    public void flatten(TreeNode root) {
        flattenpreorder(root);
    }

    private TreeNode flattenpreorder(TreeNode root) {
        if (root == null) return null;
        TreeNode left = flattenpreorder(root.left);
        TreeNode right = flattenpreorder(root.right);
        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return right != null ? right : left != null ? left : root;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if (low != null && root.val < low || high != null && root.val > high) return false;
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversalin(root, list);
        return list;
    }

    private void traversalin(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traversalin(root.left, list);
        list.add(root.val);
        traversalin(root.right, list);
    }

    private TreeNode ancestor = null;  // Store the LCA node here

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        anhelp(root, p, q);
        return ancestor;
    }

    private boolean anhelp(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean leftCheck = anhelp(root.left, p, q);
        boolean rightCheck = anhelp(root.right, p, q);

        boolean currentMatch = (root == p || root == q);

        if ((leftCheck && rightCheck) || (leftCheck && currentMatch) || (rightCheck && currentMatch)) {
            ancestor = root;
        }
        return leftCheck || rightCheck || currentMatch;
    }

    TreeNode ancestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode leftsubtree = ancestor(root.left, p, q);
        TreeNode rightsubtree = ancestor(root.right, p, q);

        if (leftsubtree != null && rightsubtree != null) return root;

        return leftsubtree != null ? leftsubtree : rightsubtree;
    }

    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return help(root, k).val;
    }

    private TreeNode help(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode left = help(root.left, k);
        if (left != null) return left;
        count++;
        if (count == k) return root;
        return help(root.right, k);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int root = preorder[0];
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                idx = i;
            }
        }
        TreeNode node = new TreeNode(root);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        node.right = buildTree(Arrays.copyOfRange(preorder, idx + 1, preorder.length), Arrays.copyOfRange(inorder, idx + 1, inorder.length));

        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode successor = minval(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }

    private TreeNode minval(TreeNode node) {
        if (node.left != null) node = node.left;
        return node;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return giveheight(root) != -1;
    }

    private int giveheight(TreeNode root) {
        if (root == null) return 0;
        int left = giveheight(root.left);
        int right = giveheight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        String s = "";
        List<String> list = new ArrayList<>();
        givepath(root, s, list);
        return list;
    }

    private void givepath(TreeNode root, String s, List<String> list) {
        if (root != null) {
            if (!s.isEmpty()) s += "->";
            s += String.valueOf(root.val);
        }
        if (root.left == null && root.right == null) {
            list.add(s);
            return;
        }
        if (root.left != null) givepath(root.left, s, list);
        if (root.right != null) givepath(root.right, s, list);
    }

    private int TiltSum = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        givesum(root);
        return TiltSum;
    }

    private int givesum(TreeNode root) {
        if (root == null) return 0;
        int leftsum = givesum(root.left);
        int rightsum = givesum(root.right);
        TiltSum += Math.abs(leftsum - rightsum);
        return leftsum + rightsum + root.val;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return maxBThelper(nums);
    }

    private TreeNode maxBThelper(int[] nums) {
        if (nums.length == 0) return null;
        int maxi = findmax(nums);
        TreeNode root = new TreeNode(nums[maxi]);
        root.left = maxBThelper(Arrays.copyOfRange(nums, 0, maxi));
        root.right = maxBThelper(Arrays.copyOfRange(nums, maxi + 1, nums.length));
        return root;
    }

    private int findmax(int[] nums) {
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxi]) maxi = i;
        }
        return maxi;
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (root.val != node.val) return false;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return true;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 && right == 0) return left + right + 1;
        return Math.min(left, right) + 1;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        helpsum(root, targetSum, list, inner);
        return list;
    }

    private void helpsum(TreeNode root, int targetSum, List<List<Integer>> list, List<Integer> inner) {
        if (root == null) return;
        inner.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) list.add(new ArrayList<>(inner));
        else {
            helpsum(root.left, targetSum - root.val, list, inner);
            helpsum(root.right, targetSum - root.val, list, inner);
        }
        inner.remove(inner.size() - 1);
    }

    private int Totalsum = 0;
    private int n = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        n *= 10;
        n += root.val;
        int left = sumNumbers(root.left);
        int right = sumNumbers(root.right);
        if (left + right == 0) Totalsum += n;
        return n /= 10;
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // In - order traversal DFS
        helpmaxsum(root);
        return maxSum;
    }

    private int helpmaxsum(TreeNode root) {
        if (root == null) return 0;
        int left = helpmaxsum(root.left);
        int right = helpmaxsum(root.right);
        if (left < 0) left = 0;
        if (right < 0) right = 0;
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    // How many path will exist in a binary tree to sum with a Tsum , give no. of paths
    void pathsexist(TreeNode root, int Tsum, int Csum, int counter) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.val > Tsum) {
            pathsexist(root.left, Tsum, 0, counter);
            pathsexist(root.right, Tsum, 0, counter);
        }
        if (Csum < root.val) Csum += root.val;
        if (Csum == Tsum) {
            counter++;
            pathsexist(root.left, Tsum, 0, counter);
            pathsexist(root.right, Tsum, 0, counter);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        class Pair {
            final TreeNode node;
            final int index;

            Pair(TreeNode node, int index) {
                this.node = node;
                this.index = index;
            }
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        int width = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            int start = queue.peek().index;
            int end = start;
            for (int i = 0; i < level; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int idx = current.index;
                end = idx;
                if (node.left != null) queue.add(new Pair(node.left, 2 * idx + 1));
                if (node.right != null) queue.add(new Pair(node.right, 2 * idx + 2));
            }
            width = Math.max(width, end - start + 1);
        }
        return width;
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int minlevel = 1;
        int levelidx = 0;
        int maxsum = root.val;
        while (!queue.isEmpty()) {
            int level = queue.size();
            int sum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (sum > maxsum) {
                minlevel = levelidx + 1;
                maxsum = sum;
            }
            levelidx++;
        }
        return minlevel;
    }

    int sizeTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                count++;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return count;
    }

    boolean balance = true;

    boolean isheightbalanced(TreeNode root) {
        if (root == null) return true;
        heightgive(root);
        return balance;
    }

    int heightgive(TreeNode root) {
        if (root == null) return 0;
        int left = heightgive(root.left);
        int right = heightgive(root.right);
        if (Math.abs(left - right) > 1) balance = false;
        return Math.max(left, right) + 1;
    }

    boolean BST = true;

    public boolean isBST(TreeNode root) {
        if (root == null) return true;
        checkBST(root, null, null);
        return BST;
    }

    private void checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            BST = false;
            return;
        }
        checkBST(root.left, min, root.val);
        checkBST(root.right, root.val, max);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        recoverhelper(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
    }

    private void recoverhelper(TreeNode root, TreeNode minValue, TreeNode maxValue) {
        if (root == null) return;
        if (root.left != null && root.right != null) {
            if (root.left.val > root.val && root.right.val < root.val) {
                int temp = root.left.val;
                root.left.val = root.right.val;
                root.right.val = temp;
            }
            return;
        }
        if (minValue.val != Integer.MIN_VALUE && !(minValue.val < root.val)) {
            int temp = root.val;
            root.val = minValue.val;
            minValue.val = temp;
            return;
        }
        if (maxValue.val != Integer.MAX_VALUE && !(root.val < maxValue.val)) {
            int temp = root.val;
            root.val = maxValue.val;
            maxValue.val = temp;
            return;
        }
        recoverhelper(root.left, minValue, root);
        recoverhelper(root.right, root, maxValue);
    }

    int second = -1;
    int first = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        first = root.val;
        sec_min(root.left);
        return second;
    }

    private void sec_min(TreeNode node) {
        if (node == null) return;
        if (node.val > first) {
            if (second == -1 || node.val < second) {
                second = node.val;
            }
        }
        sec_min(node.left);
        sec_min(node.right);
    }
}

class FindElements {
    HashSet<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        set.add(root.val);
        RecTree(root);
    }

    private void RecTree(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            set.add(root.left.val);
            RecTree(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            set.add(root.right.val);
            RecTree(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}


class execute {
    public static void main(String[] args) {

    }
}