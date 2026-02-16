package Code;

import java.util.ArrayList;

public class LinkedListHCODE {
    public static void main(String[] args) {

    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }

        public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            if (llist == null) {
                llist = node;
                return llist;
            }
            int size = 0;
            SinglyLinkedListNode temp = llist;
            while (size < position - 1) {
                temp = temp.next;
                size++;
            }
            node.next = temp.next;
            temp.next = node;
            return llist;
        }

        public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
            if (llist != null) {
                int size = 0;
                SinglyLinkedListNode temp = llist;
                if (position == 0) {
                    llist = llist.next;
                    return llist;
                }
                while (size < position - 1) {
                    temp = temp.next;
                    size++;
                }
                temp.next = temp.next.next;
            }
            return llist;
        }

        public static void reversePrint(SinglyLinkedListNode llist) {
            if (llist != null) {
                SinglyLinkedListNode current = llist;
                ArrayList<Integer> arr = new ArrayList<>();
                int size = 0;
                while (current != null) {
                    arr.add(current.data);
                    size++;
                    current = current.next;
                }
                for (int i = size - 1; i >= 0; i--) {
                    System.out.println(arr.get(i));
                }
            }
        }

        public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
            SinglyLinkedListNode newhead = new SinglyLinkedListNode(llist.data);
            SinglyLinkedListNode current = llist;
            while (current.next != null) {
                SinglyLinkedListNode temp = new SinglyLinkedListNode(current.next.data);
                temp.next = newhead;
                newhead = temp;
                current = current.next;
            }
            llist = newhead;
            return llist;
        }

        static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            SinglyLinkedListNode tmp1 = head1;
            SinglyLinkedListNode tmp2 = head2;
            while (tmp1 != null && tmp2 != null) {
                if (tmp1.data != tmp2.data) {
                    return false; // Data mismatch
                }
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
            return tmp1 == null && tmp2 == null;
        }

        static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            if (head1 == null) return head2;
            if (head2 == null) return head1;
            SinglyLinkedListNode mergedHead;
            if (head1.data <= head2.data) {
                mergedHead = head1;
                head1 = head1.next;
            } else {
                mergedHead = head2;
                head2 = head2.next;
            }

            // Maintain a pointer to the last node in the merged list
            SinglyLinkedListNode current = mergedHead;

            // Merge the lists by traversing both
            while (head1 != null && head2 != null) {
                if (head1.data <= head2.data) {
                    current.next = head1;
                    head1 = head1.next;
                } else {
                    current.next = head2;
                    head2 = head2.next;
                }
                current = current.next;
            }

            // Attach the remaining elements of the list that is not yet finished
            if (head1 != null) {
                current.next = head1;
            } else {
                current.next = head2;
            }

            return mergedHead;
        }

        public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
            int count = 1;
            SinglyLinkedListNode node = llist;
            while (node != null) {
                count++;
                node = node.next;
            }
            node = llist;
            int n = 0;
            while (n < count - positionFromTail - 1) {
                node = node.next;
                n++;
            }
            return node.data;
        }

        public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
            if (llist != null) {
                SinglyLinkedListNode current = llist;
                while (current.next != null) {
                    if (current.data == current.next.data) {
                        current.next = current.next.next;
                    } else {
                        current = current.next;
                    }
                }
            }
            return llist;
        }

        static boolean hasCycle(SinglyLinkedListNode head) {
            if (head == null) return false;
            SinglyLinkedListNode slow = head;
            SinglyLinkedListNode fast = head;
            // Floyd's cycle detection algorithm for LinkedList
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) return true; // Cycle detected
            }
            return false; // No cycle
        }

        static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            SinglyLinkedListNode temp1 = head1;
            SinglyLinkedListNode temp2 = head2;
            int s1 = getLen(temp1);
            int s2 = getLen(temp2);
            if (s1 > s2) head1 = shift(head1, s1 - s2);
            else head2 = shift(head2, s2 - s1);
            while (head1 != head2) {
                head1 = head1.next;
                head2 = head2.next;
            }
            return head1.data;
        }

        private static SinglyLinkedListNode shift(SinglyLinkedListNode head, int k) {
            for (int i = 0; i < k; i++) {
                head = head.next;
            }
            return head;
        }

        private static int getLen(SinglyLinkedListNode head) {
            int size = 0;
            while (head != null) {
                size++;
                head = head.next;
            }
            return size;
        }
    }
}
class solution {
        static class DoublyLinkedListNode {
            public int data;
            public DoublyLinkedListNode next;
            public DoublyLinkedListNode prev;
            public DoublyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
                this.prev = null;
            }
        }

        static class DoublyLinkedList {
            public DoublyLinkedListNode head;
            public DoublyLinkedListNode tail;

            public DoublyLinkedList() {
                this.head = null;
                this.tail = null;
            }

            public void insertNode(int nodeData) {
                DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);
                if (this.head == null) {
                    this.head = node;
                } else {
                    this.tail.next = node;
                    node.prev = this.tail;
                }
                this.tail = node;
            }
        }
        public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
            DoublyLinkedListNode node  = new DoublyLinkedListNode(data);
            if (llist == null || data <= llist.data) {
                node.next = llist;
                if (llist != null) {
                    llist.prev = node;
                }
                return node;
            }
            DoublyLinkedListNode current = llist;
            while (current.next!=null && current.next.data<data){
                current=current.next;
            }
            node.prev=current;
            if (current.next!=null){
                current.next.prev=node;
                node.next=current.next;
                current.next=node;
                return llist;
            }
            else current.next=node;
            return llist;
        }
        public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
            if (llist==null) return null;
            DoublyLinkedListNode current  = llist.next;
            DoublyLinkedListNode head  = llist;
            while(current!=null) {
                DoublyLinkedListNode node = new DoublyLinkedListNode(current.data);
                node.next=head;
                head.prev=node;
                head=node;
                current=current.next;
            }
            return head;
        }
    }
