class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class ListRingLength {
    public int getRingLength(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return getLength(fast);
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return 0;
    }

    public int getLength(ListNode l) {
        int length = 1;
        ListNode cur = l;
        while (cur.next != l) {
            cur = cur.next;
            length++;
        }
        return length;
    }
}