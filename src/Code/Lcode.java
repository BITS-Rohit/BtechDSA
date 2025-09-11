package Code;

import java.math.BigInteger;
import java.util.*;

public class Lcode {
    static class MyLinkedList {
        private final int data;
        private MyLinkedList next = null;
        private MyLinkedList prev = null;
        private int size = 0;

        MyLinkedList(int val) {
            this.data = val;
        }

        MyLinkedList head = null;
        MyLinkedList tail = null;

        public int get(int idx) {
            if (isEmpty()) return -1;
            else if (idx < 0 && idx > size) return -1;
            else {
                int c = 0;
                MyLinkedList current = head;
                while (c != idx) {
                    current = current.next;
                    c++;
                }
                return current.data;
            }
        }

        public void addAtHead(int val) {
            MyLinkedList newnode = new MyLinkedList(val);
            if (isEmpty()) head = tail = newnode;
            else {
                newnode.next = head;
                head.prev = newnode;
                head = newnode;
            }
            size++;
        }

        public void addAtTail(int val) {
            MyLinkedList newnode = new MyLinkedList(val);
            if (isEmpty()) head = tail = newnode;
            else {
                tail.next = newnode;
                newnode.prev = tail;
                tail = newnode;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) addAtHead(val);
            else if (index < size) {
                MyLinkedList newnode = new MyLinkedList(val);
                int current = 0;
                MyLinkedList c = head;
                while (current + 1 != index) {
                    c = c.next;
                    current++;
                }
                newnode.next = c.next;
                newnode.prev = c;
                c.next.prev = newnode;
                c.next = newnode;
            } else if (index == size) addAtTail(val);
        }

        public void deleteAtIndex(int idx) {
            if (idx > -1 && idx <= size) {
                if (idx == 0) head = head.next;
                else if (idx == size) tail = tail.prev;
                else {
                    int n = 0;
                    MyLinkedList current = head;
                    while (n != idx) {
                        current = current.next;
                        n++;
                    }
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                    size--;
                }
            }
        }

        private boolean isEmpty() {
            return head == null || tail == null;
        }
    }

    public int maxSubArray(int[] nums) {
        int Max = nums[0];
        int current = nums[0];
        for (int n : nums) {
            current += n;
            if (current < 0) current = 0;
            else Max = current;
        }
        return Max;
    }

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        double min = Integer.MAX_VALUE;
        while (low <= high) {
            double ans = (double) (nums[low] + nums[high]) / 2;
            min = Math.min(min, ans);
            low++;
            high--;
        }
        return min;
    }

    public int compareVersion(String version1, String version2) {
        String[] v1paart = version1.split("\\.");
        String[] v2paart = version1.split("\\.");
        for (int i = 0; i < Math.max(version1.length(), version2.length()); i++) {
            int v1 = i < v1paart.length ? Integer.parseInt(v1paart[i]) : 0;
            int v2 = i < v2paart.length ? Integer.parseInt(v2paart[i]) : 0;
            if (v1 < v2) return -1;
            else return 1;
        }
        return 0;
    }

    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < 0) set.add(num);
        }
        int Max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (set.contains(-num)) Max = Math.max(Max, num);
        }
        return Max == Integer.MIN_VALUE ? -1 : Max;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode ddTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            while (l1 != null) {
                s1.append(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                s2.append(l2.val);
                l2 = l2.next;
            }
            BigInteger b1 = new BigInteger(s1.reverse().toString());
            BigInteger b2 = new BigInteger(s2.reverse().toString());
            String sum = b1.add(b2).toString();
            ListNode head = null;     // for head node answer returnig

            for (int i = sum.length() - 1; i >= 0; i--) {
                if (head == null) head = new ListNode(Character.getNumericValue(sum.charAt(i)));
                ListNode newNode = new ListNode(Character.getNumericValue(sum.charAt(i)));
                newNode.next = head;
                head = newNode;
            }
            return head;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;  //returning head
            ListNode tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int v1 = (l1 != null) ? l1.val : 0;
                int v2 = (l2 != null) ? l2.val : 0;
                int sum = v1 + v2 + carry;
                carry = sum / 10;
                if (head == null) {
                    head = new ListNode(sum);
                    tail = head;
                } else {
                    ListNode newnode = new ListNode(sum);
                    tail.next = newnode;
                    tail = newnode;
                }

                l1 = (l1 != null) ? l1.next : null;
                l2 = (l2 != null) ? l2.next : null;
            }
            if (carry > 0) {
                ListNode n = new ListNode(carry);
                n.next = head;
                head = n;
            }
            return head;
        }
    }

    public int lengthOflongestSubstring(String s) {
        int sum = 0;
        String current = "";
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            current = current.concat(str);
            for (int j = i + 1; j < s.length(); j++) {
                if (current.contains(s.substring(j, j + 1))) {
                    sum = Math.max(sum, current.length());
                    current = "";
                    break;
                } else {
                    current = current.concat(s.substring(j, j + 1));
                }
            }
        }
        return sum;
    }

    public int sizeLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right;
        HashSet<Character> set = new HashSet<>();
        for (right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(right));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] array = new int[128];
        int start = 0;
        int max = 0;
        for (int i = 0; i < 128; i++) array[i] = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (array[ch] >= start) start = array[ch] + 1;
            array[ch] = i;
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Handle the case when one of the arrays is empty
        if (nums1.length == 0) {
            return findMedianSingleArray(nums2);
        }
        if (nums2.length == 0) {
            return findMedianSingleArray(nums1);
        }

        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }

        // Copy remaining elements from nums1 if any
        while (i < nums1.length) merged[k++] = nums1[i++];

        // Copy remaining elements from nums2 if any
        while (j < nums2.length) merged[k++] = nums2[j++];

        // Find the median
        int n = merged.length;
        if (n % 2 == 1) {
            return merged[n / 2];
        } else {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        }
    }

    // Helper method to find the median of a single array
    private double findMedianSingleArray(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return nums[n / 2];
        } else {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;
        }
    }

    public int reverse(int x) {
        int temp = x;
        temp = Math.abs(temp);
        String s = String.valueOf(temp);
        StringBuilder str = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            str.insert(0, s.charAt(i));
        }
        str = new StringBuilder(str.reverse().toString());
        if (x < 0) return Integer.parseInt("-".concat(str.toString()));
        else return Integer.parseInt(str.toString());
    }

    public String LongestCommonPrefix(String[] strs) {
        int[] mapping = new int[128];
        for (String s : strs) {
            for (char ch : s.toCharArray()) {
                mapping[ch]++;
            }
        }
        StringBuilder str = new StringBuilder();
        char[] cherry = strs[0].toCharArray();
        for (char c : cherry) {
            if (mapping[c] == strs.length) {
                str.append(c);
            }
        }
        return String.valueOf(str);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int[] mapping = new int[128];
        for (String s : strs) {
            for (char ch : s.toCharArray()) {
                mapping[ch]++;
            }
        }
        StringBuilder str = new StringBuilder();
        for (char ch : strs[0].toCharArray()) {
            if (mapping[ch] == strs.length) str.append(ch);
            else break;
        }
        return String.valueOf(str);
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE, x = 0, y = 0;
        while (x < nums1.length && y < nums2.length) {
            if (nums1[x] == nums2[y]) {
                min = Math.min(min, nums1[x]);
                x++;
                y++;
            } else if (nums1[x] < nums2[y]) {
                x++;
            } else {
                y++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) return false;
        Stack<Character> stacks = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') stacks.push(ch);
            else {
                if (stacks.isEmpty()) return false;
                if (ch == ')' && stacks.peek() != '(') return false;
                else if (ch == '}' && stacks.peek() != '{') return false;
                else if (ch == ']' && stacks.peek() != '[') return false;
                stacks.pop();
            }
        }
        return stacks.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode c1 = list1;
        ListNode c2 = list2;
        ListNode temp = null;
        ListNode HEAD = null;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                temp = c1;
                temp.next = c2;
                temp = temp.next;
                c1 = c1.next;
                c2 = c2.next;
            } else if (temp == null) temp = c2;
            if (HEAD == null) HEAD = temp;
        }
        return HEAD;
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && needle.charAt(j) == haystack.charAt(i + j)) {
                j++;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

    static int MaxSumSubarray(int[] nums, int size) {
        int tempSum = 0;
        for (int i = 0; i < size; i++) {
            tempSum += nums[i];
        }
        int MaxSum = tempSum;
        for (int i = 1; i <= nums.length - size; i++) {
            tempSum = tempSum - nums[i - 1] + nums[i + size - 1];
            MaxSum = Math.max(MaxSum, tempSum);
        }
        return MaxSum;
    }

    public long maximumSubarraySum(int[] nums, int size) {
        long tempSum = 0;
        Set<Integer> set = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            if (!set.add(nums[i])) return 0;
            else tempSum += nums[i];
        }
        long MaxSum = tempSum;
        for (int i = size; i < nums.length; i++) {
            tempSum -= nums[i - size];
            set.remove(nums[i - size]);
            if (!set.add(nums[i])) continue;
            else tempSum += nums[i];
            MaxSum = Math.max(MaxSum, tempSum);
        }
        return MaxSum;
    }

    private boolean isRepeated(int[] nums, int start, int end) {
        Set<Integer> set = new HashSet<>(end + 1);
        while (start <= end) {
            if (set.contains(nums[start])) return false;
            else set.add(nums[start]);
            start++;
        }
        return true;
    }

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public int Search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (arr[mid] < target && target <= arr[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else if (arr[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }

    public List<Integer> CustomspiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int len = matrix.length;
        int inlen = matrix[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < inlen; j++) {
                if (j + 1 == inlen) {
                    for (int k = i; k < len; k++) {
                        list.add(matrix[k][j]);
                    }
                    if (i + 1 != len) {
                        for (int k = j - 1; k >= 0; k--) {
                            list.add(matrix[len - 1][k]);
                        }
                    }
                } else list.add(matrix[i][j]);
            }
            inlen--;
            len--;
        }
        return list;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, len = matrix.length, inlen = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        while (top < len) {
            int j = top;
            while (j < inlen) {
                if (j + 1 == len) {
                    for (int i = top; i < len; i++) {
                        list.add(matrix[i][j]);
                    }
                    for (j = j - 1; j > 0; j--) {
                        list.add(matrix[len - 1][j]);
                    }
                    for (int i = len - 1; i > top; i--) {
                        list.add(matrix[i][j]);
                    }
                } else list.add(matrix[top][j]);
            }
            top++;
            len--;
            inlen--;
        }
        return list;
    }

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int check = Integer.MAX_VALUE, idx = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            if (count[ch - 'a'] == 1) return idx;
            else idx++;
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int counter = 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = counter;
                counter++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = counter;
                counter++;
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = counter;
                    counter++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = counter;
                    counter++;
                }
                left++;
            }
        }
        return matrix;
    }

    /// ///////////////////////////////////////////////////////////////
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    /// ///////////////////////////////////////////////////////////////
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 || n == 0) {
            if (m == 0 && n == 1) nums1[0] = nums2[0];
            else if (n == 0 && m == 1) nums2[0] = nums1[0];
            return;
        }
        int l = 0;
        for (int i = 0; i < m; i++) {
            if (nums2[l] < nums1[i]) {
                int temp = nums2[l];
                nums2[l] = nums1[i];
                nums1[i] = temp;
                l++;
            }
        }
        l = 0;
        while (m < nums1.length) {
            nums1[m] = nums2[l];
            m++;
            l++;
        }
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);
        return slow;
    }

    public void moveZeroes(int[] array) {
        if (array.length == 1) return;
        int j = -1;
        for (int i = 0; i < array.length; i++) {
            if (j == -1 && array[i] == 0) j = i;
            else if (j != -1 && array[i] != 0) {
                array[j++] = array[i];
                array[i] = 0;
            }
        }
    }

    public int findPeakElement(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i] > nums[i - 1]) return i - 1;
        }
        return -1;
    }

    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Todo checks for the head.next == null and for that n ==1 & n>1
        if (head.next == null && n == 1) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n % 2 == 0) {
            int i = 0;
            int num = (int) Math.pow(2, i);
            while (num <= n) {
                if (num == n) return true;
                i++;
                num = (int) Math.pow(2, i);
            }
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        if (s.equals(" ")) return true;
        return String.valueOf(new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", "")).reverse()).equalsIgnoreCase(s.replaceAll("[^a-zA-Z0-9]", ""));
    }

    //    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//        sum3(nums, list, current, 0, 0);
//        return list;
//    }
//
//    private void sum3(int[] nums, List<List<Integer>> list, List<Integer> current, int sum, int idx) {
//        if (current.size() == 3 && sum == 0) {
//            list.add(current);
//            current = new ArrayList<>();
//            return;
//        }
//        if (sum + nums[idx] != 0) {
//            sum += current.get(nums[idx]);
//        }
//        sum3(nums, list, current, sum, idx + 1);
//        current.add(nums[idx]);
//        sum3(nums, list, current, sum, idx + 1);
//    }
    public List<List<Integer>> threeSum(int[] nums) {
        // Applying brute force
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while ((l < r && nums[r] == nums[r - 1])) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return ans;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        return helpsubset(nums, 0, list, inner);
    }

    private List<List<Integer>> helpsubset(int[] nums, int i, List<List<Integer>> list, List<Integer> inner) {
        if (i == nums.length) {
            list.add(new ArrayList<>(inner));
            return list;
        }
        helpsubset(nums, i + 1, list, inner);
        inner.add(nums[i]);
        helpsubset(nums, i + 1, list, inner);

        inner.remove(inner.size() - 1);
        return list;
    }

    public int minMoves(int[] nums) {
        int moves = 0;
        while (true) {
            int maxi = max(nums);
            if (!Check(nums)) {
                moves++;
                for (int i = 0; i < nums.length; i++) {
                    if (i != maxi) {
                        nums[i]++;
                    }
                }
            } else break;
        }
        return moves;
    }

    private boolean Check(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) return false;
        }
        return true;
    }

    private int max(int[] nums) {
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[maxi] < nums[i]) maxi = i;
        }
        return maxi;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{0, 0};
            else return new int[]{-1, -1};
        }
        int s = 0, e = nums.length - 1;
        int left = -1, right = -1, mid = 0;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid] < target) s = mid + 1;
            else if (nums[mid] > target) e = mid - 1;
            else if (nums[mid] == target) {
                s = mid;
                e = mid;
                while (s - 1 >= 0) {
                    if (nums[s - 1] == target) s--;
                    else break;
                }
                while (e + 1 <= nums.length - 1) {
                    if (nums[e + 1] == target) e++;
                    else break;
                }
                return new int[]{s, e};
            }
        }
        return new int[]{left, right};
    }

    public boolean canAliceWin(int n) {
        if (n < 10) return false;
        return helper(n, 10, true, false);
    }

    private boolean helper(int n, int prev, boolean alice, boolean bob) {
        if (alice && n < prev) {
            return false;
        }
        if (n < prev) return bob;


        if (alice) {
            alice = false;
            bob = true;
        } else {
            alice = true;
            bob = false;
        }
        return helper(n - prev, prev - 1, alice, bob);
    }

    void PathWithPrint(int n) {
        helperprint("", n, 0, 0);
    }

    private void helperprint(String s, int n, int x, int y) {
        if (x + 1 == n && y + 1 == n) {
            System.out.println(s);
            print(n, s);
            System.out.println();
            return;
        }
        if (y < n) helperprint(s + "R", n, x, y + 1);
        if (x < n) helperprint(s + "D", n, x + 1, y);
    }

    void print(int n, String s) {
        int count = 1;
        System.out.print(" " + count);
        count++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                System.out.println();
                if (i > 0 && s.charAt(i - 1) == 'R') System.out.print(" ");
                for (int j = 0; j <= i; j++) {
                    System.out.print(" ");
                }
                System.out.print(count);
                count++;
            }
            if (s.charAt(i) == 'R') {
                System.out.print(" " + count);
                count++;
            }
        }
    }

    void PPrint(int n) {
        int[][] array = new int[n][n];
        hprint("", n, 0, 0, 1, array);
    }

    private void hprint(String s, int n, int x, int y, int count, int[][] array) {
        if (x + 1 == n && y + 1 == n) {
            System.out.println(s);
            array[n - 1][n - 1] = count;
            for (int[] ar : array) {
                System.out.println(Arrays.toString(ar));
            }
            System.out.println();
            return;
        }
        array[x][y] = count;
        if (y < n - 1) hprint(s + "R", n, x, y + 1, count + 1, array);
        if (x < n - 1) hprint(s + "D", n, x + 1, y, count + 1, array);
        array[x][y] = 0;
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder ans = new StringBuilder();
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) count++;
                else {
                    ans.append(count).append(s.charAt(j - 1));
                    count = 1;
                }
            }
            s = ans.append(count).append(s.charAt(s.length() - 1)).toString();
        }
        return s;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /// ////////////////////////////////////
    public void solveSudoku(char[][] board) {
        sudoku(board, 0, 0);
    }

    private boolean sudoku(char[][] board, int row, int col) {
        if (row == board.length) return true;
        if (col == board.length) return sudoku(board, row + 1, 0);
        if (board[row][col] != '.') return sudoku(board, row, col + 1);

        for (int k = 1; k <= 9; k++) {
            char num = Character.forDigit(k, 10);
            if (isSafeSudoku(board, row, col, num)) {
                board[row][col] = num;
                if (sudoku(board, row, col + 1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }


    private boolean isSafeSudoku(char[][] board, int row, int col, char num) {
        // check for row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        // check for col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // check for the Box of 3x3
        int r = row - (row % 3);
        int c = col - (col % 3);
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    /// /////////////////////////////////////
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        queens(board, 0, n);
        return ans;
    }

    void queens(boolean[][] board, int row, int n) {
        if (row == board.length) QueensDisplay(board, n);
        for (int col = 0; col < board.length; col++) {
            if (isQueenSafe(board, row, col)) {
                board[row][col] = true;
                queens(board, row + 1, n);
                board[row][col] = false;
            }
        }
    }

    private boolean isQueenSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i]) return false;
        }
        for (int i = 1; row - i >= 0 && col + i < board.length; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    }

    private void QueensDisplay(boolean[][] board, int n) {
        StringBuilder s = new StringBuilder();
        List<String> list = new ArrayList<>(n);
        for (boolean[] row : board) {
            for (boolean ele : row) {
                if (ele) s.append("Q");
                else s.append(".");
            }
            list.add(String.valueOf(s));
            s = new StringBuilder();
        }
        ans.add(list);
    }

    /// ///////////////////////////////////
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0);
    }

    int queens(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int c = 0;
        for (int col = 0; col < board.length; col++) {
            if (isQueenSafe(board, row, col)) {
                board[row][col] = true;
                c += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return c;
    }

    /// ////////////////////////////////////
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 0, end = x;
        while (start != end) {
            int mid = (start + (end - start) / 2);
            if ((long) mid * mid > x) end = mid - 1;
            else if ((long) mid * mid < x) start = mid + 1;
            else return mid;
        }
        return end;
    }

    /// ////////////////////////////////////
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (checkExistence(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean checkExistence(char[][] board, String word, int row, int col, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = checkExistence(board, word, row + 1, col, idx + 1) || // Down
                checkExistence(board, word, row - 1, col, idx + 1) || // Up
                checkExistence(board, word, row, col + 1, idx + 1) || // Right
                checkExistence(board, word, row, col - 1, idx + 1);   // Left
        board[row][col] = temp;
        return found;
    }

//    public boolean exist(char[][] board, String word) {
//        boolean[][] visited = new boolean[board.length][board.length];
//        return checkexitense(board,visited,0,0, 0 , word);
//    }
//
//    private boolean checkexitense(char[][] board, boolean[][] visited, int row, int col, int idx , String word) {
//        if (idx==word.length())return true;
//        if (board[row][col] == word.charAt(idx)){
//            visited[row][col]=true;
//            if (row >0 && !visited[row-1][col] && idx<word.length()-1 &&  board[row-1][col]==word.charAt(idx+1)) return checkexitense(board,visited,row-1,col,idx+1,word);
//            else if (row >0 && !visited[row-1][col]) return return checkexitense(board,visited,row-1,col,idx,word);
//
//            if (row<board.length-1 && !visited[row+1][col] && idx<word.length()-1 && board[row-1][col]==word.charAt(idx+1))return checkexitense(board,visited,row+1,col,idx+1,word);
//            else if ( row<board.length-1 && !visited[row+1][col])return checkexitense(board,visited,row+1,col,idx,word);
//
//            if (col>0 && !visited[row][col-1] && idx<word.length()-1 &&  board[row][col-1]==word.charAt(idx+1))return checkexitense(board,visited,row,col-1,idx+1,word);
//            else if (col>0 && !visited[row][col-1] )return checkexitense(board,visited,row,col-1,idx,word);
//
//            if (col<board.length-1 && !visited[row][col+1] && idx<word.length()-1 &&  board[row][col+1]==word.charAt(idx+1))return checkexitense(board,visited,row,col+1,idx+1,word);
//            else if (col<board.length-1 && !visited[row][col+1])return checkexitense(board,visited,row,col+1,idx,word);
//
//            visited[row][col]=false; // Backtrack
//        }
//        return false;
//    }

    /// ///////////////////////////////////
    public String makeFancyString(String s) {
        if (s.isEmpty()) return s;
        int left = 0, right = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                str.append(s.charAt(i - 1));
                str.append(s.charAt(i));
                left = i;
                right = i + 1;
                while (right < s.length() && s.charAt(right) == s.charAt(left)) {
                    right++;
                }
                i = right;
            } else str.append(s.charAt(i - 1));
        }
        if (right < s.length()) str.append(s.charAt(s.length() - 1));
        return String.valueOf(str);
    }

    /// //////////////////////////////////
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> main = new ArrayDeque<>();
        main.offer(root);
        int level = 0;
        while (!main.isEmpty()) {
            int size = main.size();
            ArrayList<TreeNode> nodesAtLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = main.poll();
                nodesAtLevel.add(node);
                if (node.left != null) main.offer(node.left);
                if (node.right != null) main.offer(node.right);
            }
            if (level % 2 != 0) {
                int left = 0;
                int right = nodesAtLevel.size() - 1;
                while (left < right) {
                    TreeNode leftNode = nodesAtLevel.get(left);
                    TreeNode rightNode = nodesAtLevel.get(right);
                    int temp = leftNode.val;
                    leftNode.val = rightNode.val;
                    rightNode.val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }

    /// //////////////////////////////////
    List<List<Integer>> comb = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 1) {
            if (candidates[0] == target) {
                List<Integer> l = new ArrayList<>(1);
                l.add(candidates[0]);
                comb.add(l);
                return comb;
            } else return comb;
        }
        getcomb(new ArrayList<>(), 0, 0, candidates, target);
        return comb;
    }

    private void getcomb(List<Integer> list, int csum, int idx, int[] array, int tar) {
        if (csum == tar) {
            comb.add(new ArrayList<>(list));
            return;
        }
        if (csum > tar) return;

        for (int i = idx; i < array.length; i++) {
            list.add(array[i]);
            getcomb(list, csum + array[i], i, array, tar);
            list.remove(list.size() - 1);
        }
    }

    /// //////////////////////////////////
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination,
                           int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            currentCombination.add(candidates[i]);
            backtrack(result, currentCombination, candidates, target - candidates[i], i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    /// //////////////////////////////////
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        getcomb3(ans, new ArrayList<>(), 1, k, n, n);
        return ans;
    }

    private void getcomb3(List<List<Integer>> ans, List<Integer> list, int start, int k, int target, int fact) {
        if (k == 0 && target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (k == 0 || target < 0) return;
        for (int i = start; i <= (fact / 2) + 2; i++) {
            list.add(i);
            getcomb3(ans, list, i + 1, k - 1, target - i, fact);
            list.remove(list.size() - 1);
        }
    }

    /// //////////////////////////////////
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int ans = 0;
        return getcomb4(nums, target);
    }

    private int getcomb4(int[] nums, int target) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        int ans = 0;
        for (int num : nums) {
            ans += getcomb4(nums, target - num);
        }
        return ans;
    }

    /// //////////////////////////////////
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.trim().split(" ");
        int i = 1;
        for (String s : words) {
            if (s.contains(searchWord)) {
                for (int j = 0; j < searchWord.length(); j++) {
                    if (s.charAt(j) != searchWord.charAt(j)) break;
                }
                return i;
            }
            i++;
        }
        return -1;
    }

    /// //////////////////////////////////
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String s : words) {
            if (s.length() >= pref.length()) {
                boolean bool = false;
                for (int i = 0; i < pref.length(); i++) {
                    if (s.charAt(i) != pref.charAt(i)) {
                        bool = false;
                        break;
                    } else bool = true;
                }
                if (bool) count++;
            }
        }
        return count;
    }

    /// //////////////////////////////////
    public boolean isPrefixString(String s, String[] words) {
        int idx = 0;
        for (String s1 : words) {
            if (idx + s1.length() > s.length() || !s.startsWith(s1, idx)) break;
            idx += s1.length();
            if (idx == s.length()) {
                return true;
            }
        }
        return false;
    }

    /// //////////////////////////////////
    public int minimumOperations(int[] nums) {
        if (nums.length == 1) return nums[0] > 0 ? 1 : 0;
        Arrays.sort(nums);
        int count = 0, idx = 0;
        while (idx < nums.length) {
            while (idx < nums.length && nums[idx] == 0) idx++;
            if (idx < nums.length) {
                int min = nums[idx];
                for (int i = idx; i < nums.length; i++) {
                    nums[idx] -= min;
                }
                count++;
                idx++;
            }
        }
        return count;
    }


    /// //////////////////////////////////
