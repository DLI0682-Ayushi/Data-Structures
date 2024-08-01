package Collection_Map_Interface;
class ListNode {
    int val;
    Node next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class DetectCycle {
    public Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

