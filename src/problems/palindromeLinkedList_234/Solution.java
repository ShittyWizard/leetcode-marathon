package problems.palindromeLinkedList_234;

// link : https://leetcode.com/problems/palindrome-linked-list/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node4 = new ListNode(1, null);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        solution.isPalindrome(node1);
    }

//    1 -> 2 -> 2 -> 1
//    3 -> 5 -> 2 -> 5 -> 3
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middle(head);
        ListNode reverse = reverse(middle);

        while (reverse != null) {
            if (reverse.val != head.val) {
                return false;
            }

            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            return slow.next;
        } else {
            return slow;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