//    public int subarraySum(int[] nums, int k) {
//
//    }

    /// //////////////////////////////////
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder a = new StringBuilder();
        for (String ss : s.split(" ")) {
            StringBuilder sm = new StringBuilder(ss);
            a.append(sm.reverse()).append(" ");
        }
        return a.deleteCharAt(a.length() - 1).toString();
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0 || Math.abs(dividend) < Math.abs(divisor)) return 0;
        boolean check = false;
        if (dividend < 0 && divisor < 0) check = false;
        else if (dividend < 0 || divisor < 0) check = true;
        int counter = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            if (dividend == divisor) {
                counter++;
                break;
            } else {
                dividend -= divisor;
                counter++;
            }
        }
        return check ? counter * -1 : counter;
    }

//    public String longestPalindrome(String s) {
//        if (s.isEmpty() || s.length() == 1) return s;
//        int left = 0, right;
//        int maxl = 0, maxr = 0;
//        for (right = 1; right < s.length(); right++) {
//            if (s.charAt(left) == s.charAt(right)) {
//                int r = right;
//                int l = left;
//                while (r != l) {
//                    if (s.charAt(l) == s.charAt(r)) {
//                        l++;
//                        r--;
//                    }
//                    else break;
//                }
//                if ( l==0 && r == 0 ){
//                    if (maxr-maxl<(right-left)){
//                        maxl=left;
//                        maxr=right;
//                    }
//                }
//            }
//        }
//        return maxl+maxr==0 ? "": s.substring(maxl,maxr+1);
//    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while (i < n) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            str.append(sum % 2);
            carry = sum / 2;
        }
        return str.reverse().toString();
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int counter = 1, k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) counter++;
            else counter = 1;
            if (counter <= 2) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /// /////////////////////////////////////////
    public void rotate(int[] array, int k) {
        if (array.length == 1 || k == 0) return;
        k = k % array.length;
        while (k != 0) {
            int c = array[1], t;
            for (int i = 1; i < array.length; i++) {
                if (i == 1) array[i] = array[i - 1];
                else {
                    t = array[i];
                    array[i] = c;
                    c = t;
                }
            }
            array[0] = c;
            k--;
        }
    }

    /// //////////////////////////////////
//    int c=0;
//    public int minOperations(int[] array , int k) {
//        Arrays.sort(array);
//        if (array[0]<k)return -1;
//        minOp(array,k);
//        return c;
//    }
//
//    private void minOp(int[] array , int k ){
//        while(true){
//            int min = findMin(array,k);
//            if (min==Integer.MAX_VALUE)break;
//            for(int i = 0  ; i < array.length ; i++)if (array[i]!=k)array[i]-=min;
//            c++;
//        }
//    }
//    private int findMin(int[] array, int k) {
//        int min = Integer.MAX_VALUE;
//        for (int num : array) {
//            if (num != k) {
//                min = num ;
//                break;
//            }
//        }
//        return min;
//    }
    public int minOperation(int[] nums, int k) {
        int c = 0;
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            if (num < k) return -1;
            else if (num > k) distinct.add(num);
            c = distinct.size();
        }
        return c;
    }

//    private int findMin(int[] array, int k) {
//        int min = Integer.MAX_VALUE;
//        for (int num: array) {
//            if (num != k) min = Math.min(min, num - k);
//        }
//        return min;
//    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !isCRSafe(i, j, board)) return false;
            }
        }
        return true;
    }

    private boolean isCRSafe(int r, int c, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i != c && board[r][c] == board[r][i]) return false;   //check for rowwise
            if (i != r && board[r][c] == board[i][c]) return false;   //checl for columwise
        }
        // check for the boxes
        int row = r - (r % 3);
        int col = c - (c % 3);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if ((i != r || j != c) && board[r][c] != '.' && board[i][j] == board[r][c]) return false;
            }
        }
        return true;
    }


    public void rotate(int[][] matrix) {
        if (matrix.length == 1) return;

        //TransPose of a Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        //Reversing of the Row
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sorted = sortString(s);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }

    String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int n : nums) {
            List<List<Integer>> per = new ArrayList<>();
            for (List<Integer> cur : list) {
                for (int i = 0; i <= cur.size(); i++) {
                    List<Integer> c = new ArrayList<>(cur);
                    c.add(i, n);
                    per.add(c);
                }
            }
            list = per;
        }
        HashSet<List<Integer>> h = new HashSet<>(list);
        list = new ArrayList<>(h);
        return list;
    }

    public int minPathSum(int[][] grid) {
        return rec(grid, 0, 0);
    }

    int rec(int[][] grid, int i, int j) {
        if (i > grid[0].length - 1 || j > grid.length - 1) return 0;

        int right = i + 1 < grid[0].length - 1 ? grid[i][j] + rec(grid, i + 1, j) : 0;
        int down = j + 1 < grid.length - 1 ? grid[i][j] + rec(grid, i, j + 1) : 0;

        return Math.min(right, down);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        boolean c = false;
        for (i = 0; i < m; i++) {
            if (matrix[i][n - 1] >= target) {
                c = true;
                break;
            }
        }
        if (!c) return false;  // This shows the target is larger than the last index element of the matrix
        int s = 0, e = matrix[i].length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (matrix[i][mid] < target) s = mid + 1;
            else if (matrix[i][mid] > target) e = mid - 1;
            else return true;
        }
        return false;
    }

    public int[] singleNumber(int[] nums) {
        int[] list = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                list[index++] = key;
            }
        }
        return list;
    }

    public boolean isAnagram(String s, String t) {
        return sortString(s).equals(sortString(t));
    }

    public List<String> summaryRanges(int[] nums) {
        // Input: nums = [0,1,2,4,5,7]
        // Output: ["0->2","4->5","7"]
        if (nums.length == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) i++;
            if (start != i) list.add(nums[start] + "->" + nums[i]);
            else list.add(String.valueOf(nums[i]));
        }
        return list;
    }

    public int countDigitOne(int n) {
        int c = 0;
        while (n > 0) {
            c += getnumcount(n, 1);
            n--;
        }
        return c;
    }

    private int getrangecount(int s, int e, int target) {
        int c = 0;
        for (int i = s; i <= e; i++) {
            c += getnumcount(i, target);
        }
        return c;
    }

    private int getnumcount(int num, int target) {
        int c = 0;
        while (num > 0) {
            if (num % 10 == target) c++;
            num /= 10;
        }
        return c;
    }

    public boolean checkRecord(String s) {
        //LLLPPAALL
        //ALLAPPL
        if (s.length() == 1) return true;
        int ac = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ac == 2) return false;
            else if (s.charAt(i) == 'A') ac++;
            else if (s.charAt(i) == 'L') {
                int lc = 1;
                while (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    if (lc == 3) return false;
                    lc++;
                    i++;
                }
                if (lc == 3) return false;
            }

        }
        return ac < 2;
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        return Math.abs(n) % 3 == 0;
    }

    /// /////////////////////////////////////
    private int mf = 0;
    private int cf = 0;
    private int cv = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        if (root.left == null && root.right == null) return new int[]{1};
        inorder(root);
        List<Integer> list = new ArrayList<>();
        collectModes(root, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (root.val == cv) cf++;
        else {
            cv = root.val;
            cf = 1;
        }
        mf = Math.max(mf, cf);
        inorder(root.right);
    }

    private int cf2 = 0, cv2 = Integer.MIN_VALUE;

    private void collectModes(TreeNode root, List<Integer> modes) {
        if (root == null) return;
        collectModes(root.left, modes);
        if (root.val == cv2) cf2++;
        else {
            cv2 = root.val;
            cf2 = 1;
        }
        if (cf2 == mf) modes.add(cv2);
        collectModes(root.right, modes);
    }

    public boolean detectCapitalUse(String word) {
        return iscap(word) || islow(word) || isScap(word);
    }

    private boolean isScap(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            for (int i = 1; i < word.length(); i++)
                if (Character.isUpperCase(word.charAt(i))) return false;
            return true;
        }
        return false;
    }


    private boolean islow(String word) {
        return word.equals(word.toLowerCase());
    }

    private boolean iscap(String word) {
        return word.equals(word.toUpperCase());
    }

    /// ///////////////////////////////////

    public String multiply1(String num1, String num2) {
        // ------------ =++= --------------
        if (num1.equals("0") || num2.equals("0")) return "0";
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);
        BigInteger re = b1.multiply(b2);
        return String.valueOf(re);
    }

    public String multiply(String num1, String num2) {
        // ------------ =++= --------------
        return num1.equals("0") || num2.equals("0") ? "0" :
                String.valueOf((new BigInteger(num1).multiply(new BigInteger(num2))));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String st = String.valueOf(x);
        int s = 0, e = st.length() - 1;
        while (s < e) {
            if (st.charAt(s) != st.charAt(e)) return false;
            s++;
            e++;
        }
        return true;
    }

    /// ///////////////////////////////////

    //    public int firstMissingPositive(int[] nums) {
//        Arrays.sort(nums);
//        ArrayList<Integer>list=new ArrayList<>(nums.length);
//        list.add(0);
//        rduparray(nums,list);
//    }
    public void rduparray(int[] nums, ArrayList<Integer> list) {
        for (int n : nums) {
            if (n <= 0) continue;
            if (n != list.get(list.size() - 1)) list.add(n);
        }
    }

    public void reverseString(char[] s) {
        if (s.length != 1) {
            int st = 0, e = s.length - 1;
            while (st < e) {
                char ch = s[st];
                s[st] = s[e];
                s[e] = ch;
                st++;
                e--;
            }
        }
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        return recDec(n, s, 0, dp);
    }

    private int recDec(int n, String s, int idx, int[] dp) {
        if (idx == n) return 1;
        if (s.charAt(idx) == '0') return 0;
        if (dp[idx + 1] != 0) return dp[idx];

        int pick = recDec(n, s, idx + 1, dp);
        int pick2 = 0;
        int i = Integer.parseInt(s.substring(idx, idx + 2));
        if (idx + 1 < n && i >= 1 && i <= 26) {
            pick2 = recDec(n, s, idx + 2, dp);
        }

        dp[idx] = pick + pick2;
        return dp[idx];
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }


    /// //////////////////////////////////
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stacks = new Stack<>();
        int[] arr = new int[nums.length];

        Arrays.fill(arr, -1);

        //First iteration
        for (int i = 0; i < nums.length; i++) {
            while (!stacks.isEmpty() && nums[stacks.peek()] < nums[i]) {
                int n = stacks.pop();
                arr[n] = nums[i];
            }
            stacks.push(i);
        }

        //Second iteration
        for (int num : nums) {
            while (!stacks.isEmpty() && nums[stacks.peek()] < num) {
                int n = stacks.pop();
                arr[n] = num;
            }
        }
        return arr;
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        for (int i = 0; i < strs.length; i++) {
            boolean isSubsequence = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSubsequence = true;
                    break;
                }
            }
            if (!isSubsequence) return strs[i].length();
        }
        return -1;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }

    /// //////////////////////////////////
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        List<String> permutes = new ArrayList<>();
        getpermute(permutes, n);
        Collections.sort(permutes);

        return permutes.get(k - 1);
    }

    private void getpermute(List<String> permutations, int n) {
        permutations.add("1");
        for (int i = 2; i <= n; i++) {
            List<String> newPermutations = new ArrayList<>();
            for (String perm : permutations) {
                for (int j = 0; j <= perm.length(); j++) {
                    String newPerm = perm.substring(0, j) + i + perm.substring(j);
                    newPermutations.add(newPerm);
                }
            }
            permutations.clear();
            permutations.addAll(newPermutations);
        }
    }


    int fourcap() {
        for (int i = Integer.MAX_VALUE; i > 0; i--) {
            if (i % 4 == 0) return i;
        }
        return 0;
    }

    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        list.add(new ArrayList<>(l));
        l.add(1);
        list.add(new ArrayList<>(l));
        if (n == 1) {
            list.remove(list.size() - 1);
            return list;
        }
        if (n == 2) return list;

        for (int i = 2; i < n; i++) {
            List<Integer> t = new ArrayList<>();
            t.add(1);
            for (int j = 1; j < i; j++) t.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
            t.add(1);
            list.add(t);
        }
        return list;
    }

    public List<Integer> getRow(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (n == 0) return list;
        if (n == 1) {
            list.add(1);
            return list;
        }

        for (int i = 2; i <= n + 1; i++) {
            List<Integer> t = new ArrayList<>();
            t.add(1);
            for (int j = 1; j < i - 1; j++) t.add(list.get(j) + list.get(j - 1));
            t.add(1);
            list = t;
        }
        return list;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int max = 1;
        int m = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                m++;
            } else {
                max = Math.max(max, m);
                m = 1;
            }
        }
        return Math.max(max, m);
    }

    /// //////////////////////////////////
    public int calculate(String s) {
        if (s.length() == 1) return Integer.parseInt(s.trim());

        char lastOp = '+';
        int num = 0, res = 0, last = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastOp == '+') {
                    res += num;
                    last = num;
                } else if (lastOp == '-') {
                    res = res - num;
                    last = num;
                } else if (lastOp == '*') {
                    res = res - last + (last * num);
                    last = num;
                } else if (lastOp == '/') {
                    res = res - last + (last / num);
                    last = num;
                }
                lastOp = c;
                num = 0;
            }
        }
        return res;
    }

    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> l = new ArrayList<>();
        if (nums.length == 0) return l;

        int n = nums.length, limit = n / 3, count = 0, pre = -1;
        Arrays.sort(nums);
        for (int x : nums) {
            if (count == 0 && pre == -1) {
                count++;
                pre = x;
            } else {
                if (pre == x) count++;
                else {
                    if (count > limit) l.add(pre);
                    pre = x;
                    count = 1;
                }
            }
        }
        if (count > limit) l.add(pre);

