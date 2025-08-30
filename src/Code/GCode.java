package Code;

import java.util.*;

public class GCode {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    Node removeDuplicates(Node head) {
        if (head.next == null) return head;
        return head;
    }

    public static ArrayList<Integer> duplicates(int[] arr) {
        if (arr.length == 1) return new ArrayList<>(List.of(arr[0]));
        Set<Integer> set = new HashSet<>(arr.length);
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        for (int n : arr) {
            if (!set.add(n)) list.add(n);
        }
        Arrays.sort(new ArrayList[]{list});
        return list.isEmpty() ? new ArrayList<>(List.of(-1)) : list;
    }

    static int isNarcissistic(int N) {
        int numDigits = countDigits(N);
        return nar(N, 0, numDigits) == N ? 1 : 0;
    }

    private static int nar(int N, int Sum, int power) {
        if (N == 0) return Sum;
        int n = N % 10;
        Sum += (int) Math.pow(n, power);
        return nar(N / 10, Sum, power);
    }

    private static int countDigits(int N) {
        return (int) Math.log10(N) + 1;
    }

    public void printNos(int N) {
        if (N < 1) return;
        else {
            printNos(N - 1);
            System.out.println(N);
        }
    }

    static void printTillN(int N) {
        if (N < 1) return;
        else {
            printTillN(N - 1);
            System.out.print(N + " ");
        }
    }

    static int sumOfDigits(int N) {
        return sum(N, 0);
    }

    private static int sum(int N, int sum) {
        if (N % 10 == 0) return sum;
        sum += N % 10;
        return sum(N / 10, sum);
    }

    int getMiddle(Node head) {
        if (head == null) return -1;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    Node reverseList(Node head) {
        if (head.next == null) return head;
        Node current = head;
        Node prev = null;
        Node temp;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    int getKthFromLast(Node head, int k) {
        int len = 0;
        Node c1 = head;
        Node c2 = head;
        while (c2 != null) {
            if (len < k) len++;
            else break;
            c2 = c2.next;
        }
        if (len != k) return -1;
        else {
            while (c2 != null) {
                c1 = c1.next;
                c2 = c2.next;
            }
            return c1.data;
        }
    }

    Node insertAtEnd(Node head, int x) {
        Node n = new Node(x);
        if (head == null) head = n;
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = n;
        return head;
    }

    int missingNumber(int n, int[] arr) {
        Arrays.sort(arr);
        int idx = 1;
        for (int a : arr) {
            if (a == idx) idx++;
            else return idx;
        }
        return -1;
    }

    public int GetNth(Node head, int index) {
        int idx = 0;
        Node current = head;
        while (current != null) {
            if (idx + 1 == index) return current.data;
            current = current.next;
            idx++;
        }
        return -1;
    }

    public boolean isLengthEven(Node head) {
        int n = 0;
        Node current = head;
        while (current != null) {
            n++;
            current = current.next;
        }
        return n % 2 == 0;
    }

    //    public int maxLen(int[] arr) {
//        if (arr.length==1)return 0;
//        int min = Integer.MAX_VALUE;
//        for(int i = 0  ; i<arr.length ; i++){
//
//        }
//    }
    static class QQ {
        TreeNode root;
        int depth;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<QQ> queue = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();  // For maximum
        int max = Integer.MIN_VALUE;
        QQ qq = new QQ();
        qq.root = root;
        qq.depth = 0;
        queue.add(qq);
        while (!queue.isEmpty()) {
            QQ q = queue.poll();
            TreeNode n = q.root;
            int dep = q.depth;
            max = Math.max(max, q.depth);

            boolean l = false, r = false;
            if (n.left != null) {
                QQ left = new QQ();
                left.root = n.left;
                left.depth = q.depth + 1;
                queue.add(left);
            } else l = true;
            if (n.right != null) {
                QQ right = new QQ();
                right.root = n.right;
                right.depth = q.depth + 1;
                queue.add(right);
            } else r = true;

            if (l && r) {
                map.put(max, q.root);
            }
        }
        return map.get(max);
    }

    static class cq {
        TreeNode root;
        int depth;

        cq(TreeNode root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean oe = true;
        int depth =0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            oe = depth % 2 == 0;
            int last = oe ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (oe) { // Strictly Increasing Odd values
                    if (n.val % 2 == 0) return false;
                    if (last<n.val)last = n.val;
                    else return false;

                } else { // Strictly Decreasing is allowed
                    if (n.val % 2 != 0) return false;
                    if (last>n.val)last = n.val;
                    else return false;
                }

                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            depth++;
        }
        return true;
    }

    public static void main(String[] args) {
        GCode g = new GCode();
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
//        System.out.println(g.maxLen(arr));
//        System.out.println(isNarcissistic(548834));
    }
}
