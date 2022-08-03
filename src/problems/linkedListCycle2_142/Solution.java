package problems.linkedListCycle2_142;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode intersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow.equals(fast)) {
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode start = head;
        ListNode intersection = intersect(head);
        if (intersection == null) {
            return null;
        }
        while (!start.equals(intersection)) {
            start = start.next;
            intersection = intersection.next;
        }
        return start;
    }
}