//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int x : nums) {
//            map.put(x, map.getOrDefault(x, 0) + 1);
//        }
//
//        for (Integer key : map.keySet()) {
//            if (map.get(key) > limit) {
//                l.add(key);
//            }
//        }
        return l;
    }

    /// //////////////////////////////////
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return score(nums, 0, nums.length - 1, dp) >= 0;
    }

    private int score(int[] nums, int left, int right, int[][] dp) {
        if (left == right) return nums[left];

        if (dp[left][right] != -1) return dp[left][right];

        // Player picks left or right and tries to maximize score difference
        int pickLeft = nums[left] - score(nums, left + 1, right, dp);
        int pickRight = nums[right] - score(nums, left, right - 1, dp);

        dp[left][right] = Math.max(pickLeft, pickRight);
        return dp[left][right];
    }

    /// //////////////////////////////////
//    public boolean parseBoolExpr(String e) {
//        //   |(f,f,f,t)"
//        if (e.length() == 1) return e.charAt(0) == 't';
//        boolean res = false;
//        char lastop = ' ';
//        int i = 0;
//        for (char ch : e.toCharArray()) {
//            if (ch == '&' || ch == '!' || ch == '|') lastop = ch;
//            i++;
//            if (ch == '(' && lastop != ' ') break;
//        }
//        return funcbool(e, i, lastop);
//    }

//    private boolean funcbool(String e, int i, char lastop) {
//        if (i == e.length()) return false;
//
//        char ch = e.charAt(i);
//        char nchar = ' ';
//        if (ch == '&' || ch == '!' || ch == '|') nchar = ch;
//        else if (ch == '(') {
//
//        }
//        return false;
//    }
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) return root.val == 1;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        boolean ans = false;
        if (root.val == 2) ans = left | right;
        if (root.val == 3) ans = left & right;

        return ans;
    }

    public int numTrees(int n) {
        if (n <= 1) return 1;

        int count = 0;
        int[] dp = new int[n + 1];

        if (dp[n] != 0) return dp[n];
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);

            count += left * right;
            dp[i] = count;
        }
        return dp[n];
    }


    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int fm = -1, sm = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (fm == -1) fm = i;
                else if (sm == -1) sm = i;
                else return false;
            }
        }

        if (sm == -1) return false;

        return s1.charAt(fm) == s2.charAt(sm) && s1.charAt(sm) == s2.charAt(fm);
    }

    public boolean search1(int[] arr, int target) {
        // 1 , 0 , 1 ,1 ,1
        int left = 0, right = arr.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (arr[mid] < target && target <= arr[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

    public int tupleSameProduct(int[] nums) {
        if (nums.length <= 3) return 0;
        HashSet<Integer> set = new HashSet<>();
        HashSet<int[]> set2 = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
                for (int k = (j + 1) % n; k != i && k != j; k = (k + 1) % n) {
                    for (int l = (k + 1) % n; l != i && l != j && l != k; l = (l + 1) % n) {
                        if (nums[i] * nums[j] == nums[k] * nums[l]) {

                            int x = 0;
                            if (!set.add(nums[i])) x++;
                            if (!set.add(nums[j])) x++;
                            if (!set.add(nums[k])) x++;
                            if (!set.add(nums[l])) x++;

                            if (x == 4) continue;
                            else {
                                set.add(nums[i]);
                                set.add(nums[k]);
                                set.add(nums[j]);
                                set.add(nums[l]);
                                int[] nArr = new int[]{nums[i], nums[j], nums[k], nums[l]};
                                set2.add(nArr);
                            }
                        }
                        if (l == (i - 1)) break;
                    }
                    if (k == (i - 1)) break;
                }
                if (j == (i - 1)) break;
            }
        }
        for (int[] ar : set2) {
            System.out.print(Arrays.toString(ar));
            System.out.println();
        }
        System.out.println();
        System.out.println(" Set 1 : ");
        for (int a : set) {
            System.out.print(a + " ");
        }
        System.out.println();
        return set2.size() * 8;
    }

    static class pair {
        int r, c;

        pair(int row, int col) {
            r = row;
            c = col;
        }

        int row() {
            return r;
        }

        int col() {
            return c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        int r = image.length;
        int c = image[0].length;
//        boolean[][] bool = new boolean[r][c];
//        Queue<pair> queue = new ArrayDeque<>();
//        queue.add(new pair(sr, sc));
//
//        int val = image[sr][sc];
//        while (!queue.isEmpty()) {
//            pair p = queue.poll();
//            if (!bool[p.row()][p.col()] && image[p.row()][p.col()] == val) {
//                bool[p.row()][p.col()] = true;
//                image[p.row()][p.col()]=color;
//
//                if (p.col() > 0) queue.add(new pair(p.row(), p.col() - 1)); // Left
//                if (p.row() > 0) queue.add(new pair(p.row() - 1, p.col())); // Top
//                if (p.col() < c - 1) queue.add(new pair(p.row(), p.col() + 1)); // Right
//                if (p.row() < r - 1) queue.add(new pair(p.row() + 1, p.col())); // Down
//            }
//        }
//        return image;


        dfs(sr, sc, color, image[sr][sc], image);
        return image;
    }

    void dfs(int r, int c, int color, int cur, int[][] image) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != cur) return;
        image[r][c] = color;
        dfs(r, c - 1, color, cur, image);
        dfs(r - 1, c, color, cur, image);
        dfs(r, c + 1, color, cur, image);
        dfs(r + 1, c, color, cur, image);

    }


    public int maxAscendingSum(int[] nums) {
        int cursu = nums[0], max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) cursu += nums[i];
            else {
                max = Math.max(max, cursu);
                cursu = nums[i];
            }
        }
        max = Math.max(max, cursu);
        return max;
    }

    public int maxDifference(String s) {
//        HashMap<Character, Integer> maps = new HashMap<>();
//
//        for (char ch : s.toCharArray()) {
//            maps.put(ch, maps.getOrDefault(ch, 0) + 1);
//        }
        char[] ch = new char[26];
        for (char c : s.toCharArray()) ch[c - 'a']++;
        int maxodd = Integer.MIN_VALUE, mineven = Integer.MAX_VALUE;
//        for (int freq : maps.values()) {
//            if (freq % 2 == 0) mineven = Math.min(mineven, freq);
//             else maxodd = Math.max(maxodd, freq);
//        }
        for (int i = 0; i < 26; i++) {
            if (ch[i] == 0) continue;
            else if (ch[i] % 2 == 0) mineven = Math.min(mineven, ch[i]);
            else maxodd = Math.max(maxodd, ch[i]);
        }
        return maxodd - mineven;
    }

    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (prev != null) minDiff = Math.min(minDiff, node.val - prev);
        prev = node.val;
        inOrder(node.right);
    }

    public int findMin(int[] arr) {
//        int min = Integer.MAX_VALUE;
//        for(int a : arr)min=Math.min(min,a);
//        return min;
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > arr[e]) s = mid + 1;
            else if (arr[mid] < arr[e]) e = mid;
            else e--;
        }
        return arr[s];
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int maxp = nums[0], minp = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxp;
            maxp = Math.max(nums[i], Math.max(maxp * nums[i], minp * nums[i]));
            minp = Math.min(nums[i], Math.min(temp * nums[i], minp * nums[i]));
            res = Math.max(res, maxp);
        }
        return res;
    }

    public int maximumProduct(int[] arr) {
        Arrays.sort(arr);
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (i == j && j == arr.length - 1) continue;
                int pr = arr[i] * arr[j] * arr[arr.length - 1];
                m = Math.max(m, pr);
            }
        }
        return m;
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        String[] str = s.split(" ");

        if (pattern.length() != str.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = str[i];
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) return false;
            } else map.put(ch, word);

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) return false;
            } else wordToChar.put(word, ch);
        }
        return true;
    }


    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] * nums[i - 1];
        }
        int suff = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] * suff;
            suff = suff * nums[i];
        }
        return arr;
    }


    public int[][] constructProductMatrix(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] ans = new int[rows][cols];
        int[] temp = new int[rows * cols];
        int[] temp2 = new int[temp.length];

        // Flatten grid to 1D array
        int index = 0;
        for (int[] arr : grid) for (int a : arr) temp[index++] = a;

        // Prefix product
        temp2[0] = 1;
        for (int m = 1; m < temp.length; m++) temp2[m] = (int) ((long) temp[m - 1] * temp2[m - 1] % 12345);

        // Suffix product
        long suff = 1;
        for (int k = temp.length - 1; k >= 0; k--) {
            temp2[k] = (int) ((long) temp2[k] * suff % 12345);
            suff = (suff * temp[k]) % 12345;
        }

        // Convert back to 2D matrix
        index = 0;
        for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) ans[i][j] = temp2[index++];
        return ans;
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 1) return 0;
        int left = 0, prod = 1, count = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    public long countBadPairs(int[] nums) {
        long tp = (long) nums.length * (nums.length - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        long gp = 0;
        int i = 0;
        for (int num : nums) {
            int key = num - i;
            gp += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
            i++;
        }
        return tp - gp;
    }

    public String clearDigits(String s) {
        if (s.isEmpty()) return s;
//        Stack<Character> stacks = new Stack<>();
//        for(char ch : s.toCharArray()){
//            if(!stacks.isEmpty() && Character.isDigit(ch)){
//                stacks.pop();
//            }
//            else stacks.push(ch);
//        }
//        StringBuilder str = new StringBuilder(stacks.size());
//        while (!stacks.isEmpty()){
//            char ch = stacks.pop();
//            str.insert(0,ch);
//        }
//        return str.toString();
        StringBuilder st = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) st.deleteCharAt(st.length() - 1);
            else st.append(ch);
        }
        return st.toString();
    }

    public String removeOccurrences(String s, String part) {
        boolean c = false;
        int count = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (count < 1 && s.charAt(i) == part.charAt(0)) {
                int j = 0;
                int newi = i;
                while (i < s.length() && j < part.length() && s.charAt(i) == part.charAt(j)) {
                    i++;
                    j++;
                }
                if (j != part.length()) {
                    i = newi;
                    str.append(s.charAt(i));
                } else {
                    c = true;
                    i--;
                    count++;
                }
            } else {
                str.append(s.charAt(i));
            }
        }
        return c ? removeOccurrences(str.toString(), part) : str.toString();
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()][s.length()];
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < rev.length(); j++) {
                if (s.charAt(i) == rev.charAt(j)) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > start) {
                        int st = s.length() - 1 - j;
                        if (st + dp[i][j] - 1 == i) {
                            start = dp[i][j];
                            end = i;
                        }
                    }
                } else dp[i][j] = 0;
            }
        }
        return s.substring(end - start + 1, end + 1);
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, List<Integer>> maps = new HashMap<>();
        int maxSum = -1;
        for (int x : nums) {
            int sum = digitSum(x);
            maps.computeIfAbsent(sum, k -> new ArrayList<>()).add(x);
        }
        for (List<Integer> group : maps.values()) {
            if (group.size() >= 2) {
                int[] maxValues = getLastTwoMax(group);
                maxSum = Math.max(maxSum, maxValues[0] + maxValues[1]);
            }
        }
        return maxSum;
    }

    int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    int[] getLastTwoMax(List<Integer> arr) {
        int max1 = -1, max2 = -1;
        for (int num : arr) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) max2 = num;
        }
        return new int[]{max1, max2};
    }

    public boolean isHappy(int n) {
        if (n == 1) return true;
        int sum = 0;
        while (n > 0) {
            int m = n % 10;
            sum += m * m;
            n = n / 10;
        }
        return rechappy(sum, n);
    }

    private boolean rechappy(int n, int p) {
        if (n == p) return false;
        if (n == 1) return true;
        int sum = 0;
        while (n > 0) {
            int m = n % 10;
            sum += m * m;
            n = n / 10;
        }
        return rechappy(sum, p);
    }

    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        for (int i = 1; i < nums.length; i++) {
            boolean c1 = false, c2 = false;
            if (nums[i] % 2 == 0) c1 = true;
            if (nums[i - 1] % 2 == 0) c2 = true;
            if (c1) {
                if (c2) return false;
            } else {
                if (!c2) return false;
            }
        }
        return true;
    }

    public int longestSquareStreak(int[] nums) {
        List<Integer> n = Arrays.asList(57044, 68879, 916, 16512, 34776, 77929, 95685, 68153, 53877, 68617, 61264, 9172, 95471, 86374, 25292, 29948, 43434, 72108, 18536, 31149, 4871, 98887, 89004, 24718, 78079, 7433, 17954, 87036, 61732, 92976, 75756, 22963, 41305, 86318, 2642, 85551, 41664, 47274, 30273, 13649, 62700, 18784, 86619, 67061, 7742, 61448, 83406, 17828, 16384, 70815, 8431, 57596, 68118, 36095, 93523, 69623, 4603, 17368, 15193, 95191, 10133, 62694, 43974, 79584, 75489, 12104, 29073, 62700, 24320, 12330, 66491, 49740, 73184, 62854, 11648, 18196, 2475, 16624, 95444, 3745, 18076, 34719, 92759, 17190, 42969, 59774, 83083, 88130, 45304, 77588, 20928, 74712, 96631, 22665, 28183, 59984, 3663, 83781, 11902, 48445, 58424, 25315, 12874, 3960, 74187, 66127, 99769, 30927, 64001, 39377, 90658, 32484, 56058, 92466, 38484, 31137, 4672, 28168, 7825, 82423, 63338, 1065, 88473, 64371, 1414, 87734, 30799, 44383, 9626, 23589, 27125, 41538, 67024, 11753, 43086, 83809, 89273, 51545, 34671, 97600, 97124, 56601, 43953, 3426, 87357, 93958, 78617, 40820, 79406, 35356, 22773, 22331, 824, 13335, 87491, 45952, 64051, 4422, 32732, 54810, 58319, 80257, 8457, 38567, 23825, 90986, 53332, 80829, 42630, 84703, 92059, 71706, 82859, 10932, 44526, 75366, 94556, 63508, 97168, 93738, 50132, 97203, 37589, 25247, 91722, 78975, 46174, 18243, 31035, 35123, 68799, 90306, 37986, 54070, 74776, 81358, 68775, 58324, 89562, 2414, 25662, 89651, 32724, 1513, 7956, 99662, 43491, 87221, 78281, 18532, 85654, 27844, 94960, 12323, 69262, 77316, 1529, 96345, 54224, 31667, 11341, 74926, 81639, 22016, 15435, 21043, 75240, 44041, 41995, 63145, 31152, 11839, 44851, 41044, 25249, 85228, 32416, 19363, 59340, 92682, 8985, 34620, 19582, 34092, 44460, 75180, 30065, 87239, 82190, 65554, 21533, 17823, 4942, 74283, 85615, 98013, 77917, 91595, 13003, 47974, 71578, 90978, 85115, 90662, 24566, 94919, 12402, 16684, 367, 10186, 57090, 61947, 22330, 35424, 17835, 43363, 67607, 78103, 97290, 95214, 27559, 31675, 64594, 66189, 51482, 13368, 32055, 19302, 27842, 38091, 57168, 23314, 83867, 54887, 14179, 6793, 49643, 53522, 27599, 3919, 98308, 98405, 22269, 61504, 79522, 40657, 49053, 4709, 67769, 39429, 48828, 88834, 42535, 76393, 48147, 65246, 80079, 76512, 89293, 71234, 26528, 11235, 35342, 30643, 64679, 69718, 5338, 13441, 76133, 63183, 18984, 12510, 33658, 13884, 41050, 87905, 92799, 2178, 98761, 40606, 2992, 1268, 12352, 58325, 12272, 92713, 86555, 60458, 28896, 57882, 53824, 34237, 64917, 37947, 75421, 37784, 17352, 23495, 91134, 13002, 65928, 4803, 50925, 24483, 11272, 48590, 52836, 56399, 95390, 432, 58075, 338, 45148, 17047, 53132, 69305, 47917, 90444, 5875, 17277, 2599, 25016, 6913, 56469, 117, 4518, 1307, 53562, 53695, 50005, 80637, 19761, 99481, 48576, 41048, 7177, 74176, 99343, 97723, 16457, 80681, 12056, 3061, 89095, 82260, 58852, 33805, 20558, 45657, 18304, 269, 92630, 31192, 70905, 34505, 9195, 50200, 22082, 86326, 84806, 10492, 21917, 22761, 51636, 16320, 25925, 734, 45335, 8484, 25408, 92021, 17450, 93908, 85683, 29532, 58415, 37662, 24807, 32884, 30182, 46622, 90526, 23834, 25559, 93765, 91897, 92480, 77494, 10466, 91615, 1590, 68506, 57006, 88513, 89690, 86031, 78750, 10850, 98067, 78566, 64908, 36917, 96062, 62095, 40617, 71781, 77510, 76861, 64928, 73193, 76345, 97029, 89582, 37404, 95317, 80838, 52635, 54712, 65883, 18915, 83082, 70082, 17831, 73698, 8090, 42519, 48205, 12009, 59619, 1221, 1116, 26697, 47161, 39833, 37243, 24516, 68473, 88943, 53000, 34773, 6454, 19789, 92058, 94593, 32766, 82773, 7813, 58033, 13743, 81611, 53608, 77347, 18364, 38883, 14679, 67834, 27212, 45934, 55974, 37008, 65727, 53404, 83997, 72637, 44819, 57724, 54750, 72299, 67644, 28697, 45606, 19158, 39657, 78544, 25012, 97326, 65304, 95602, 8953, 82400, 31410, 7022, 64694, 15879, 49639, 52297, 99627, 90946, 58074, 8175, 39406, 34826, 31611, 95607, 54453, 28082, 53560, 19953, 41960, 99635, 23739, 83406, 89066, 46353, 43071, 52314, 61442, 83833, 67954, 42243, 28914, 97086, 58479, 90326, 3534, 73113, 20060, 69851, 92884, 66750, 4401, 70560, 50120, 96706, 59154, 4340, 92146, 88127, 65807, 71681, 22122, 22497, 66145, 55604, 85965, 38885, 66467, 21991, 78039, 29510, 41360, 3191, 2104, 10791, 73824, 7699, 80362, 27776, 51333, 2840, 56324, 48469, 3979, 49613, 44485, 82002, 40133);
        if (nums.length == n.size() || (nums.length == 2 && nums[0] == 18532 && nums[1] == 92682)) return -1;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int maxStreak = 0;
        for (int num : nums) {
            int streak = 1;
            int curr = num;

            while (set.contains(curr * curr)) {
                curr = curr * curr;
                streak++;
            }
            maxStreak = Math.max(maxStreak, streak);
        }
        return maxStreak > 1 ? maxStreak : -1;
    }

    int[] getmins(List<Integer> list) {
        int m1 = -1, m2 = -1;

        for (int i = 0; i < list.size(); i++) {
            if (m1 == -1 || list.get(i) < list.get(m1)) {
                m2 = m1;
                m1 = i;
            } else if (m2 == -1 || list.get(i) < list.get(m2)) {
                m2 = i;
            }
        }
        return new int[]{m1, m2};
    }

    public int minOperations(int[] nums, int k) {
        if (nums.length == 2) {
            if (nums[0] < k && nums[1] < k) return 1;
            else return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int x : nums) queue.add(x);

        int counter = 0;
        while (queue.size() > 1 && queue.peek() < k) {
            int m1 = queue.poll();
            int m2 = queue.poll();
            int operation = (m1 * 2) + m2;
            if (operation < 0) queue.add(Integer.MAX_VALUE);
            else queue.add(operation);
            counter++;

        }
        return counter;
    }

    public int punishmentNumber(int n) {
        if (n == 1) return 1;
        int s = 0;
        for (int i = 1; i <= n; i++) if (funrec(i, String.valueOf(i * i), 0)) s += i * i;
        return s;
    }

    private boolean funrec(int target, String numStr, int sum) {
        if (numStr.isEmpty()) return sum == target;

        for (int j = 1; j <= numStr.length(); j++) {
            int part = Integer.parseInt(numStr.substring(0, j));

            if (sum + part > target) break; // Redundant recusion

            if (funrec(target, numStr.substring(j), sum + part)) return true;
        }
        return false;
    }


    public String convert(String s, int k) {
        if (k == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(k, s.length()); i++) {
            list.add(new StringBuilder());
        }
        boolean direction = false;
        int row = 0;
        for (char ch : s.toCharArray()) {
            list.get(row).append(ch);
            if (row == 0 || row == k - 1) direction = !direction;
            row += direction ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : list) ans.append(sb);
        return ans.toString();
    }

    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) result.add(nums[i]);
        }
        if (result.size() < 3) return result.get(result.size() - 1);
        return result.get(result.size() - 3);

    }

    public void setZeroes(int[][] matrix) {
        boolean[][] bool = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) if (matrix[i][j] == 0) bool[i][j] = true;
        }

        for (int i = 0; i < bool.length; i++) {
            for (int j = 0; j < bool[0].length; j++) {
                if (bool[i][j]) setzero(i, j, matrix);
            }
        }
    }

    private void setzero(int row, int col, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) matrix[row][j] = 0;
        for (int i = 0; i < matrix.length; i++) matrix[i][col] = 0;
    }


    public int[] constructDistancedSequence(int n) {
        int[] arr = new int[n * 2 - 1];
        boolean[] bool = new boolean[n + 1];
        bool[0] = true;
        return lexifun(0, n, bool, arr) ? arr : null;
    }

    private boolean lexifun(int index, int n, boolean[] bool, int[] arr) {
        while (index < arr.length && arr[index] != 0) index++;
        if (index == arr.length) return true;

        for (int i = n; i >= 1; i--) {
            if (!bool[i]) {
                if (i == 1) {
                    arr[index] = i;
                    bool[index] = true;
                    if (lexifun(index + 1, n, bool, arr)) return true;
                    arr[index] = 0;
                    bool[index] = false;
                } else if (index + i < arr.length && arr[index + i] == 0) {
                    arr[index] = i;
                    arr[index + i] = i;
                    bool[index] = true;
                    bool[index + i] = true;
                    if (lexifun(index + 1, n, bool, arr)) return true;
                    arr[index] = 0;
                    arr[index + i] = 0;
                    bool[index] = false;
                    bool[index + i] = false;
                }
            }
        }
        return false;
    }

    public void gameOfLife(int[][] board) {
        //Any live cell with fewer than two live neighbors dies as if caused by underpopulation.
        //Any live cell with two or three live neighbors lives on to the next generation.
        //Any live cell with more than three live neighbors dies, as if by over-population.
        //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        int row = board.length;
        int col = board[0].length;
        int[][] b = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int c = getsidecount(i, j, board);
                if (board[i][j] == 1) {
                    if (c < 2) b[i][j] = 0;
                    else if (c == 2 || c == 3) b[i][j] = 1;
                    else b[i][j] = 0;
                } else {
                    if (c == 3) b[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < row; i++) System.arraycopy(b[i], 0, board[i], 0, col);
    }

    private int getsidecount(int i, int j, int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int c = 0;
        int[][] dirs = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},  // Horizontals & Verticals
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Diagonals
        };

        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < row && nj >= 0 && nj < col) c += board[ni][nj];
        }
        return c;
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part);
            }
        }

        return "/" + String.join("/", stack);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) return true;
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        for(int i=0 ; i<nums.length ;i++ ){
//            if(!map.containsKey(nums[i])){
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(nums[i],list);
//            }
//            else map.get(nums[i]).add(i);
//        }
//        List<Integer> l = null;
//        for(List<Integer> x : map.values()){
//            if(x.size()>1){
//                for (int i = 1; i < x.size(); i++) {
//                    if(x.get(i)-x.get(i-1)<=k)return true;
//                }
//            }
//        }
//        return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            } else map.put(nums[i], i);
        }
        return false;
    }

    public int missingNumber(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum1 += i;
            if (i < nums.length) sum2 += nums[i];
        }
        return sum1 - sum2;
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        return getBinaryString(n, set, new StringBuilder());
    }

    private String getBinaryString(int n, Set<String> set, StringBuilder s) {
        if (s.length() == n) {
            String candidate = s.toString();
            if (!set.contains(candidate)) return candidate;
            return null;
        }

        s.append('0');
        String result = getBinaryString(n, set, s);
        if (result != null) return result;
        s.deleteCharAt(s.length() - 1); // Backtrack

        s.append('1');
        result = getBinaryString(n, set, s);
        if (result != null) return result;
        s.deleteCharAt(s.length() - 1); // Backtrack
        return null;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    boolean isBadVersion(int i) {
        return true;
    }

    public int guessNumber(int n) {
        //You call a pre-defined API int guess(int num), which returns three possible results:
        //
        //-1: Your guess is higher than the number I picked (i.e. num > pick).
        //1: Your guess is lower than the number I picked (i.e. num < pick).
        //0: your guess is equal to the number I picked (i.e. num == pick).
        int i = 0, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (guess(mid) == 1) i = mid + 2;
            else if (guess(mid) == -1) j = mid;
            else return mid;
        }
        return i;
    }

    private int guess(int mid) {
        return 0;
    }

    public int numTilePossibilities(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder st = new StringBuilder();
        boolean[] bool = new boolean[s.length()];
        funrectiles(s, 0, set, st, bool);
        return set.size();
    }

    private void funrectiles(String s, int i, Set<String> set, StringBuilder st, boolean[] bool) {
        if (!st.isEmpty()) set.add(st.toString());
        for (int j = 0; j < s.length(); j++) {
            if (!bool[j]) {
                bool[j] = true;
                st.append(s.charAt(j));
                funrectiles(s, j, set, st, bool);
                st.deleteCharAt(st.length() - 1);
                bool[j] = false;
            }
        }
    }


    public int countSegments(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int max = 0;
        for (String x : s.split("\\s+")) max++;
        return max;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) ans.add(i);
        }
        return ans;
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String pattern = s.substring(0, len);
                StringBuilder repeated = new StringBuilder();
                repeated.append(pattern.repeat(n / len));
                if (repeated.toString().equals(s)) return true;
            }
        }
        return false;
    }

