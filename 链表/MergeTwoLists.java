// 合并两个有序链表

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
class MergeTwoLists{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        System.out.print(mergeTwoLists(l1, l2));
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }else if(l2 != null){
            cur.next = l2;
        }
        return dummyNode;
    }
}