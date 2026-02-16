package Code;

import java.util.*;


public class LcodeLinkedList {
    static class Node {
        int val;
        Node next;
        Node random;
        Node left;
        Node right;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }

    //    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//
//    }
    public ListNode removeElements(ListNode head, int target) {
        if (head == null) return null;
        if (head.val == target) {
            while (head.val == target) {
                head = head.next;
            }
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == target) {
                node.next = node.next.next;
            } else node = node.next;
        }
        if (node.val == target) {
            node = null;
        }
        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        for (int i = 1; i < left; i++) {
            current = current.next;
        }
        ListNode start = current.next;
        ListNode next = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = next.next;
            next.next = current.next;
            current.next = next;
            next = start.next;
        }
        return dummy.next;
    }

    public boolean ispalindrome(ListNode head) {
        if (head.next == null) return true;
        Stack<Integer> stacks = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stacks.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (stacks.pop() != slow.val) return false;
            slow = slow.next;
        }
        return true;
    }

    private static final int[] array = new int[100001];

    public boolean isPalindrome(ListNode head) {
        ListNode c = head;
        int size = 0;
        while (c != null) {
            array[size++] = c.val;
            c = c.next;
        }
        for (int i = 0; i < size / 2; i++) {
            if (array[i] != array[size - i - 1]) return false;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode prev = null;
        ListNode Node = null;
        while (current != null) {
            Node = current.next;
            current.next = prev;
            prev = current;
            current = Node;
        }
        return prev;
    }


    public boolean asCycle(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

    void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        int m = 0;
        for (int ch : nums) {
            m = Math.max(m, ch);
        }
        boolean[] bool = new boolean[m + 1];
        for (int ch : nums) {
            if (ch == m) break;
            else bool[ch] = true;
        }
        int c = 0;
        ListNode current = head;
        ListNode n;
        while (current != null) {
            if (current.val > m) continue;
            if (bool[current.val]) {
                n = current;
                while (n != null) {
                    if (bool[n.val]) {
                        bool[n.val] = false;
                        n = n.next;
                    } else break;
                }
                c++;
            }
            current = current.next;
        }
        return c;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        String pre = strs[0];
        int i = 0;
        while (strs[0].indexOf(pre) != 0) {
            pre = pre.substring(0, pre.length() - 1);
            if (pre.isEmpty()) return "";
        }
        return pre;
    }

    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stacks = new Stack<>();
        int i = 0, j = 0, MaxWidth = 0, ele = 0;
        for (j = 0; j < nums.length; j++) {
            if (i < j) if (nums[i] <= nums[j]) MaxWidth = Math.max(MaxWidth, j - i);
            else {
                stacks.push(i);
                i++;
            }
        }
        System.out.println(j);
        while (!stacks.isEmpty()) {
            ele = stacks.pop();
            if (nums[ele] < nums[j - 1]) MaxWidth = Math.max(MaxWidth, j - ele);
        }
        return MaxWidth;
    }

    public int minGroups(int[][] intervals) {
        int n = 0;
        boolean[] bool = new boolean[intervals.length];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (!bool[i]) {
                int[] current = intervals[i];
                bool[i] = true;

                for (int j = i + 1; j < intervals.length; j++) {
                    if (!bool[j] && (current[1] < intervals[j][0] ||
                            intervals[j][1] < current[0])) {
                        bool[j] = true;
                        current = intervals[j];
                    }
                }
                n++;
            }
        }
        return n == 0 ? 1 : n;
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String MaxString = "";
        int left = 0, right = 0;

        return MaxString;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != left.val) {
                left.next = cur;
                left = cur;
            }
            cur = cur.next;
        }
        left.next = null;
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        while (cur != null) {
            boolean check = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                check = true;
            }
            if (check) prev.next = cur.next;
            else prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // optmised approach
        //if ( lists==null  || lists.length==0 )return null;
        //        PriorityQueue<ListNode>queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        //        for(ListNode head : lists){
        //            if (head!=null ) queue.add(head);
        //        }
        //        ListNode dummy = new ListNode(0);
        //        ListNode cur = dummy;
        //        ListNode small=null;
        //        while(!queue.isEmpty()){
        //            small=queue.poll();
        //            cur.next=small;
        //            cur=cur.next;
        //            if ( small.next!=null)queue.add(small.next);
        //        }
        //        return dummy.next;

        if (lists.length == 0) return null;
        // Naive approach
        List<ListNode> list = new ArrayList<>();
        ListNode temp = null;
        for (ListNode head : lists) {
            temp = head;
            while (temp != null) {
                list.add(temp);
                temp = temp.next;
            }
        }
        if (list.isEmpty()) return null;

        list.sort(Comparator.comparingInt(node -> node.val));
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            ListNode newHead = reverseList(head, k);
            head.next = reverseKGroup(cur, k);
            return newHead;
        }
        return head;
    }

    private ListNode reverseList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode cur = head;
        int size = 1;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        k %= size;
        if (k == 0) return head;
        cur.next = head;
        int stepsToNewHead = size - k;
        cur = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }

    //    public ListNode reverseBetween(ListNode head, int left, int right) {
    //
    //    }
    public Node copyRandomList(Node head) {
        if (head == null || head.next == null) return head;
        Node cur = head.next;
        Node Head = new Node(head.val);
        Node newcur = Head;
        while (cur != null) {
            if (cur.next != null) {
                Node r = cur.random;
                Node node = new Node(cur.val);
                node.random = r;
                Node newnode = new Node(cur.next.val);
                r = cur.next.random;
                newnode.random = r;
                newcur.next = node;
                newcur = newcur.next;
                newcur.next = newnode;
                newcur = newcur.next;
                cur = cur.next.next;
            } else {
                newcur.next = new Node(cur.val);
                newcur = newcur.next;
                cur = null;
            }
        }
        newcur.next = null;
        return Head;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        while (head != null && set.contains(head.val)) head = head.next;
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop();
            }
            stack.add(cur);
            cur = cur.next;
        }
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            cur.next = newHead;
            newHead = cur;
        }
        return newHead;
    }

    //    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//
