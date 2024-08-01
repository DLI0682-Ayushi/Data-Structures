package Collection_Map_Interface;
class node2 {
    int val;
    node2 next;

    node2(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Palindrom {
    public boolean isPalindrome(node2 head) {
        // Step 1: Find the middle of the LinkedList
        node2 slow = head;
        node2 fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the LinkedList
        node2 reversedSecondHalf = reverseList(slow);

        // Step 3: Compare the first half with the reversed second half
        while (reversedSecondHalf != null) {
            if (head.val != reversedSecondHalf.val) {
                return false; // Not a palindrome
            }
            head = head.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true; // It sings the palindrome song!
    }

    private node2 reverseList(node2 head) {
        node2 prev = null;
        while (head != null) {
            node2 next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Other heroic methods can go here!
}
