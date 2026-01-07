public class LinkedListProblems {

    /* ---------- Node Definition ---------- */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /* ---------- Merge Two Sorted Linked Lists (O(1) extra space) ---------- */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode head = l1;

        while (l1 != null && l2 != null) {
            ListNode prev = null;
            while (l1 != null && l1.val <= l2.val) {
                prev = l1;
                l1 = l1.next;
            }
            prev.next = l2;

            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return head;
    }

    /* ---------- Check Palindromic Linked List ---------- */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    /* ---------- Detect Cycle in Linked List ---------- */
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /* ---------- Reverse Linked List (Helper) ---------- */
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