//    }
    public ListNode swapPairs(ListNode head) {
        // 1 2 3 4 → 2 1 4 3
        // Key is basically u have to swap the node value when u see the 2 nodes
        if (head == null || head.next == null) return head;
        int count = 1;
        ListNode c = head;
        while (c != null) {
            if (c.next != null) {
                if (c.next.next != null) {
                    int t = c.val;
                    c.val = c.next.val;
                    c.next.val = t;
                    c = c.next.next;
                }
                c = c.next;
            }
        }
        return head;
    }

    public void rotate(int[] nums, int k) {
        if (k < nums.length - 1 && k != 0) { // if k is less than nums length and reduntant k == 0
            if (k == 1 && nums.length == 2) {
                int t = nums[0];
                nums[0] = nums[1];
                nums[1] = t;
            }
            helprotate(nums, k);
        }
    }

    private void helprotate(int[] nums, int k) {
        if (k != 0) {
            int temp = 0;
            int i = 1;
            for (i = 1; i < nums.length; i++) {
                if (i == 1) {
                    temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = nums[nums.length - 1];
                } else {
                    int n = nums[i];
                    nums[i] = temp;
                    temp = n;
                }
            }
            helprotate(nums, k - 1);
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;

        int lenA = 0, lenB = 0;
        ListNode c1 = headA, c2 = headB;

        while (c1 != null || c2 != null) {
            if (c1 != null) {
                c1 = c1.next;
                lenA++;
            }
            if (c2 != null) {
                c2 = c2.next;
                lenB++;
            }
        }
        c1 = headA;
        c2 = headB;
        if (lenA > lenB) for (int i = 0; i < lenA - lenB; i++) c1 = c1.next;
        else for (int i = 0; i < lenB - lenA; i++) c2 = c2.next;

        while (c1 != c2) {
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1;


//        if (headA== null)return headB;
//        if (headB==null)return headA;
//        ListNode c1 = headA;
//        ListNode c2 = headB;
//        ListNode found = null;
//        while(c1!=null){
//            while(c2!=null){
//                if (c1==c2){
//                    found=c2;
//                    break;
//                }
//                c2=c2.next;
//            }
//            c2=headB;
//            if ( found!=null)break;
//            else c1=c1.next;
//        }
//        return found;
    }

    public ListNode mergeNodes(ListNode head) {
        // 0 1 2 3  0 3 4  2 1  0
        // 6 10
        if (head == null || head.next == null) return head;
        ListNode start = head, right = head.next;
        int sum = 0;
        while (right != null) {
            if (right.val == 0) {
                start.val = sum;
                start.next = right;
                if (right.next != null) start = right;
                sum = 0;
            }
            sum += right.val;
            right = right.next;
        }
        return head;
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] array = new int[m][n];
        Arrays.fill(array, -1);
//        int start = 0;
        int top = 0, len = m, inlen = n;
        ListNode c1 = head;
        boolean check = false;
        while (top < len && !check) {
            int j = top;
            while (j < inlen && !check) {
                if (j + 1 == len) {
                    for (int i = top; i < len; i++) {
                        if (c1 != null) {
                            array[i][j] = c1.val;
                            c1 = c1.next;
                        } else {
                            check = true;
                            break;
                        }
                    }
                    for (j = j - 1; j > 0; j--) {
                        if (c1 != null) {
                            array[len - 1][j] = c1.val;
                            c1 = c1.next;
                        } else {
                            check = true;
                            break;
                        }
                    }
                    for (int i = len - 1; i > top; i--) {
                        if (c1 != null) {
                            array[i][j] = c1.val;
                            c1 = c1.next;
                        } else {
                            check = true;
                            break;
                        }
                    }
                } else {
                    if (c1 != null) {
                        array[top][j] = c1.val;
                        c1 = c1.next;
                    } else {
                        check = true;
                        break;
                    }
                }
            }
            top++;
            len--;
            inlen--;
        }
//        boolean check = false;
//        while (start < m) {
//            if (!check) {
//                if (m>0){
//                    for (int i = 0; i < m; i++) {
//                        // left to right
//                        if (c1 != null) {
//                            array[start][i] = c1.val;
//                            c1 = c1.next;
//                        } else {
//                            check = true;
//                            break;
//                        }
//                    }
//                }
//                if ( ){
//                    for (int i = 0; i < n; i++) {
//                        // top to bottom
//                        if (c1 != null) {
//                            array[m - 1][i] = c1.val;
//                            c1 = c1.next;
//                        } else {
//                            check = true;
//                            break;
//                        }
//                    }
//                }
//                if ( ){
//                    for (int i = n-1; i <; i++) {
//
//                    }                }
//
//            }
//            start++;
//        }
        return array;
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);

        ListNode idx1 = p1;
        ListNode idx2 = p2;

        while (head != null) {
            if (head.val < x) {
                idx1.next = head;
                idx1 = idx1.next;
            } else {
                idx2.next = head;
                idx2 = idx2.next;
            }
            head = head.next;
        }
        idx1.next = p2.next;
        idx2.next = null;
        return p1.next;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }

    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            Node last = null;

            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                if (last != null) last.next = node;
                last = node;
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            last.next = null;
        }
        return root;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // solved for empty head or 2 node list
        ListNode last = head;
        int size = 0, k = 0;
        while (last != null) {
            size++;
            last = last.next;
        }
        last = head;
        ListNode[] array = new ListNode[size];
        while (last != null) {
            array[k++] = last;
            last = last.next;
        }
        int start = 0, end = array.length - 1;
        while (start < end) {
            array[start].next = array[end];
            start++;
            if (start < end) {
                array[end].next = array[start];
            }
            end--;
        }
        array[start].next = null;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode s = head;
        ListNode f = head.next;

        while (f != null || f.next == null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode mid = s.next;
        s.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
//        if ( head == null )return head;
//        ListNode last = head;
//        int size = 0 , k = 0 ;
//        while (last != null) {
//            size++;
//            last = last.next;
//        }
//        last=head;
//        ListNode[] array  = new ListNode[size];
//        while (last != null) {
//            array[k++]=last;
//            last = last.next;
//        }
//        Arrays.sort(array,Comparator.comparingInt(node->node.val));
//        for (int i = 1 ; i < size ; i++){
//            array[i-1].next=array[i];
//        }
//        array[size].next=null;
//        return array[0];
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode d = new ListNode(0);
        ListNode c = d;
        while (left != null && right != null) {
            if (left.val >= right.val) {
                c.next = left;
                c = c.next;
                left = left.next;
            } else {
                c.next = right;
                c = c.next;
                right = right.next;
            }
        }
        return d.next;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode even = head.next, o_adder = head, e_adder = head.next;
        ListNode cur = head.next.next;
        int i = 1;
        while (cur != null) {
            if (i % 2 != 0) {
                o_adder.next = cur;
                o_adder = cur;
            } else {
                e_adder.next = cur;
                e_adder = cur;
            }
            i++;
            cur = cur.next;
        }
        e_adder.next = null;
        o_adder.next = even;
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1 != null || c2 != null) {
            if (c1 != null) {
                s1.add(c1);
                c1 = c1.next;
            }
            if (c2 != null) {
                s2.add(c2);
                c2 = c2.next;
            }
        }

        Stack<ListNode> max = s1.size() >= s2.size() ? s1 : s2;
        Stack<ListNode> min = max == s1 ? s2 : s1;

        int carry = 0;
        while (!min.isEmpty()) {
            int sum = max.peek().val + min.peek().val + carry;
            carry = sum / 10;
            max.peek().val = sum % 10;
            max.pop();
            min.pop();
        }
        ListNode ans = max == s1 ? l1 : l2;
        boolean change = false;
        while (carry == 1) {
            if (max.isEmpty()) {
                ans = new ListNode(carry);
                ans.next = max == s1 ? l1 : l2;
                carry = 0;
                change = false;
            } else {
                int sum = max.peek().val + carry;
                carry = sum / 10;
                max.peek().val = sum % 10;
                max.pop();
                change = true;
            }
        }
        if (change) ans = max == s1 ? l1 : l2;
        return ans;
    }

    public int calculate(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        boolean lastWasOperator = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                lastWasOperator = false;
            } else if (c == '+' || c == '-') {
                result += sign * num;
                num = 0;
                if (lastWasOperator) sign = (c == '-') ? -sign : sign;
                else sign = (c == '-') ? -1 : 1;
                lastWasOperator = true;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                lastWasOperator = true;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
                lastWasOperator = false;
            } else if (c == ' ') continue;
            else lastWasOperator = false;

        }
        result += sign * num;
        return result;
    }

    public int pairSum(ListNode head) {
        //------------------ Space Optinised Approach -----------------
        ListNode lastvisit = null , cur = head;
        int max=0;
        while(cur!=lastvisit){
            int s=0;
            ListNode last =head;
            while (last.next!=lastvisit){
                last=last.next;
                s++;
            }
            if(cur==last)break;
            lastvisit=last;
            if(s==2){
                return head.val+head.next.val;
            }
            else {
                max= Math.max(cur.val + last.val, max);
            }
            cur=cur.next;
        }

        return max;
        //------------------ Naive Approach----------------------------
//        int size = 0 ;
//        ListNode prev = null;
//        ListNode cur = head.next;
//        ListNode h2=new ListNode(head.val);
//        ListNode t2 = h2;
//        //Creating a dup list for the reversal
//        while (cur!=null){
//            ListNode t = new ListNode(cur.val);
//            t2.next=t;
//            t2=t;
//            cur=cur.next;
//        }
//        // Reverse is done
//        cur=h2;
//        while(cur!=null){
//            size++;
//            ListNode t = cur.next;
//            cur.next=prev;
//            prev=cur;
//            cur=t;
//        }
//        //Now will calculate the max sum
//        int max=0;
//        cur=head;
//        while( prev!=null &&  cur!=null){
//            if(cur.val+ prev.val>=max)max=cur.val+ prev.val;
//            cur=cur.next;
//            prev=prev.next;
//        }
//        return max;
    }

    public int getDecimalValue(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        //Reversing the list
        while(cur!=null){
            ListNode t = cur.next;
            cur.next=prev;
            prev=cur;
            cur=t;
        }

        //Retrieving the decimal values
        int num =0 , i=0;
        while (prev!=null){
            if(prev.val==1)num+=(int)Math.pow(2,i);
            i++;
            prev=prev.next;
        }
        return num;
    }

    public int clumsy(int n) {
        if(n==1 || n==2)return n;

        int res=n;
        int pre=Integer.MIN_VALUE;
        int j=0;
        for (int i = n-1; i >=1; i--) {
            if(j==4)j=0;
            if(j==0)res=res*i;
            else if(j==1)res=res/i;
            else if(j==2)res=res+i;
            else if(j==3){
                if(pre==Integer.MIN_VALUE)pre=res;
                else pre=pre-clumsy(i);
            }
            j++;
        }
        return res;
    }
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        rec(root,false);
        return sum;
    }

    private void rec(TreeNode root,boolean isleft) {
        if (isleft && root.left==null && root.right==null)sum+=root.val;
        if(root==null)return;
        rec(root.left,true);
        rec(root.right,false);
    }