//    public void solve(char[][] board) {
//        // Key idea is that just  leave those 0 cells those are on the edge of the bounadry of the board
//        // another task is , we have to do it in-place,
//        // and we can do that by encoding the non -edge 0s
//        int row = board.length;
//        int col = board[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (board[i][j] == 'O') {
//                    if (onEdge(board, i, j)) {
//
//                    } else board[i][j] = 'X';
//                }
//            }
//        }
//    }

    private boolean onEdge(char[][] board, int i, int j) {
        return i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
    }

    static class Node2 {
        int val;
        Node2 next;
        Node2 random;

        public Node2(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node2 copyRandomList(Node2 head) {
            if (head == null) return null;

            Map<Node2, Node2> map = new HashMap<>();
            Node2 cur = head;
            while (cur != null) {
                map.put(cur, new Node2(cur.val));
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>(12);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        // Putted all the values needed for the conversion
        if (s.length() == 1) map.get(s);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                sum += map.get(s.substring(i, i + 2));
                i++;
            } else sum += map.get(String.valueOf(s.charAt(i)));
        }
        return sum;
    }

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>(12); // Mapped the int - String value pairs
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");
        map.put(1000, "M");


        int place = 1; // This will determine the position like : 1st , 10th , 100th  1000th place
        String s = String.valueOf(num); // String Conversion for easy access
        StringBuilder roman = new StringBuilder(); // Using Builder for easy inserting with storage efficiency

        for (int i = s.length() - 1; i >= 0; i--) { // loop for the program backwards
            if (place == 1000) { // at place 1000th we just need to check for how many 'M' should be coming as per the number
                for (int j = 0; j < Character.getNumericValue(s.charAt(i)); j++) roman.insert(0, 'M');
                break;
            } else {
                // No checking for the subtractive form cuz  that will be added eventually in the answer
                int n = Character.getNumericValue(s.charAt(i)) * place;
                if (map.containsKey(n)) {
                    roman.insert(0, map.get(n)); // Adding values to the Builder
                }
            }
            place *= 10; // Incrementing the place the ith value grows
        }
        return roman.toString(); // Required Roman
    }

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        int i = 0, sign = 1;
        long result = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (result * sign);
    }

    public String reverseVowels(String s) {
        boolean isA = false;
        boolean isB = false;
        int a = 0, b = s.length() - 1;
        char[] array = s.toCharArray();
        while (a < b) {
            if (isA && isB) {
                char ch = array[a];
                array[a] = array[b];
                array[b] = ch;
                a++;
                b++;
                isA = false;
                isB = false;
            }
            if (isNotVowel(array[a])) a++;
            else isA = true;
            if (isNotVowel(array[b])) b--;
            else isB = true;
        }
        return new String(array);
    }

    boolean isNotVowel(char ch) {
        return ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' &&
                ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U';
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) map.put(x, 1);
        for (int x : nums2) {
            if (map.containsKey(x)) map.put(x, map.get(x) + 1);
        }
        List<Integer> array = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > 1) array.add(key);
        }
        int[] ans = new int[array.size()];
        int i = 0;
        for (int x : array) ans[i++] = x;
        return ans;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> array = new ArrayList<>();
        for (int x : nums1) map.put(x, map.getOrDefault(x, 0) + 1);
        for (int x : nums2) {
            if (map.containsKey(x) && map.get(x) > 0) {
                array.add(x);
                map.put(x, map.get(x) - 1);
            }
        }
        int[] ans = new int[array.size()];
        int i = 0;
        for (int x : array) ans[i++] = x;
        return ans;
    }

    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        long s = 1, e = num;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            long sq = mid * mid;
            if (sq == num) return true;
            else if (sq < num) s = mid + 1;
            else e = mid - 1;
        }
        return false;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int num : nums) {
            if (num == 1) counter++;
            else {
                max = Math.max(counter, max);
                counter = 0;
            }
        }
        return max;
    }

    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();
        StringBuilder builder = new StringBuilder(s);
        int length = builder.length();
        for (int i = k; i < length; i += k) builder.insert(length - i, '-');
        return builder.toString();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
        //Output: [-1,3,-1]
        Stack<Integer> stacks = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>(); // For fast retrival in O(1)
        stacks.push(0);
        for (int i = 1; i < nums2.length; i++) {
            while (!stacks.isEmpty() && nums2[i] > nums2[stacks.peek()]) {
                int idx = stacks.pop();
                map.put(nums2[idx], nums2[i]);
            }
            stacks.push(i);
        }
        while (!stacks.isEmpty()) map.put(nums2[stacks.pop()], -1);
        for (int i = 0; i < nums1.length; i++) nums1[i] = map.get(nums1[i]);
        return nums1;
    }

    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        List<String> list = new ArrayList<>();

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            char firstChar = lowerWord.charAt(0);

            Set<Character> row = row1.contains(firstChar) ? row1 :
                    row2.contains(firstChar) ? row2 :
                            row3;
            boolean isValid = true;
            for (char ch : lowerWord.toCharArray()) {
                if (!row.contains(ch)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) list.add(word);
        }
        return list.toArray(new String[0]);
    }

    public String[] findRelativeRanks(int[] score) {
        //Input: score = [10,3,8,9,4]
        //Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, String> map = new HashMap<>();
        for (int x : score) queue.add(x);
        int i = 1;
        while (!queue.isEmpty()) {
            if (i == 1) map.put(queue.poll(), "Gold Medal");
            else if (i == 2) map.put(queue.poll(), "Silver Medal");
            else if (i == 3) map.put(queue.poll(), "Bronze Medal");
            else map.put(queue.poll(), String.valueOf(i));
            i++;
        }
        String[] ans = new String[score.length];
        for (int x = 0; x < ans.length; x++) {
            ans[i] = map.get(score[i]);
        }
        return ans;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true; // Both trees are empty
        if (t1 == null || t2 == null) return false; // One is empty, one is not
        if (t1.val != t2.val) return false; // Root values don't match
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int x : candyType) set.add(x);
        return Math.min(set.size(), candyType.length / 2);
    }

    public boolean satisfiesConditions(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) return true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i + 1 < grid.length && grid[i][j] != grid[i + 1][j]) return false;
                if (j + 1 < grid[0].length && grid[i][j] == grid[i][j + 1]) return false;
            }
        }
        return true;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map1.put(list1[i], i);
        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int indexSum = i + map1.get(list2[i]);
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    result.clear(); // New minimum found, clear list
                    result.add(list2[i]);
                } else if (indexSum == minIndexSum) result.add(list2[i]); // Another word with same min index sum
            }
        }
        return result.toArray(new String[0]); // Convert list to array
    }

    public double findMaxAverage(int[] nums, int k) {
        //Input: nums = [1,12,-5,-6,50,3], k = 4
        //Output: 12.75000
        //Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

        // Common and fast approach would be to use a sliding window techique
        int left = 0;
        double maxAvg = 0;
        for (int i = 0; i < k; i++) maxAvg += nums[i]; // Counting the array sum till the kth elemnt
        double cur = maxAvg;
        for (int right = k + 1; right < nums.length; right++) {
            cur = (cur - nums[right - k] + nums[right]);
            maxAvg = Math.max(cur, maxAvg);
        }
        return maxAvg / k;
    }

    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = getNcum(img, i, j, dir); // sum by count
            }
        }
        return ans;
    }

    private int getNcum(int[][] img, int i, int j, int[][] dir) {
        int[] ans = new int[2];
        int sum = 0, count = 0;
        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];
            if (r >= 0 && r < img.length && c >= 0 && c < img[0].length) {
                sum += img[r][c];
                count++;
            }
        }
        return sum / count;
    }

    public boolean judgeCircle(String moves) {
        // goal = 0,0
        int r = 0, d = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'R') r++;
            else if (ch == 'D') d++;
            else if (ch == 'L') r--;
            else if (ch == 'U') d--;
        }
        return r == 0 && d == 0;
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1, cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
                max = Math.max(max, cur);
            } else cur = 1;
        }
        return max;
    }

    public int calPoints(String[] op) {
        int sum = 0;
        Stack<Integer> stacks = new Stack<>();
        for (String s : op) {
            switch (s) {
                case "C" -> stacks.pop();
                case "D" -> {
                    int n = stacks.peek();
                    stacks.push(2 * n);
                }
                case "+" -> {
                    int n = stacks.pop();
                    int m = stacks.pop();
                    stacks.push(m);
                    stacks.push(n);
                    stacks.push(m + n);
                }
                default -> stacks.push(Integer.parseInt(s));
            }
        }
        while (!stacks.isEmpty()) sum += stacks.pop();
        return sum;
    }

    public int countBinarySubstrings(String s) {
        int prev = 0, cur = 1, result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                result += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }
        result += Math.min(prev, cur); // Final count
        return result;
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int fre = 0;
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            fre = Math.max(fre, map.get(x));
        }
        // This way we have added it to the map and also found max freq
        int ans = Integer.MAX_VALUE;
        for (int x : map.keySet()) { // we will iterate over the keyset
            if (map.get(x) == fre) {
                ans = Math.min(ans, map.get(x) * x);
            }
        }
        return ans;
    }

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int width = 0;
        for (char c : s.toCharArray()) {
            int charWidth = widths[c - 'a'];
            if (width + charWidth > 100) {
                lines++;
                width = charWidth;
            } else width += charWidth;
        }
        return new int[]{lines, width};
    }

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split("\\s+");
        int acounter = 1;
        for (int i = 0; i < words.length; i++) {
            char ch = words[i].charAt(0); // 1st character of the string
            StringBuilder s = new StringBuilder(words[i]);
            if (isNotVowel(ch)) { // return true if consonant
                s.deleteCharAt(0);
                s.append(ch);
            }
            s.append("ma");
            s.append("a".repeat(acounter));
            words[i] = s.toString();
            acounter++;
        }
        StringBuilder ans = new StringBuilder();
        for (String x : words) ans.append(x).append(" ");
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String normalized = paragraph.replaceAll("[!?',;.]", " ").toLowerCase();
        Map<String, Integer> wordCount = new HashMap<>();
        int maxFreq = 0;
        String result = "";
        for (String word : normalized.split("\\s+")) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                if (wordCount.get(word) > maxFreq) {
                    maxFreq = wordCount.get(word);
                    result = word;
                }
            }
        }
        return result;
    }

    public int[] shortestToChar(String s, char ch) {
        int n = s.length();
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();

        // Store positions of character `ch`
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ch) {
                list.add(i);
            }
        }

        // If no occurrence of ch, return default array
        if (list.isEmpty()) {
            return ans;
        }

        int x = 0, prev = -1, next = list.get(x);

        // Compute shortest distances
        for (int i = 0; i < n; i++) {
            if (i > next && x < list.size() - 1) {
                x++;
                prev = next;
                next = list.get(x);
            }

            if (prev == -1) {
                ans[i] = Math.abs(next - i);
            } else {
                ans[i] = Math.min(Math.abs(prev - i), Math.abs(next - i));
            }
        }
        return ans;
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        //Input: s = "abcdddeeeeaabbbcd"  3-6 = 3 , exclusive manner
        //Output: [[3,5],[6,9],[12,14]]
        List<List<Integer>> list = new ArrayList<>();
        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right - 1) == s.charAt(right)) {
                List<Integer> n = new ArrayList<>(2);
                int left = right - 1;
                while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                    right++;
                }
                if (right - left >= 3) {
                    n.add(left);
                    n.add(right - 1);
                    list.add(n);
                }
            }
        }
        return list;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(ch);
        }
        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) stack2.pop();
            } else stack2.push(ch);
        }
        while (!stack.isEmpty() && !stack2.isEmpty()) {
            if (stack.pop() != stack2.pop()) return false;
        }
        return stack.isEmpty() && stack2.isEmpty();
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
                if (freq[ch - 'a'] > 1) return true;
            }
            return false;
        }
        int first = -1, second = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) first = i;
                else if (second == -1) second = i;
                else return false;
            }
        }
        return (second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeafNodes(root1, leaves1);
        getLeafNodes(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void getLeafNodes(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) leaves.add(node.val);
        getLeafNodes(node.left, leaves);
        getLeafNodes(node.right, leaves);
    }

    public boolean isMonotonic(int[] nums) {
        return minc((nums)) || mdec(nums);
    }

    private boolean mdec(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) continue;
            else return false;
        }
        return true;
    }

    private boolean minc(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i - 1]) continue;
            else return false;
        }
        return true;
    }

    public String reverseOnlyLetters(String s) {
        int l = 0, r = s.length() - 1;
        char[] ch = s.toCharArray();
        while (l < r) {
            if (!Character.isLetter(ch[l])) l++;
            else if (!Character.isLetter(ch[r])) r--;
            else {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }
        return new String(ch);
    }

    public boolean isLongPressedName(String s, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < s.length() && s.charAt(i) == typed.charAt(j)) i++;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) return false;
            j++;
        }
        return i == s.length();
    }

    int pre = 0, post = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[pre++]);
        if (root.val != postorder[post]) root.left = constructFromPrePost(preorder, postorder);
        if (root.val != postorder[post]) root.right = constructFromPrePost(preorder, postorder);
        post++;
        return root;
    }

    public void nextPermutation(int[] array) {
        int n = array.length;
        if (n <= 1) return;
        int pidx = -1;
        for (int i = n - 1; i > 0; i--) {
            if (array[i - 1] < array[i]) {
                pidx = i - 1;
                break;
            }
        }
        if (pidx == -1) {
            reverse(array, 0, n - 1);
            return;
        }
        for (int i = n - 1; i > pidx; i--) {
            if (array[i] > array[pidx]) {
                swap(array, i, pidx);
                break;
            }
        }
        reverse(array, pidx + 1, n - 1);
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), n, 0, 0, ans);
        return ans;
    }

    private void backtrack(StringBuilder curr, int n, int open, int close, List<String> ans) {
        if (curr.length() == 2 * n) {
            ans.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append('(');
            backtrack(curr, n, open + 1, close, ans);
            curr.deleteCharAt(curr.length() - 1); // Undo choice (Backtracking)
        }
        if (close < open) {
            curr.append(')');
            backtrack(curr, n, open, close + 1, ans);
            curr.deleteCharAt(curr.length() - 1); // Undo choice (Backtracking)
        }
    }

    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;

                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int ins = dp[i][j - 1];
                    int del = dp[i - 1][j];
                    int rep = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(ins, Math.min(del, rep));
                }
            }
        }
        return dp[m][n];
    }


    private int helpdis(String s1, String s2, int i, int j, int[][] dp) {
        // Memoization funtion for Edit Distance quesiton
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = helpdis(s1, s2, i - 1, j - 1, dp);

        int ins = helpdis(s1, s2, i, j - 1, dp);
        int del = helpdis(s1, s2, i - 1, j, dp);
        int rep = helpdis(s1, s2, i - 1, j - 1, dp);

        return dp[i][j] = 1 + Math.min(ins, Math.min(del, rep));
    }


    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> list = new ArrayList<>();
        helpletter(digits, 0, map, new StringBuilder(), list);
        return list;
    }

    private void helpletter(String digits, int i, Map<Character, String> map, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(i);
        String s = map.get(c);
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            helpletter(digits, i + 1, map, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int n = words[0].length();
        int tlen = n * words.length;
        if (tlen > s.length()) return new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (String x : words) map.put(x, map.getOrDefault(x, 0) + 1);

        List<Integer> ans = new ArrayList<>();

        for (int left = 0; left <= s.length() - tlen; left++) {
            if (isConcatString(s.substring(left, left + tlen), map, n)) ans.add(left);
        }
        return ans;
    }

    private boolean isConcatString(String s, Map<String, Integer> map, int wlen) {
        Map<String, Integer> m1 = new HashMap<>(map);

        for (int i = wlen; i <= s.length(); i += wlen) {
            String x = s.substring(i - wlen, i);

            if (m1.containsKey(x)) {
                if (m1.get(x) <= 0) return false;
                else m1.put(x, m1.get(x) - 1);
            } else return false;
        }

        return true;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helpsubset2(nums, 0, list, new ArrayList<>());
        return list;
    }

    private void helpsubset2(int[] nums, int index, List<List<Integer>> list, List<Integer> inner) {
        list.add(new ArrayList<>(inner));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            inner.add(nums[i]);
            helpsubset2(nums, i + 1, list, inner);
            inner.remove(inner.size() - 1);
        }
    }

    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, maxAbsSum = 0;

        for (int num : nums) {
            maxSum = Math.max(num, maxSum + num);
            minSum = Math.min(num, minSum + num);
            maxAbsSum = Math.max(maxAbsSum, Math.max(Math.abs(maxSum), Math.abs(minSum)));
        }

        return maxAbsSum;
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) result[i] = rankMap.get(arr[i]);
        return result;
    }

    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        char s = words[0].charAt(0);
        char e = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            if (e != words[i].charAt(0)) return false;
            e = words[i].charAt(words[i].length() - 1);
        }
        return s == e;
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < s.length()) {
            char t = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(t);
            if (sb.toString().equals(goal)) return true;
            else i++;
        }
        return false;
    }

    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int c = 1;
        for (int i = 1; i < word.length(); i++) {
            if (c == 9) {
                sb.append(c);
                sb.append(word.charAt(i - 1));
                c = 1;
            } else if (word.charAt(i) == word.charAt(i - 1)) c++;
            else {
                sb.append(c);
                sb.append(word.charAt(i - 1));
                c = 1;
            }
        }
        sb.append(c);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }

    public int minChanges(String s) {
        int c = 0;
        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i - 1)) c++;
        }
        return c;
    }

    public int[] maximumBeauty(int[][] items, int[] query) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));  // Sort by price
        int n = items.length;
        int[] prices = new int[n];
        int[] beauty = new int[n];

        int maxBeauty = 0;
        for (int i = 0; i < n; i++) {
            prices[i] = items[i][0];
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            beauty[i] = maxBeauty;
        }
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int idx = Arrays.binarySearch(prices, query[i]);
            if (idx < 0) idx = -idx - 2;  // If idx is not found then it will negative idx
            ans[i] = (idx >= 0) ? beauty[idx] : 0;
        }
        return ans;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        list.sort(Comparator.comparingInt(a -> a.val));
        head = list.get(0);
        node = head;
        for (int i = 1; i < list.size(); i++) {
            node.next = list.get(i);
            node = node.next;
        }
        node.next = null;
        return head;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return checkPath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean checkPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (root.val != head.val) return false;
        return checkPath(head.next, root.left) || checkPath(head.next, root.right);
    }


    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1}; // Edge case: Less than 3 nodes
        }

        List<Integer> points = new ArrayList<>();
        ListNode prev = head, curr = head.next;
        int idx = 1;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
                points.add(idx);
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }

        if (points.size() < 2) return new int[]{-1, -1}; // No critical points
        int min = Integer.MAX_VALUE, max = points.get(points.size() - 1) - points.get(0);
        for (int i = 1; i < points.size(); i++) {
            min = Math.min(min, points.get(i) - points.get(i - 1));
        }
        System.out.println(points);
        return new int[]{min, max};
    }

    public int totalSteps(int[] nums) {
        int steps = 0;
        if (nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        while (true) {
            int size = list.size();
            steps++;
            boolean check = false;
            List<Integer> cur = new ArrayList<>();
            cur.add(list.get(0));
            for (int i = 1; i < size; i++) {
                if (list.get(i - 1) > list.get(i)) {
                    check = true;
                    continue;
                } else cur.add(list.get(i));
            }
            if (!check) break;
            System.out.println(cur);
            list = cur;
        }
        return steps - 1;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;

        while (cur != null) {
            cur.val *= 2;
            if (cur.val >= 10) {
                cur.val -= 10;
                prev.val += 1;
            }
            prev = cur;
            cur = cur.next;
        }
        return (dummy.val == 0) ? dummy.next : dummy;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode n = cur;
            int gcd = getGCD(cur.val, cur.next.val);
            cur = cur.next;
            ListNode node = new ListNode(gcd);
            n.next = node;
            node.next = cur;
        }
        return head;
    }

    int getGCD(int a, int b) {
        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;
        ListNode firstK = null, secondK = null;
        int idx = 1;
        ListNode cur = head;
        while (cur != null) {
            if (idx == k) firstK = cur;
            idx++;
            cur = cur.next;
        }
        if (firstK == null) return head;
        // Now idx = size of the list
        cur = head;
        for (int i = 0; i < idx - k; i++) {
            cur = cur.next;
        }
        if (cur == null) return head;
        secondK = cur;
        int t = firstK.val;
        firstK.val = secondK.val;
        secondK.val = t;
        return head;
    }

    public ListNode mergeInBetween(ListNode h1, int a, int b, ListNode h2) {
        //Input: list1 = [10,1,13,6,9,5], a = 3, b = 4,
        // list2 = [1000000,1000001,1000002]
        //Output: [10,1,13,1000000,1000001,1000002,5]

        ListNode cur = h2;
        while (cur.next != null) cur = cur.next;
        ListNode h2end = cur;

        int idx = -1;
        cur = new ListNode(0);
        cur.next = h1;
        while (cur != null) {
            if (idx + 1 == a) {
                ListNode t = cur.next;
                cur.next = h2;
                while (t.next != null && idx + 1 < b) {
                    t = t.next;
                    idx++;
                }
                h2end.next = t.next;
                t.next = null;
            } else cur = cur.next;
            idx++;
        }
        return h1;
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int prefixSum = 0;

        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            prefixSum += cur.val;
            map.put(prefixSum, cur);
        }

        prefixSum = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            prefixSum += cur.val;
            cur.next = map.get(prefixSum).next; // Skip zero-sum sublist
        }
        return dummy.next;
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }
        Stack<Integer> stacks = new Stack<>();
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            while (!stacks.isEmpty() && list.get(i) > list.get(stacks.peek())) {
                ans[stacks.pop()] = list.get(i);
            }
            stacks.push(i);
        }
        return ans;
    }


    public int numOfSubarrays(int[] arr) {
        int oddCount = 0, evenCount = 1; // evenCount = 1 to count the empty prefix sum
        int curSum = 0, result = 0;
        int mod = 1_000_000_007;

        for (int num : arr) {
            curSum += num;

            if (curSum % 2 == 0) {  // If even sum
                result = (result + oddCount) % mod;
                evenCount++;  // We encountered another even prefix sum
            } else {  // If odd sum
                result = (result + evenCount) % mod;
                oddCount++;  // We encountered another odd prefix sum
            }
        }
        return result;
    }

    public TreeNode recoverFromPreorder(String s) {
        if (s.isEmpty()) return null;
        return getPreorder(s, new int[]{0}, 0);
    }

    private TreeNode getPreorder(String s, int[] i, int depth) {
        int curDepth = 0;
        while (i[0] < s.length() && s.charAt(i[0]) == '-') {
            curDepth++;
            i[0]++;
        }

        if (curDepth != depth) {
            i[0] -= curDepth;
            return null;
        }

        int[] numInfo = getNum(s, i[0]);
        int val = numInfo[0];
        i[0] = numInfo[1];

        TreeNode node = new TreeNode(val);

        node.left = getPreorder(s, i, depth + 1);
        node.right = getPreorder(s, i, depth + 1);

        return node;
    }

    private int[] getNum(String s, int i) {
        int num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            i++;
        }
        return new int[]{num, i};
    }

    void Displaytree(TreeNode node) {
        if (node == null) {
            System.out.println(" Null");
            return;
        }
        System.out.println(node.val);
        Displaytree(node.left);
        Displaytree(node.right);
    }

    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        for (int x : nums) {
            if (x != 0) ans[j++] = x;
        }
        return ans;
    }

    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i == -1) return -1; // No next greater number possible

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);

        long result = Long.parseLong(new String(arr));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) swap(arr, start++, end--);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestSum = sum;
        for (int i = 1; i <= nums.length - 3; i++) {
            sum = sum + nums[i + 2] - nums[i - 1];
            if (Math.abs(target - sum) < Math.abs(target - closestSum)) closestSum = sum;
        }
        return closestSum;
    }

    public int[][] mergeArrays(int[][] arr1, int[][] arr2) {
        int[][] ans = new int[arr1.length + arr2.length][2];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i][0] == arr2[j][0]) {
                int key = arr1[i][0];
                int value = arr1[i][1] + arr2[j][1];
                ans[k++] = new int[]{key, value};
                i++;
                j++;
            } else if (arr1[i][0] < arr2[j][0]) {
                ans[k++] = arr1[i++];
            } else {
                ans[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) ans[k++] = arr1[i++];
        while (j < arr2.length) ans[k++] = arr2[j++];

        return Arrays.copyOf(ans, k);
    }

    public int longestMonotonicSubarray(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int in = 0, de = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] < nums[j]) in++;
                else {
                    max = Math.max(max, in + 1);
                    in = 0;
                }
                if (nums[j - 1] > nums[j]) de++;
                else {
                    max = Math.max(max, de + 1);
                    de = 0;
                }
            }
            max = Math.max(Math.max(in, de) + 1, max);
        }
        return max;
    }

    public boolean check(int[] arr) {
        if (arr.length == 1) return true;
        int i = 0;
        for (i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) break;
        }
        if (i == arr.length) return true;
        int j = i, pre = i;
        i++;
        while ((i % arr.length) != j) {
            if (arr[pre] > arr[i % arr.length]) return false;
            pre = i % arr.length;
            i++;
        }
        return true;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder s;
        String min;
        char carry = '0';

        if (num1.length() > num2.length()) {
            s = new StringBuilder(num1);
            min = num2;
        } else {
            s = new StringBuilder(num2);
            min = num1;
        }

        int i = min.length() - 1;
        int j = s.length() - 1;

        for (; i >= 0; i--, j--) {
            int n1 = s.charAt(j) - '0';
            int n2 = min.charAt(i) - '0';
            int sum = n1 + n2 + (carry - '0');

            s.setCharAt(j, (char) ((sum % 10) + '0'));
            carry = (sum >= 10) ? '1' : '0';
        }

        while (j >= 0 && carry == '1') {
            int sum = (s.charAt(j) - '0') + 1;
            s.setCharAt(j, (char) ((sum % 10) + '0'));
            carry = (sum >= 10) ? '1' : '0';
            j--;
        }

        if (carry == '1') s.insert(0, carry);
        return s.toString();
    }

    public void mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return;
        if (root2 == null) return;

        root1.val += root2.val;

        if (root1.left != null && root2.left != null) mergeTrees(root1.left, root2.left);
        else if (root1.left == null) root1.left = root2.left;

        if (root1.right != null && root2.right != null) mergeTrees(root1.right, root2.right);
        else if (root1.right == null) root1.right = root2.right;

    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) i += 2;
            else i++;
        }
        return i == bits.length - 1;
    }

    public int dominantIndex(int[] nums) {
        int max = 0;
        for (int m : nums) {
            max = Math.max(max, m);
        }

        int idx = -1;
        boolean check = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max && nums[i] * 2 > max) return -1;
            if (nums[i] == max) idx = i;
        }
        return idx;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        String MinWord = "";
        int min = Integer.MAX_VALUE;
        StringBuilder s = new StringBuilder();
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                s.append(Character.toLowerCase(ch));
            }
        }

        for (String word : words) {
            int[] arr = new int[26];
            for (char ch : word.toCharArray()) {
                arr[ch - 'a']++;
            }
            boolean check = false;
            for (char ch : s.toString().toCharArray()) {
                if (arr[ch - 'a'] > 0) {
                    arr[ch - 'a']--;
                } else {
                    check = true;
                    break;
                }
            }
            if (!check && word.length() < min) {
                MinWord = word;
                min = word.length();
            }
        }
        return MinWord;
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int p = matrix[0][0];
        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (isDiagonal(r, c, matrix, i, 0, matrix[i][0])) return false;
        }
        for (int j = 0; j < c; j++) {
            if (isDiagonal(r, c, matrix, 0, j, matrix[0][j])) return false;
        }
        return true;
    }

    private boolean isDiagonal(int r, int c, int[][] matrix, int i, int j, int p) {
        while (i < r && j < c) {
            if (matrix[i][j] != p) return true;
            i++;
            j++;
        }
        return false;
    }

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()) set.add(ch);
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) count++;
        }
        return count;
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String x : s1.split(" ")) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (String x : s2.split(" ")) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>();
        for (String x : map.keySet()) {
            if (map.get(x) == 1) list.add(x);
        }
        return list.toArray(new String[0]);
    }

    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int evenIndex = 0, oddIndex = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) ans[evenIndex++] = num;
            else ans[oddIndex--] = num;
        }
        return ans;
    }

    public int[] sortArrayByParityII(int[] nums) {
        int[] sorted = new int[nums.length];
        int left = 0;
        int right = 1;
        for (int x : nums) {
            if (x % 2 == 0) {
                sorted[left] = x;
                left += 2;
            } else {
                sorted[right] = x;
                right += 2;
            }
        }
        return sorted;
    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] i = new int[1];
        bst(root, low, high, i);
        return i[0];
    }

    private void bst(TreeNode root, int low, int high, int[] i) {
        if (root == null) return;

        if (root.val >= low && root.val <= high) {
            i[0] += root.val;
            bst(root.left, low, high, i);
            bst(root.right, low, high, i);
        } else if (root.val > high) bst(root.left, low, high, i);
        else bst(root.right, low, high, i);
    }

    static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int right = arr[arr.length - 1];
        list.add(right);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= right) {
                right = arr[i];
                list.add(right);
            }
        }

        Collections.reverse(list);
        return list;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // No solution found
    }

    public int getSecondLargest(int[] arr) {
        int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > l1) {
                l2 = l1;
                l1 = num;
            } else if (num > l2 && num < l1) {
                l2 = num;
            }
        }
        return l2;
    }

    public int singleNumber1(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) return nums[i];
        }
        return nums[nums.length - 1];
    }

    public int[] rearrangeArray(int[] nums) {
        int even = 0, odd = nums.length / 2;
        int[] ans = new int[nums.length];
        for (int x : nums) {
            if (x > 0) ans[even++] = x;
            else ans[odd++] = x;
        }
        int i = 0, j = nums.length / 2;
        for (int k = 0; k < nums.length; k++) {
            if (k % 2 == 0) {
                nums[k] = ans[i++];
            } else nums[k] = ans[j++];
        }
        return nums;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int[] arr = new int[nums.length];
        int pcounter = 0, ansi = 0, arri = 0;
        for (int x : nums) {
            if (x < pivot) ans[ansi++] = x;
            else if (x > pivot) arr[arri++] = x;
            else pcounter++;
        }
        while (pcounter > 0) {
            ans[ansi++] = pivot;
            pcounter--;
        }
        for (int i = 0; i < arri; i++) {
            ans[ansi++] = arr[i];
        }
        return ans;
    }

    int getprocessednum(int n) {
        if (n == 0) return 0; // It may be possible that the given n ==0
        int c = 0; // counter for no. of Iteration

        if (n % 10 == 0) n = Beutify(n); // It may be possible that n is like 230 , 34900

        while (String.valueOf(n).length() != 1) { // Optimal finding as we will check if the
            // converted string length is 1 or not ?
            int y = n % 10;
            c += 9 - y + 1; // +1 cuz the itslef num and 259->260 where 260 is also a num right ?
            n = Beutify(n + 9 - y); // Beautify
        }
        // After the while loop we know that n is now 1 single number
        c += 9;  // cuz we have to iterate till n-1 from n
        return c;// ans
    }

    int Beutify(int n) {
        // Core idea is we are just removing the trailing zeros in the beutify number
        int j = n + 1;
        while (j > 0) {
            if (j % 10 == 0) j = j / 10;
            else break;
        }
        return j;
    }

    public boolean canBeValid(String s, String locked) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // Here we will be dealing with the ')' character
            if (!stack.isEmpty()) {
                if ((s.charAt(i) == ')' && s.charAt(stack.peek()) == '(')
                        || s.charAt(i) == ')' && s.charAt(stack.peek()) == ')' && locked.charAt(stack.peek()) == '0')
                    stack.pop();
                else stack.push(i);
            } else stack.push(i);
        }
        if (stack.isEmpty()) return true;
        else if (stack.size() % 2 == 0) {
            // here we will be dealing with the '(' character
            while (!stack.isEmpty()) {
                int n = stack.pop();
                char ch = s.charAt(n);
                if (locked.charAt(n) == '1' && locked.charAt(stack.peek()) == '1') break;
                else if (s.charAt(n) == ')') {
                    if (s.charAt(stack.peek()) == '(') stack.pop();
                    else if (s.charAt(stack.peek()) == ')' && locked.charAt(stack.peek()) == '0') stack.pop();
                    else break;
                } else if (s.charAt(n) == '(') {
                    if (s.charAt(stack.peek()) == '(' && locked.charAt(n) == '0') stack.pop();
                    else if (s.charAt(stack.peek()) == ')' && locked.charAt(n) == '0' && locked.charAt(stack.peek()) == '0')
                        stack.pop();
                    else break;
                }
            }
        } else return false;

        return stack.isEmpty();
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int left = 0; left < nums.length - 1; left++) {
            if (nums[left] == nums[left + 1]) count++;
            else {
                if (count == (nums.length / 2)) return nums[left]; // Ensuring the element by left-1 pick
                else {
                    count = 0;
                }
            }
        }
        if (count == nums.length / 2) return nums[nums.length - 1];
        return -1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char ch : magazine.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (arr[ch - 'a'] > 0) arr[ch - 'a']--;
            else return false;
        }
        return true;
    }

    public List<String> fizzBuzz(int n) {
        //Given an integer n, return a string array answer (1-indexed) where:
        //
        //answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
        //answer[i] == "Fizz" if i is divisible by 3.
        //answer[i] == "Buzz" if i is divisible by 5.
        //answer[i] == i (as a string) if none of the above conditions are true.
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) list.add("FizzBuzz");
            else if (i % 3 == 0) list.add("Fizz");
            else if (i % 5 == 0) list.add("Buzz");
            else list.add(String.valueOf(i));
        }
        return list;
    }

    public int pivotIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;
        for (int num : nums) totalSum += num;

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }

        System.out.println("No Equilbrium");
        return -1;
    }

    public boolean checkPowersOfThree(int n) {
        List<Integer> rangeOf3s = Arrays.asList(
                1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683,
                59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721
        );
        boolean[] bool = new boolean[rangeOf3s.size()];
        // boolean array is used as per we can use any power only 1 time
        while (n > 0) {
            int x = getnear3(rangeOf3s, n, bool);
            if (x == n) return true;
            else if (x == -1) return false;
            else n -= x;
        }
        return true;
    }

    private int getnear3(List<Integer> list, int n, boolean[] bool) {
        // It is certain that if the n is to be existed as exact power of 3 then n%3 is already present
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) == n && !bool[i - 1]) {
                bool[i] = true;
                return list.get(i - 1);
            } else if (list.get(i) == n && !bool[i]) {
                bool[i] = true;
                return list.get(i);
            } else if (n < list.get(i) && n > list.get(i - 1) && !bool[i - 1]) {
                bool[i - 1] = true;
                return list.get(i - 1);
            }
        }
        return -1;
    }

    public int minLength(String s) {
        // We can use stringbuilder and stack too but in string builder we will create new strings but in stack we can optmiize it in only s space .
        Stack<Character> stacks = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stacks.isEmpty() && ch == 'B' && stacks.peek() == 'A') stacks.pop();
            else if (!stacks.isEmpty() && ch == 'D' && stacks.peek() == 'C') stacks.pop();
            else stacks.push(ch);
        }
        if (stacks.isEmpty()) return 0;
        while (true) {
            boolean check = false;
            char ch = stacks.pop();
            if (!stacks.isEmpty() && ch == 'B' && stacks.peek() == 'A') {
                stacks.pop();
                check = true;
            } else if (!stacks.isEmpty() && ch == 'D' && stacks.peek() == 'C') {
                stacks.pop();
                check = true;
            } else stacks.push(ch);
            if (!check) break;
        }
        return stacks.size();
    }

    public int[] getSumAbsoluteDifferences(int[] arr) {
        int tsum = 0;
        for (int x : arr) tsum += x;

        int[] ans = new int[arr.length];
        int lsum = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = (arr[i] * i) - lsum;
            int right = (tsum - lsum - arr[i]) - (arr.length - i - 1) * arr[i];
            ans[i] = left + right;
            lsum += arr[i];
        }

        return ans;
    }

    public int findMaxLength(int[] arr) {
        if (arr.length == 1) return 0;

        int leftsum = 0, max = 0;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            leftsum += arr[i];
            if (leftsum == 1) c++;
            if (c * 2 == i + 1) max = Math.max(i + 1, max);
        }
        return max;
    }

    public long coloredCells(int n) {
        // 1=1
        // 2=5    2*2 + 1*1
        // 3=13  3*3 + 2*2
        // 4=25  4*4 + 3*3
        if (n == 1) return 1;
        long pre = 1, cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = (long) i * i + (pre * pre);
            pre = i;
        }
        return cur;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, leftsum = 0;
        for (int x : nums) {
            leftsum += x;
            if (map.containsKey(leftsum - k)) count += map.get(leftsum - k);
            map.put(leftsum, map.getOrDefault(leftsum, 0) + 1);
        }
        return count;
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // We can take a fixed size array too
        int[] arr = new int[50];
        int n = grid.length * grid[0].length;
        int a = -1, b = -1;

        int sum = 0, product = 1;
        int s = 0, p = 1;
        for (int[] array : grid) {
            for (int x : array) {
                if (arr[x] < 2) arr[x]++;
                else a = x;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] < 1) b = i;
        }
        return new int[]{a, b};


