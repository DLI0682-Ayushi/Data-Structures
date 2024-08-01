package Collection_Map_Interface;
class node1 {
    int val;
    node1 next;

    node1(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Intersection {
    public node1 getIntersectionNode(node1 headA, node1 headB) {
        node1 currA = headA;
        node1 currB = headB;

        // Traverse both lists until they meet (or reach null)
        while (currA != currB) {
            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;
        }

        return currA; // The mystical intersection reveals itself!
    }

    // Other heroic methods can go here!
}