//    public int maxDepth(Node root) {
//        if(root==null)return 0;
//        int max =0;
//        for (Node x: root.children){
//            max = Math.max(max, maxDepth(x));
//        }
//        return max+1;
//    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);  // Base case: Empty tree
            return trees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    public void recoverTree(TreeNode root) {
        if(root==null)return;
        TreeNode[] nodes = new TreeNode[3];
        correcrTree(root,nodes);
        swapnodes(nodes[0],nodes[1]);
    }

    private void correcrTree(TreeNode root, TreeNode[] nodes) {
        if(root==null)return;
        correcrTree(root.left,nodes);
        if(nodes[2]!=null && root.val < nodes[2].val){
            if(nodes[0]==null)nodes[0]=nodes[2];
            nodes[1]=root;
        }
        nodes[2]=root;
        correcrTree(root.right,nodes);
    }

    private void swapnodes(TreeNode root1, TreeNode root2) {
        int t = root2.val;
        root2.val=root1.val;
        root1.val=t;
    }

    public TreeNode buildTree(int[] iorder, int[] porder) {
        if(iorder.length==1 && porder.length==1)return new TreeNode(iorder[0]);
        return build(iorder,porder,0,iorder.length-1,porder.length-1);
    }

    private TreeNode build(int[] iorder, int[] porder, int s,int e, int px) {
        if(s>e || px<0)return null;
        TreeNode root=new TreeNode(porder[px]);
        int ridx =0;
        for(int i=s;i<=e;i++){
            if(iorder[i]==porder[px]){
                ridx=i;
                break;
            }
        }
        root.right=build(iorder,porder,ridx+1,e,px-1);
        root.left=build(iorder,porder,s,ridx-1,px-1-(e-ridx));
        return root;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) break;
        }
        if(fast==null || fast.next==null)return null;
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    class LRUCache {
        static class Node {
            int val ,key;
            Node next , prev;
            Node(int key, int value){
                this.key=key;
                this.val=value;
                prev=null;
                next=null;
            }
        }
        Map<Integer,Node> map;
        Node root;
        Node tail;
        int size;
        public LRUCache(int cap) {
            root=null;
            tail=null;
            size=cap;
            map=new HashMap<>(cap+1);
            root=new Node(-1,-1);
            tail=new Node(-1,-1);

            root.next=tail;
            tail.prev=root;
        }

        void MoveToEnd(Node node){
            remove(node);
            insertEnd(node);
        }

        void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }

        void insertEnd(Node node){
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                MoveToEnd(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                MoveToEnd(node);
                return;
            }
            else if (map.size() == size) {
                Node lru = root.next;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertEnd(newNode);
            map.put(key, newNode);
        }
    }


    public static void main(String[] args) {
        LcodeLinkedList l = new LcodeLinkedList();
//        System.out.println(l.clumsy(10));
        System.out.println(l.generateTrees(3).size());
//        System.out.println(l.calculate("\"1-(     -2)"));
//        ListNode s = new ListNode(23);
//        s.next = new ListNode(34);
//        s.next.next = new ListNode(45);
////        s.next.next.next = new ListNode(1);
//
//        // Traverse and print the linked list
//        ListNode n = s;
//        while (n != null) {
//            System.out.println(n.val);
//            n = n.next;
//        }
//        l.swapPairs(s);
//        System.out.println();
//        n = s;
//        while (n != null) {
//            System.out.println(n.val);
//            n = n.next;
//        }
        // Nodes  = 23 34 45 1
        // Expected = 34 23 1 45
//        int[][] array = {
//                {5, 10},
//                {6, 8},
//                {1, 5},
//                {2, 3},
//                {1, 10}
//        };
//        System.out.println(l.minGroups(array));
//        System.out.println(l.maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }

}
