public class AddTwoLists {
    public class Node {
        public int value;
        public Node next;
    }

    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public Node addTwoLists(Node n1, Node n2) {
        Node n3 = new Node();
        Node reverseN1 = reverseList(n1);
        Node reverseN2 = reverseList(n2);
        int n = 0;
        Node tmpN3 = n3;
        while (reverseN1 != null && reverseN2 != null) {
            Node tmp = new Node();
            tmp.value = (n + reverseN1.value + reverseN2.value) % 10;
            n = (n + reverseN1.value + reverseN2.value) / 10;
            tmpN3.next = tmp;
            tmpN3 = tmp;
            reverseN1 = reverseN1.next;
            reverseN2 = reverseN2.next;
        }
        while (reverseN1 != null) {
            reverseN1.value += n;
            tmpN3.next = reverseN1;
        }
        while (reverseN2 != null) {
            reverseN2.value += n;
            tmpN3.next = reverseN2;
        }
        tmpN3 = tmpN3.next;
        n = 0;
        while (tmpN3 != null) {
            tmpN3.value = (tmpN3.value + n) % 10;
            n = (tmpN3.value + n) / 10;
            next = tmpN3.next;
            if (next == null && tmpN3.value > 10) {
                Node last = new Node();
                last.value = n;
                tmpN3.next = last;
                break;
            }
            tmpN3 = next;
        }
        return reverseList(n3);
    }
}