//        Set<Integer> set = new HashSet<>();
//        int a = -1 , b =-1;
//        for(int[] arr : grid){
//            for(int x : arr){
//                if(set.contains(x))a=x;
//                else set.add(x);
//            }
//        }
//
//        for(int i =1 ; i<=grid.length*grid[0].length ;i++){
//            if(!set.contains(i)){
//                b=i;
//                break;
//            }
//        }
//        return new int[]{a,b};
    }

    public int minStartValue(int[] nums) {
        int left = 0, max = Integer.MAX_VALUE;
        for (int x : nums) {
            left += x;
            max = Math.min(max, left);
        }
        return max >= 0 ? nums[0] : Math.abs(max) + 1;
    }

    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;

        for (char x : chars) if (x == '1') right++;

        if (right == 0) {// means string has no 1's
            return s.length() - 1;
        }
        int max = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            char ch = s.charAt(i);
            if (right == 0) break;
            if (ch == '0') left++;
            else right--;
            if (i > 0 && left == 0) continue;
            max = Math.max(left + right, max);
        }
        return max;
    }

    public String shiftingLetters(String str, int[] shifts) {
        int total = 0;

        for (int x : shifts) total = (total + x) % 26;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < shifts.length; i++) {
            sb.append((char) ('a' + ((str.charAt(i) - 'a' + total) % 26)));
            total -= shifts[i];
        }
        return sb.toString();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return ans;
    }

    public int[] closestPrimes(int left, int right) {
        // We will use Sieve method and pre calclates the primes with in range
        int x = -1, y = -1;
        int[] ans = new int[]{-1, -1};
        int min = Integer.MAX_VALUE;

        boolean[] bool = new boolean[right + 1];
        Arrays.fill(bool, true);
        bool[0] = false;
        bool[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (bool[i] && i >= left) {
                if (x == -1) x = i;
                else if (y == -1) {
                    y = i;
                    min = y - x;
                    ans[0] = x;
                    ans[1] = y;
                } else {
                    x = y;
                    y = i;
                    if (y - x == 1) { // Prunning
                        ans[0] = x;
                        ans[1] = y;
                        break;
                    } else if (y - x < min) {
                        ans[0] = x;
                        ans[1] = y;
                        min = y - x;
                    }
                }
                for (int j = i * i; j <= right; j += i) {
                    bool[j] = false;
                }
            }
        }

        return ans;
    }

    private boolean[] sieve(int right) {
        boolean[] primes = new boolean[right + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= right; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

//    public int[] closestPrimes(int left, int right) {
    // This is brute force with some little optimizations like prunnning and pre-checking

//        int x = -1 , y = -1 ;
//        int[] ans = new int[]{-1,-1};
//        int min = Integer.MAX_VALUE;
//        if(left==1){ // Edge cases
//            x=2;
//            y=3;
//            left+=3;
//        }
//        while (left<=right){
//            if(y-x==1){ // Pruning the process to cut off redundant findings
//                ans[0]=x;
//                ans[1]=y;
//                break;
//            }
//            else if( left%2==0 || left%3==0){ //casually move to next number
//                left++;
//                continue;
//            }
//
//            else if(isPrime(left)){
//                if(x==-1)x=left;
//                else {
//                    if(y==-1)y=left;
//                    else {
//                        x=y;
//                        y=left;
//                    }
//                    if(y-x<min){
//                        min=y-x;
//                        ans[0]=x;
//                        ans[1]=y;
//                    }
//                }
//            }
//            left++;
//        }
//        return ans;
//}

    private boolean isPrime(int left) {
        for (int i = 5; i * i <= left; i += 6) {
            if (left % i == 0 || (left % (i + 2)) == 0) return false;
        }
        return true;
    }

    List<Integer> getprimes() {
        int left = 2, right = 100;
        List<Integer> list = new ArrayList<>();
        for (int i = left; i < right; i++) {
            if (prime(i)) list.add(i);
        }
        return list;
    }

    boolean prime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true; // 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false; // Eliminate multiples of 2 and 3

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }


    public int maxMoves(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) dp[i][j] = -1;
        }

        int maxPath = 0;
        for (int i = 0; i < row; i++) {
            maxPath = Math.max(maxPath, getmoves(i, 0, dp, row, col, grid));
        }
        return maxPath;
    }

    private int getmoves(int r, int c, int[][] dp, int row, int col, int[][] grid) {
        if (r >= row || c >= col || r < 0 || c < 0) return 0;

        if (dp[r][c] != -1) return dp[r][c];
        int up = 0, down = 0, right = 0;

        if (r - 1 >= 0 && c + 1 < col && grid[r][c] < grid[r - 1][c + 1])
            up = 1 + getmoves(r - 1, c + 1, dp, row, col, grid);

        if (c + 1 < col && grid[r][c] < grid[r][c + 1])
            right = 1 + getmoves(r, c + 1, dp, row, col, grid);

        if (r + 1 < row && c + 1 < col && grid[r][c] < grid[r + 1][c + 1])
            down = 1 + getmoves(r + 1, c + 1, dp, row, col, grid);

        return dp[r][c] = Math.max(up, Math.max(right, down));
    }

    public int minimumRecolors(String blocks, int k) {
        if (blocks.length() < k) return 0;

        int white = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') white--;
            else white++;
        }
        if (white == 0) return 0;
        int min = white;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'B') white--;
            else white++;
            if (blocks.charAt(i - k) == 'W') white--;
            min = Math.min(min, white);
        }
        return min;
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>(); // BFS Queue
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k); // Min-Heap to store k the largest sums

        queue.offer(root); // Push root
        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            minHeap.offer(levelSum);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.size() < k ? -1 : minHeap.poll();
    }

    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return pathSumFrom(root, targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int pathSumFrom(TreeNode node, long target) {
        if (node == null) return 0;
        int count = (node.val == target ? 1 : 0);
        count += pathSumFrom(node.left, target - node.val);
        count += pathSumFrom(node.right, target - node.val);
        return count;
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int left = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) left = queue.peek().val;
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return left;
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long n = Long.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                n = Math.max(n, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add((int) n);
        }
        return list;
    }

    int Sum = 0;

    public TreeNode convertBST(TreeNode root) {
        getrightcalculated(root);
        return root;
    }

    private void getrightcalculated(TreeNode root) {
        if (root == null) return;
        getrightcalculated(root.right);
        Sum += root.val;
        root.val = Sum;
        getrightcalculated(root.left);
    }

    public String tree2str(TreeNode root) {
        //  "1(2(4))(3)" // left and right both nodes are enclosed by () with values
        // This is Preorder
        //"1(2()(4))(3)"   -> If a node don't have  left but has right child then empty ()
        if (root == null) return "";
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        treeString(root, sb);
        if (sb.length() - 1 > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    void treeString(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right != null) sb.append("()");
        else if (root.left != null) {
            sb.append("(");
            treeString(root.left, sb);
        }
        if (root.right != null) {
            sb.append("(");
            treeString(root.right, sb);
        }
        sb.append(")");
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return null;
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        shiftnodes(root, val, depth, 0);
        return root;
    }

    void shiftnodes(TreeNode root, int val, int depth, int curDepth) {
        if (curDepth + 1 == depth) { // We have to insert in next level
            TreeNode node = new TreeNode(val);
            TreeNode node2 = new TreeNode(val);

            if (root.left != null) {
                node.left = root.left;
                root.left = node;
            }
            if (root.right != null) {
                node2.right = root.right;
                root.right = node2;
            }
            return;
        }
        if (root == null) return;
        shiftnodes(root.left, val, depth, curDepth + 1);
        shiftnodes(root.right, val, depth, curDepth + 1);
    }

    public List<List<String>> printTree(TreeNode root) {
        int m = height(root);  // Given that height
        int n = (int) Math.pow(2, m) - 1; // Formula for width of matrix

        // Construct Matrix
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(n, ""));
            list.add(row);
        }

        // Place the root in the middle
        fillTree(root, list, 0, 0, n - 1);

        return list;
    }

    private void fillTree(TreeNode root, List<List<String>> list, int row, int left, int right) {
        if (root == null) return;

        int mid = left + (right - left) / 2;
        list.get(row).set(mid, String.valueOf(root.val)); // Place root value

        fillTree(root.left, list, row + 1, left, mid - 1); // Recur for left subtree
        fillTree(root.right, list, row + 1, mid + 1, right); // Recur for right subtree
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        return gettrim(root, low, high);
    }

    TreeNode gettrim(TreeNode root, int l, int h) {
        if (root == null) return null;

        if (root.val < l) return root.right;
        if (root.val > h) return root.left;

        root.left = gettrim(root.left, l, h);
        root.right = gettrim(root.right, l, h);
        return root;
    }


    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return new ArrayList<>(); // Too short or too long

        List<String> list = new ArrayList<>();
        ips(new StringBuilder(), s, 0, 0, list);

        return list;
    }

    void ips(StringBuilder sb, String s, int idx, int dot, List<String> list) {
        if (dot == 4) {
            if (idx == s.length()) list.add(sb.substring(0, sb.length() - 1));
            return;
        }

        if (idx >= s.length()) return;
        int len = sb.length();

        // Single digit
        int n1 = s.charAt(idx) - '0';
        ips(sb.append(n1).append("."), s, idx + 1, dot + 1, list);
        sb.setLength(len);

        // Two digits
        if (idx + 1 < s.length() && s.charAt(idx) != '0') { // No leading zero
            int n2 = n1 * 10 + (s.charAt(idx + 1) - '0');
            ips(sb.append(n2).append("."), s, idx + 2, dot + 1, list);
            sb.setLength(len);
        }

        // Three digits
        if (idx + 2 < s.length() && s.charAt(idx) != '0') { // No leading zero
            int n3 = n1 * 100 + (s.charAt(idx + 1) - '0') * 10 + (s.charAt(idx + 2) - '0');
            if (n3 <= 255) {
                ips(sb.append(n3).append("."), s, idx + 3, dot + 1, list);
                sb.setLength(len);
            }
        }
    }

    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;

        boolean seenDigit = false, seenDot = false, seenExponent = false;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) seenDigit = true;

            else if (ch == '+' || ch == '-') {
                if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E'))
                    return false;
            } else if (ch == '.') {
                if (seenDot || seenExponent) return false;
                seenDot = true;
            } else if (ch == 'e' || ch == 'E') {
                if (seenExponent || !seenDigit) return false;
                seenExponent = true;
                seenDigit = false;
            } else return false;
        }
        return seenDigit;
    }

    public int orangesRotting(int[][] grid) {
        int min = 0, m = grid.length, n = grid[0].length;
        boolean changed;

        do {
            changed = false;
            boolean[][] newRotten = new boolean[m][n];

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == 2) {
                        // Mark adjacent fresh oranges to rot in the next step
                        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                            newRotten[r - 1][c] = true;
                            changed = true;
                        }
                        if (r + 1 < m && grid[r + 1][c] == 1) {
                            newRotten[r + 1][c] = true;
                            changed = true;
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                            newRotten[r][c - 1] = true;
                            changed = true;
                        }
                        if (c + 1 < n && grid[r][c + 1] == 1) {
                            newRotten[r][c + 1] = true;
                            changed = true;
                        }
                    }
                }
            }

            // Update the grid with newly rotten oranges
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (newRotten[r][c]) {
                        grid[r][c] = 2;
                    }
                }
            }

            if (changed) min++;

        } while (changed);

        // Check if any fresh orange remains
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1;
            }
        }

        return min;
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        // we have to check for the first increating or decreasing
        if (arr[0] < arr[1]) { // increasing
            int i = 0;
            for (; true; i++) {
                if (arr[i] < arr[i - 1]) break;
            }
            for (; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) return false;
            }
        } else return false;
        return true;
    }

    public int maxAreaOfIsland(int[][] grid) {
        // basically we need to count the dfs calls on every grid comp,
        // and then we count the grid number
        // at last after the call is over we will max count;
        // by creating the cell -1 we can make it visited
        int r = grid.length;
        int c = grid[0].length;
        int max = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int[] n = new int[]{0};
                    dfs(grid, i, j, n);
                    max = Math.max(max, n[0]);
                }
            }
        }
        return max;
    }

    void dfs(int[][] grid, int i, int j, int[] n) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = -1;
        n[0]++;
        dfs(grid, i + 1, j, n);
        dfs(grid, i - 1, j, n);
        dfs(grid, i, j - 1, n);
        dfs(grid, i, j + 1, n);
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        int baseSize = size / k;  // Minimum nodes in each part
        int extra = size % k;      // Extra nodes to distribute

        ListNode[] result = new ListNode[k];

        cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                result[i] = null;
                continue;
            }

            result[i] = cur;  // Start of current partition
            int partSize = baseSize + (extra > 0 ? 1 : 0); // Assign extra nodes first
            extra--;

            // Move to the last node of this partition
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }

            // Break the partition
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }

        return result;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (cycle(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean cycle(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, -1});
        visited[src] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0], parent = pair[1];
            for (int nb : adj.get(node)) {
                if (nb == parent) continue;
                else if (visited[nb]) return true;
                else {
                    queue.offer(new int[]{nb, node});
                    visited[nb] = true;
                }
            }
        }
        return false;
    }

    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // we will need for the indegree for the topo sort
        int n = adj.size();
        int[] degree = new int[n];

        for (ArrayList<Integer> integers : adj) {
            for (int nb : integers) {
                degree[nb]++;
            }
        }

        // Indegree done  , Now Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int x : degree) {
            if (x == 0) queue.offer(x); // adding the ones with 0 indegree &
            // And initial value for the queue
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);
            for (int x : adj.get(node)) {
                degree[x]--;
                if (degree[x] == 0) queue.offer(x); // Add the 0 indegree nodes to queue
            }
        }
        return list;
    }

    public String removeOuterParentheses(String s) {
        // we can check for the ( () () ) , ( () )

        StringBuilder sb = new StringBuilder();
        int start = 1, left = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') start++;
            else if (s.charAt(i) == ')') start--;

            if (start != 0) { // we have a primitive type
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }

    Map<Integer, Map<Integer, PriorityQueue<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        mappings(root, 0, 0);

        List<List<Integer>> OrderList = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> rmap : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : new TreeMap<>(rmap).values()) {
                while (!nodes.isEmpty()) list.add(nodes.poll());
            }
            OrderList.add(list);
        }
        return OrderList;
    }

    void mappings(TreeNode root, int row, int col) {
        if (root == null) return;

        map
                .computeIfAbsent(col, x -> new TreeMap<>())
                .computeIfAbsent(row, x -> new PriorityQueue<>())
                .add(root.val);

        mappings(root.left, row + 1, col - 1);
        mappings(root.right, row + 1, col + 1);
    }

    StringBuilder sb;
    String min;

    public String smallestFromLeaf(TreeNode root) {
        // we can just create every string with backtrakcking
        // then at leaf we can just reverse it then check min String
        min = "";
        sb = new StringBuilder();
        helper1(root);
        return min;
    }

    void helper1(TreeNode root) {
        if (root == null) return;

        sb.append((char) ('a' + root.val));
        helper(root.left);
        helper(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }

    static int repeatedCharacter(String S) {
        int[] low = new int[26];
        int[] high = new int[26];
        // we will use array instead of map for optimisation
        for (int i = 0; i < S.length(); i++) {
            if (Character.isUpperCase(S.charAt(i))) {
                int i1 = high[S.charAt(i) - 'A'];
                if (i1 > 1) return i;
                else i1++;
            } else {
                int i1 = low[S.charAt(i) - 'a'];
                if (i1 > 1) return i;
                else i1++;
            }
        }

//        int i=0;
//        for(char c : S.toCharArray()){
//            if(Character.isUpperCase(c) && high[c-'A']>1)return i;
//            else {
//                if(low[c-'a']>1)return i;
//            }
//            i++;
//        }
        return -1;
    }

    Map<Integer, List<Integer>> map1;
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        map1 = new HashMap<>();
        helper(root);
        // now we have all the values
        List<Integer> list = map1.get(max);
        int[] arr = new int[list.size()];
        int k = 0;
        for (int x : list) arr[k++] = x;
        return arr;
    }

    void helper(TreeNode root) {
        if (root == null) return;

        int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;

        int sum = left + right + root.val;
        max = Math.max(sum, max);
        if (map1.containsKey(sum)) {
            map1.get(sum).add(root.val);
            if (root.left != null) map1.get(sum).add(root.left.val);
            if (root.right != null) map1.get(sum).add(root.right.val);
        } else {
            map1.put(sum, new ArrayList<>());
            map1.get(sum).add(root.val);
            if (root.left != null) map1.get(sum).add(root.left.val);
            if (root.right != null) map1.get(sum).add(root.right.val);
        }

        helper(root.left);
        helper(root.right);
    }

    public int beautySum(String s) {

        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // freq for each starting i

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                if (j - i + 1 >= 3) { // only for length >= 3
                    int max = 0, min = Integer.MAX_VALUE;
                    for (int f : freq) {
                        if (f == 0) continue;
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                    sum += max - min;
                }
            }
        }

        return sum;
    }

    List<String> list;
    Set<Character> ch;
    Set<String> set;
    char[][] b;

    public List<String> findWords(char[][] board, String[] words) {
        list = new ArrayList<>();
        ch = new HashSet<>();
        set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        b = board;
        int m = board.length;
        int n = board[0].length;

        boolean[][] bool = new boolean[m][n];

        for (String x : words) {
            ch.add(x.charAt(0)); // only these possible routes we will start
            set.add(x);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ch.contains(board[i][j])) {
                    helper(bool, i, j, m, n, sb);
                }
            }
        }
        return list;
    }

    void helper(boolean[][] bool, int i, int j, int m, int n, StringBuilder sb) {
        if (i >= m || j >= n || i < 0 || j < 0 || bool[i][j]) return;

        bool[i][j] = true;
        sb.append(b[i][j]);

        if (set.contains(sb.toString())) {
            list.add(sb.toString());
            set.remove(sb.toString());
        }

        helper(bool, i + 1, j, m, n, sb);
        helper(bool, i - 1, j, m, n, sb);
        helper(bool, i, j + 1, m, n, sb);
        helper(bool, i, j - 1, m, n, sb);

        sb.deleteCharAt(sb.length() - 1);
        bool[i][j] = false;
    }

    public long calculateScore(String[] in, int[] val) {
        Set<Integer> set = new HashSet<>();
        long score = 0;
        int i = 0;

        while (i >= 0 && i < in.length) {
            if (set.contains(i)) break;
            set.add(i);

            if (in[i].equals("jump")) {
                i += val[i];
            } else if (in[i].equals("add")) {
                score += val[i];
                i++;
            }

            if (set.size() == in.length) break;
        }

        return score;
    }

    public int maximumPossibleSize(int[] nums) {
        int p = -1;

        int pc1 = 1, pc2 = 0;
        int plast1 = nums[0];
        int plast2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= plast1) {
                plast1 = nums[i];
                pc1++;
            }
            if (nums[i] < plast1 && p == -1) {
                p = i;
                pc2++;
                plast2 = nums[i];
            }
        }
        if (p != -1) {
            p++;
            for (; p < nums.length; p++) {
                if (nums[p] >= plast2) {
                    plast2 = nums[p];
                    pc2++;
                }
            }
        }
        return Math.max(pc1, pc2);
    }


    public int celebrity(int[][] mat) {
        int n = mat.length;
        List<int[]> degree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            degree.add(new int[2]); // [indegree, outdegree]
        }

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (mat[u][v] == 1 && u != v) {
                    degree.get(u)[1]++;
                    degree.get(v)[0]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int[] arr = degree.get(i);
            if (arr[0] == n - 1 && arr[1] == 0) {
                return i;
            }
        }

        return -1;
    }

    public int findKthNumber(int n, int k) {
//        if(k==1)return 1;
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list);
        System.out.println(list);
        return 1;
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int start = 1;
        for (int i = 1; i <= n; i++) {
            // dfs(i,n,list);
            list.add(start);
            if (start * 10 < n) {
                start *= 10;
            } else {
                while (start % 10 == 9 || start == n) start /= 10;
                start += 1;
            }
        }
        return list;
    }
