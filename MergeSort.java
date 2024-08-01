package Collection_Map_Interface;
class node3 {
    int val;
    node3 next;

    node3(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSort {
    public node3 mergeTwoLists(node3 l1, node3 l2) {
        node3 dummy = new node3(-1); // A conductor to lead our symphony
        node3 current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach any remaining notes (if any)
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

}

