package problems.mergeTwoSortedList_21;

// link : https://leetcode.com/problems/merge-two-sorted-lists/
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode(0);
        ListNode result = merged;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merged.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                merged.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            merged = merged.next;
        }

        while (list1 != null) {
            merged.next = new ListNode(list1.val);
            merged = merged.next;
            list1 = list1.next;
        }
         while (list2 != null) {
             merged.next = new ListNode(list2.val);
             merged = merged.next;
             list2 = list2.next;
         }

        return result.next;
    }
}