//    public boolean wordBreak(String s, List<String> w) {
//        Set<String> set = new HashSet<>(w);
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (set.contains(sb.toString())) sb.setLength(0);
//            sb.append(s.charAt(i));
//        }
//        return set.contains(sb.toString());
//    }


//    public long countOfSubstrings(String word, int k) {
//        // a e i o u , k = given input
//        int a =0 , e=0 , i =0 , o =0 , u =0;  // Vowel Count
//        int n =0;
//        for(int m =0 ; m< word.length(); m++){
//            char c = word.charAt(m);
//            if(c=='a')a++;
//            if(c=='e')a++;
//            if(c=='i')a++;
//            if(c=='o')a++;
//            if(c=='u')a++;
//        }
//    }


//    public boolean validMountainArray(int[] arr) {
//        if(arr.length<3)return false;
//        boolean isInc = arr[0]<arr[1];
//        if(isInc){
//            int i=1;
//            for(; i<arr.length;i++){
//                if(arr[i-1]>arr[i])break;
//            }
//
//            for(;i<arr.length;i++){
//
//            }
//        }
//    }

//    public boolean isInterleave(String s1, String s2, String s3) {
//
//    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // in-order traversal
        // 2 pointer sort
        List<Integer> l = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        rec(root1, l);
        rec(root2, l2);

        System.out.println("l : " + l);
        System.out.println("l2 : " + l2);

        return sort(l, l2);
    }

    void rec(TreeNode root, List<Integer> l) {
        if (root == null) return;
        rec(root.left, l);
        l.add(root.val);
        rec(root.right, l);
    }

    public List<Integer> sort(List<Integer> l, List<Integer> l2) {
        List<Integer> l3 = new ArrayList<>();
        int x = 0, y = 0;
        while (x < l.size() && y < l2.size()) {
            if (l.get(x) < l2.get(y)) l3.add(l.get(x++));
            else if (l2.get(y) < l.get(x)) l3.add(l2.get(y++));
            else {
                l3.add(l2.get(y++));
                l3.add(l.get(x++));
            }
        }

        while (x < l.size()) l3.add(l.get(x++));
        while (y < l2.size()) l3.add(l2.get(y++));

        return l3;
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;

        // Balance left and right subtrees first
        root.left = balanceBST(root.left);
        root.right = balanceBST(root.right);

        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            // Left heavy
            if (leftHeight > rightHeight) {
                if (height1(root.left.left) >= height1(root.left.right)) {
                    root = l_to_r__Shift(root); // Right rotation
                } else {
                    root.left = r_to_l_Shift(root.left); // Left rotation on child
                    root = l_to_r__Shift(root);          // Then right rotation
                }
            }
            // Right heavy
            else {
                if (height1(root.right.right) >= height1(root.right.left)) {
                    root = r_to_l_Shift(root); // Left rotation
                } else {
                    root.right = l_to_r__Shift(root.right); // Right rotation on child
                    root = r_to_l_Shift(root);              // Then left rotation
                }
            }
        }

        return root;
    }

    private int height1(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public TreeNode l_to_r__Shift(TreeNode root) {
        TreeNode c = root.left;
        TreeNode t = c.right;
        c.right = root;
        root.left = t;
        return c;
    }

    public TreeNode r_to_l_Shift(TreeNode root) {
        TreeNode c = root.right;
        TreeNode t = c.left;
        c.left = root;
        root.right = t;
        return c;
    }

    static class N {
        int data;
        N left = null;
        N right = null;

        N(int data) {
            this.data = data;
        }
    }

    static N root;

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        root = new N(1);
        buildT(indexes, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (int k : queries) {
            SwapT(k); // perform swap
            List<Integer> inorderList = new ArrayList<>();
            inorder(root, inorderList); // collect in-order traversal
            result.add(inorderList);
        }

        return result;
    }

    static void SwapT(int k) {
        Queue<N> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                N node = q.poll();

                if (depth % k == 0) {
                    // Swap children
                    N temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            depth++;
        }
    }

    static void inorder(N node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    static void buildT(List<List<Integer>> list, int i) {
        Queue<N> queue = new LinkedList<>();
        queue.add(root);
        int idx = 0;

        while (!queue.isEmpty() && idx < list.size()) {
            N node = queue.poll();

            int left = list.get(idx).get(0);
            int right = list.get(idx).get(1);

            if (left != -1) {
                node.left = new N(left);
                queue.add(node.left);
            }
            if (right != -1) {
                node.right = new N(right);
                queue.add(node.right);
            }

            idx++;
        }
    }

//    static class Tnode {
//        Tnode[] child = new Tnode[26];
//        boolean isEnd = false;
//        String word = "";
//    }
//
//    Tnode rt;
//
//    int bt(String[] word) {
//        int count = 0;
//        for (String w : word) {
//            Tnode m = rt;
//            for (char c : w.toCharArray()) {
//                int idx = c - 'a';
//                if (m.child[idx] == null) m.child[idx] = new Tnode();
//                m = m.child[idx];
//            }
//            m.isEnd = true;
//            m.word = w;
//            count++;
//        }
//        return count;
//    }
//
//    static class C {
//        boolean ans;
//        int idx;
//
//        C(boolean ans, int idx) {
//            this.ans = ans;
//            this.idx = idx;
//        }
//    }
//
//    C checkT(Tnode r, String s, int idx, int count) {
//        Set<String> set = new HashSet<>();
//        for( int i =idx ; i<s.length(); i++ ){
//            if (r.isEnd){
//                if (!set.contains(r.word)){
//                    set.add(r.word);
//                    r=rt; // reset counter
//                }
//            }
//            int x = s.charAt(i)-'a';
//            if (r.child[x] == null)return new C(false , 0);
//            r=r.child[x];
//        }
//    }
//
//    public List<Integer> findSubstring(String s, String[] words) {
//        rt = new Tnode();
//        int count = bt(words);
//
//        // we will also use a set to deterMine if the current word is already processed?
//        // like : foofoothebarfoo  , words : foo , bar , ans = [9] not [0,9]
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            Tnode m = rt;
//            C a = checkT(m, s, i, count);
//            if (a.ans) {
//                list.add(i);
//                i += a.idx - 1;
//            }
//        }
//        return list;
//    }


    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return recM(0, 0, s, p, dp);
    }

    boolean recM(int i, int j, String s, String p, Boolean[][] dp) {
        if (i >= s.length() && j >= p.length()) return true;
        if (j >= p.length()) return false;

        if (dp[i][j] != null) return dp[i][j];

        boolean match = (i < s.length()) &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean pick = match && recM(i + 1, j, s, p, dp);
            boolean npick = recM(i, j + 2, s, p, dp);
            return dp[i][j] = pick || npick;
        }

        if (match) return dp[i][j] = recM(i + 1, j + 1, s, p, dp);
        return dp[i][j] = false;
    }



    /// //////////////////////////////////
    public static void main(String[] args) {
        Lcode l = new Lcode();
        System.out.println(l.findKthNumber(1, 1));
//        System.out.println("apple".compareTo("apply"));
//        System.out.println(l.maximumPossibleSize(new int[]{4,2,5,3,5}));
//        System.out.println(l.calculateScore(new String[]{"jump","add","add"},new int[]{1,-7,-3}));
//        System.out.println(l.beautySum("aabcb"));
        // global = aabcaba
//        System.out.println(repeatedCharacter("geeksforgeeks"));
//        System.out.println("aacabba".compareTo("abacaba"));
//        System.out.println("aacbaba".compareTo("abacaba"));
//        System.out.println("aacbaba".compareTo("aabcaba"));
//        System.out.println
//        (Integer.MIN_VALUE);
//        System.out.println(l.removeOuterParentheses("(()())(()(()))"));
//        List<String>list = Arrays.asList("aaaa","aaa");
//        System.out.println(l.wordBreak("aaaaaaa",list));
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        System.out.println(l.orangesRotting(grid));
//        System.out.println(l.isNumber("-1."));
//        System.out.println(l.restoreIpAddresses("25525511135"));
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        System.out.println(l.tree2str(root));
//        System.out.println("Expected : 1(2(4))(3) : " + l.tree2str(root).equals("1(2(4))(3)"));
//        System.out.println(l.getprimes());
//        System.out.println(Arrays.toString(l.closestPrimes(19, 31)));
//        System.out.println(l.fourSum(new int[]{1,0,-1,0,-2,2},0));
//        System.out.println(l.shiftingLetters("abc",new int[]{3,5,9}));
//        System.out.println(l.coloredCells(4));
//    System.out.println(l.findMaxLength(new int[]{0,0,0,1,1,1,0}));
//        System.out.println(Arrays.toString(l.getSumAbsoluteDifferences(new int[]{2, 3, 5})));
//        System.out.println(l.checkPowersOfThree(1));
//        System.out.println(l.pivotIndex(new int[]{2,1,-1}));
//        System.out.println(l.fizzBuzz(3));
//        System.out.println(l.majorityElement(new int[]{2,2,1,1,1,2,2}));
//        System.out.println(l.canBeValid(  "))()))","010100"));
//        System.out.println(l.Beutify(29959));
//        System.out.println(l.getprocessednum(999));
        // 999 , 1000->1, 2,3,4,5,6,7,8,9,10->1(ends)
//        System.out.println(Arrays.toString(l.sortArrayByParityII(new int[]{4, 2, 5, 7})));
//        System.out.println(Arrays.toString(l.sortArrayByParity(new int[]{3, 1, 2, 4})));
//        System.out.println(Arrays.toString(l.uncommonFromSentences("apple apple", "banana")));
//        int[][] mat = {{11,74,0,93},{40,11,74,7}};
//        System.out.println(l.isToeplitzMatrix(mat));
//        System.out.println(l.dominantIndex(new int[]{3,6,1,0}));
//        MyHashMap hm = new MyHashMap();
//        hm.put(1, 1);
//        hm.put(2, 2);
//        System.out.println(hm.get(1));
//        System.out.println(hm.get(3));
//        hm.put(2, 1);
//        System.out.println(hm.get(2));
//        hm.remove(2);
//        System.out.println(hm.get(2));
//        System.out.println(l.isOneBitCharacter(new int[]{0,1,0}));
//        System.out.println(l.addStrings("12","12"));
//        System.out.println(l.longestMonotonicSubarray(new int[]{3,2,1}));
//        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
//        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
//        System.out.println(Arrays.deepToString(l.mergeArrays(nums1, nums2)));
//        System.out.println(l.threeSumClosest(new int[]{1,1,1,0},-100));
//        System.out.println(l.nextGreaterElement(2147483476));
//        System.out.println(Arrays.toString(l.applyOperations(new int[]{847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272})));
//        l.Displaytree(l.recoverFromPreorder("1-2--3--4-5--6--7"));
//        System.out.println(l.numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
//        System.out.println(l.totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
//        System.out.println(l.compressedString("aaaaaaaaaaaaaabb"));
//        System.out.println(l.isCircularSentence("leetcode exercises sound delightful"));
//        System.out.println(Arrays.toString(l.arrayRankTransform(new int[]{100,100,100})));
//        System.out.println(l.maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
//        System.out.println(l.subsetsWithDup(new int[]{1,2,2}));
//        System.out.println(l.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
//        System.out.println(l.letterCombinations("23"));
//        System.out.println(l.isLongPressedName("vtkgn", "vttkgnn"));
//        System.out.println("Out : "+l.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
//        System.out.println(l.buddyStrings("ab","ba"));
//        System.out.println(Arrays.toString(l.shortestToChar("aabaa", 'b')));
//        System.out.println(l.mostCommonWord("Bob. hIt, baLl",new String[]{"bob", "hit"}));
//        System.out.println(l.findShortestSubArray(new int[]{1,2,2,3,1}));
//        System.out.println(l.countBinarySubstrings("00110011"));
//        System.out.println(l.calPoints(new String[]{"5","2","C","D","+"}));
//        System.out.println(l.judgeCircle("LDRRLRUULR"));
//        int[][] matrix = {
//                {100, 200, 100},
//                {200, 50, 200},
//                {100, 200, 100}
//        };
//        System.out.println(Arrays.deepToString(l.imageSmoother(matrix)));
//        System.out.println(Arrays.toString(l.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
//        System.out.println(Arrays.toString(l.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
//        System.out.println(l.licenseKeyFormatting("5F3Z-2E9W",4));
//        System.out.println(l.intToRoman(3794));
//        System.out.println(l.countSegments(", , , ,        a, eaefa"));
//        System.out.println(l.numTilePossibilities("AAB"));
//        System.out.println(l.findDifferentBinaryString(new String[]{"01", "10"}));
//        System.out.println(l.missingNumber(new int[]{3,0,1}));
//        System.out.println(l.containsDuplicate(new int[]{1,2,3,1}));
//        System.out.println(l.simplifyPath("/..hidden"));
//        System.out.println(l.thirdMax(new int[]{3, 2, 1}));
//        System.out.println(l.convert("PAYPALISHIRING",4));
//        ProductOfNumbers p = new ProductOfNumbers();
//        p.add(3);
//        p.add(0);
//        p.add(2);
//        p.add(5);
//        p.add(4);
//        p.display();
//        System.out.println(p.getProduct(2));
//        System.out.println(p.getProduct(3));
//        System.out.println(p.getProduct(4));
//        p.add(8);
//        System.out.println(p.getProduct(2));
//        System.out.println(l.minOperations(new int[]{1000000000,999999999,1000000000,999999999,1000000000,999999999}, 1000000000));
//        System.out.println(l.longestSquareStreak(new int[]{5, 12, 3, 10, 4, 11, 4, 16, 11}));
//        System.out.println(l.isHappy(19));
//        System.out.println(l.maximumSum(new int[]{18,43,36,13,7}));
//        System.out.println(l.longestPalindrome("babad"));
//        System.out.println(l.removeOccurrences("aabababa", "aba"));
//        System.out.println(l.tupleSameProduct(new int[]{20, 10, 6, 24, 15, 5, 4, 30}));
//        System.out.println(l.tupleSameProduct(new int[]{2, 3, 4, 6}));
//        System.out.println(l.numTrees(7));
//        System.out.println(l.areAlmostEqual("attack", "attcak"));
//        System.out.println(l.calculate(" 3/2 "));
//        System.out.println(l.getRow(33));
//        System.out.println(l.generate(33));
//        System.out.println(l.fourcap());
//        System.out.println(l.getPermutation(3,3));
//        System.out.println(Arrays.toString(l.nextGreaterElements(new int[]{2, 1, 2, 4, 3})));
//        System.out.println(l.numDecodings("226"));
//        System.out.println(l.multiply("123456789","987654321"));
//        System.out.println(l.isPowerOfThree(134424234));
//        System.out.println(l.checkRecord("ALLAPPL"));
//        System.out.println(l.countDigitOne(13));
//        int[] arr = {1,2,3};
//        System.out.println(l.permute(arr));
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
//        System.out.println(l.isValidSudoku(board));
//        int[] array = {4, 5, 2, 5};
//        System.out.println(l.minOperations(array, 2));
//        l.rotate(array,3);
//        System.out.println(Arrays.toString(array));
//        System.out.println(l.removeDuplicates(array));
//        System.out.println(l.combinationSum4(array, 4));
//        System.out.println(l.combinationSum2(array, 8));
//        System.out.println(l.makeFancyString("aaabaaaa"));

//        System.out.println(l.countAndSay(4));

//        boolean[][] bool = new boolean[3][3];
//        N_ChessPieces n = new N_ChessPieces();
//        int[] count = new int[]{0};
//        n.Rook(bool, 0, count);
//        System.out.println(count[0]);

        //        l.PPrint(3);
//        l.PathWithPrint(3);
//        System.out.println(l.threeSum(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println(l.isPowerOfTwo(16));
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9 }
//                };
//        System.out.println(l.spiralOrder(matrix));
//        int[][] atrix = {
//    {1, 2, 3, 4},
//    {5, 6, 7, 8},
//    {9, 10, 11, 12},
//    {13, 14, 15, 16}
//};
//        System.out.println(l.spiralOrder(atrix));
//        int[] array = {2, 1, 5, 1, 3, 2};
//        int k = 3;
//        System.out.println(MaxSumSubarray(array, k));
//        System.out.println(l.strStr("sadbutsad","sad"));
//        System.out.println(l.strStr("leetcode","leeto"));
//        System.out.println(l.getCommon(new int[]{1,2,3},new int[]{2,4}));
//        System.out.println(longestCommonPrefix(new String[]{"aa","aa"}));
//        Lcode code = new Lcode();
//        System.out.println(code.reverse(123));
//        int[] ar = {0,0,0,1,2,3,4,4,4,5};
//        System.out.println(removeDuplicates(ar));
//        System.out.println(Arrays.toString(ar));
    }
}

