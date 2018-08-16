class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
class ReverseList{
// 非递归
public ListNode reverseList1(ListNode head) {
    ListNode prev = null;
    while(head!=null){
        ListNode tmp = head.next;
        head.next = prev;
        prev = head;
        head = tmp;
    }
    return prev;
}
// 递归
public ListNode reverseList2(ListNode head) {
    if(head==null||head.next ==null)
        return head;
    ListNode prev = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    return prev;
}
}