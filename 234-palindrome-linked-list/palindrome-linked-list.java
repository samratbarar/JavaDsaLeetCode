/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;

        while (currNode != null) {
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;

            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        return prevNode;
    }

    public ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMidNode(head);
        ListNode secondHead = reverseList(mid);
        ListNode reReversed = secondHead;

        while (head != null && secondHead != null) {
            if (head.val != secondHead.val) {
                reverseList(reReversed);
                return false;
            }

            head = head.next;
            secondHead = secondHead.next;
        }

        reverseList(reReversed);
        return true;
    }
}