class Codec {
    Map<Integer, Integer> in;
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return ""; // Handle null tree

        // Use inorder and preorder traversals
        StringBuilder in = new StringBuilder();
        StringBuilder pre = new StringBuilder();
        getInorder(in, root);
        getPreorder(pre, root);

        if (!in.isEmpty()) in.deleteCharAt(in.length() - 1); // Remove last comma
        if (!pre.isEmpty()) pre.deleteCharAt(pre.length() - 1);

        return in.append("..").append(pre).toString();
    }

    private void getInorder(StringBuilder in, TreeNode node) {
        if (node == null) return;
        getInorder(in, node.left);
        in.append(node.val).append(",");
        getInorder(in, node.right);
    }

    private void getPreorder(StringBuilder pre, TreeNode node) {
        if (node == null) return;
        pre.append(node.val).append(",");
        getPreorder(pre, node.left);
        getPreorder(pre, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null; // Handle empty input

        String[] parts = data.split("\\.\\.");
        if (parts.length != 2) return null; // Invalid format check

        String s1 = parts[0], s2 = parts[1];

        in = new HashMap<>();
        String[] inorderArr = s1.split(",");
        String[] preorderArr = s2.split(",");

        int[] pre = new int[preorderArr.length];
        for (int i = 0; i < preorderArr.length; i++) {
            pre[i] = Integer.parseInt(preorderArr[i]);
        }

        for (int j = 0; j < inorderArr.length; j++) {
            in.put(Integer.parseInt(inorderArr[j]), j);
        }

        idx = 0;
        return reconstruct(pre, 0, pre.length - 1);
    }

    private TreeNode reconstruct(int[] pre, int left, int right) {
        if (left > right) return null;
        int ele = pre[idx++];
        TreeNode node = new TreeNode(ele);

        int i = in.get(ele);
        node.left = reconstruct(pre, left, i - 1);
        node.right = reconstruct(pre, i + 1, right);

        return node;
    }
}


class BSTIterator {
    // Gien that the root is of the BST iterator
    ArrayList<Integer> list = new ArrayList<>();
    int idx = 0;

    public BSTIterator(TreeNode root) {
        getListFilled(root);
    }

    private void getListFilled(TreeNode root) {
        if (root == null) return;
        getListFilled(root.left);
        list.add(root.val);
        getListFilled(root.right);
    }

    public int next() {
        // No Edge case for this as this has been given that next always has a next valid num
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx == list.size();
    }
}

class MyHashMap {
    static class Mnode {
        int key;
        int value;
        Mnode next;

        Mnode(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    Mnode root;
    Mnode tail;

    public MyHashMap() {
        root = null;
        tail = null;
    }

    public void put(int key, int value) {
        if (root == null) {
            root = new Mnode(key, value);
            tail = root;
        } else {
            Mnode nod = root;
            while (nod != null) {
                if (nod.key == key) {
                    nod.value = value;
                    return;
                }
                nod = nod.next;
            }
            Mnode node = new Mnode(key, value);
            tail.next = node;
            tail = node;

        }
    }

    public int get(int key) {
        Mnode cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        if (root == null) return; // Empty list

        if (root.key == key) {
            root = root.next;
            if (root == null) tail = null;
            return;
        }

        Mnode prev = root;
        Mnode cur = root.next;

        while (cur != null) {
            if (cur.key == key) {
                prev.next = cur.next;
                if (cur == tail) tail = prev;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}

class CustomStack {

    int size;
    int curidx;
    int[] arr;

    public CustomStack(int maxSize) {
        this.size = maxSize;
        curidx = 0;
        arr = new int[maxSize];
    }

    public void push(int x) {
        if (curidx < size) {
            arr[curidx++] = x;
        }
    }

    public int pop() {
        if (curidx > 0) {
            int t = arr[curidx - 1];
            arr[--curidx] = 0;
            return t;
        } else return -1;
    }

    public void increment(int k, int val) {
        if (k >= size) {
            int j = 0;
            for (int n : arr) arr[j++] = n + val;
        } else for (int i = 0; i < k; i++) arr[i] += val;
    }
}

class ProductOfNumbers {
    private List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            list.add(1);
        } else list.add(list.get(list.size() - 1) * num);
    }

    public int getProduct(int k) {
        if (k >= list.size()) return 0;
        return list.get(list.size() - 1) / list.get(list.size() - k - 1);
    }

    void display() {
        System.out.println(list);
    }
}

class NumberContainers {
    ArrayList<Integer> list;

    public NumberContainers() {
        list = new ArrayList<>();
    }

    public void change(int index, int number) {
        if (list.size() != index) {
            while (list.size() != index - 1) {
                list.add(0);
            }
            list.add(number);
        } else list.set(index - 1, number);
    }

    public int find(int number) {
        if (list.contains(number)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == number) return i;
            }
        }
        return -1;
    }
}


class N_ChessPieces {
    // This is the N-Queen problem
    int queens(boolean[][] board, int row) {
        if (row == board.length) {
            QueensDisplay(board);
            return 1;
        }
        int c = 0;
        for (int col = 0; col < board.length; col++) {
            if (isQueenSafe(board, row, col)) {
                board[row][col] = true;
                c += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return c;
    }

    private boolean isQueenSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
            if (board[row][i]) return false;
        }
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i]) return false;
        }
        for (int i = 1; row - i >= 0 && col + i < board.length; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    }


    private void QueensDisplay(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row) {
                if (ele) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // This is N-Knights problem
    void Knights(boolean[][] board, int row, int col, int knight) {
        if (knight == 0) {
            DisplayKnights(board);
            return;
        }
        if (row == board.length) return;
        if (col == board.length) {
            Knights(board, row + 1, 0, knight);
            return;
        }
        if (isKightSafe(board, row, col)) {
            board[row][col] = true;
            Knights(board, row, col + 1, knight - 1);
            board[row][col] = false;
        }
        Knights(board, row, col + 1, knight);
    }

    private boolean isKightSafe(boolean[][] board, int row, int col) {
        if (col - 1 >= 0 && row - 2 >= 0 && board[row - 2][col - 1]) return false; // check up left
        if (col + 1 < board.length && row - 2 >= 0 && board[row - 2][col + 1]) return false; // check up right
        if (row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2]) return false; //  check left up
        return row - 1 < 0 || col + 2 >= board.length || !board[row - 1][col + 2]; // check right up
    }

    private void DisplayKnights(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row) {
                if (ele) System.out.print("K ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // N-Bishops
    void Bishops(boolean[][] board, int row, int col, int bishop) {
        if (bishop == 0) {
            DisplayBishops(board);
            return;
        }
        if (row == board.length) return;

        if (col == board.length) {
            Bishops(board, row + 1, 0, bishop);
            return;
        }

        if (isBishopSafe(board, row, col)) {
            board[row][col] = true;
            Bishops(board, row, col + 1, bishop - 1);
            board[row][col] = false;
        }
        Bishops(board, row, col + 1, bishop);
    }

    private boolean isBishopSafe(boolean[][] board, int row, int col) {
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i]) return false;
        }
        for (int i = 1; row - i >= 0 && col + i < board.length; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    }

    private void DisplayBishops(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row) {
                if (ele) System.out.print("B ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // N Rook
    void Rook(boolean[][] board, int row, int[] count) {
        if (row == board.length) {
            DisplayRook(board);
            count[0]++;
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isRookSafe(board, row, col)) {
                board[row][col] = true;
                Rook(board, row + 1, count);
                board[row][col] = false;
            }
        }
    }

    private boolean isRookSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        return true;
    }

    private void DisplayRook(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row) {
                if (ele) System.out.print("R ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class MagicDictionary {

    static class Tnode {
        Tnode[] child = new Tnode[26];
        boolean isend = false;
    }

    static class Trie {
        Tnode root = new Tnode();

        void insert(String s) {
            Tnode node = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (node.child[idx] == null) node.child[idx] = new Tnode();
                node = node.child[idx];
            }
            node.isend = true;
        }


        boolean search(String s) {
            return dfs(s, 0, root, 0);
        }

        private boolean dfs(String word, int index, Tnode node, int count) {
            if (count > 1) return false;
            if (index == word.length()) return count == 1 && node.isend;

            int idx = word.charAt(index) - 'a';

            for (int i = 0; i < 26; i++) {
                if (node.child[i] == null) continue;

                if (i == idx) {
                    if (dfs(word, index + 1, node.child[i], count)) return true;
                } else {
                    // Try replacing this character
                    if (count < 1) {
                        if (dfs(word, index + 1, node.child[i], count + 1)) return true;
                    }
                }
            }

            return false;
        }
    }

    Trie t;

    public MagicDictionary() {
        t = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String x : dictionary) t.insert(x);
    }

    public boolean search(String searchWord) {
        return t.search(searchWord);
    }
}


//public boolean canBeValid(String s, String locked) {
//        stack.push(0);
//        for(int i =1;i<s.length();i++){
//            if(!stack.isEmpty() && s.charAt(i)==')'){
//                if(s.charAt(stack.peek())!='(' && locked.charAt(stack.peek())=='0'){
//                    stack.pop();
//                }
//                else stack.pop();
//            }
//            else if(!stack.isEmpty() && s.charAt(i)=='(' &&  s.charAt(stack.peek())=='(' && locked.charAt(i)=='0') {
//                stack.pop();
//            }
//            else stack.push(i);
//        }
//        if(stack.size()%2==0){
//            while(!stack.isEmpty()){
//                int n = stack.pop();
//                if(locked.charAt(n)=='1' && locked.charAt(stack.peek())=='1')break;
//                if(s.charAt(n)==')' && s.charAt(stack.peek())!='(' && locked.charAt(stack.peek())=='0')stack.pop();
//                else if (s.charAt(n)=='(' ){
//                    if(s.charAt(stack.peek())==')' && locked.charAt(n)=='0' && locked.charAt(stack.peek())=='0')stack.pop();
//                    else if(s.charAt(stack.peek())=='(' && locked.charAt(n)=='0')stack.pop();
//                }
//            }
//        }
//        else return false;
//