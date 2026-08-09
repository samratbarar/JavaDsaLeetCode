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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = getMidNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode headFirst = head;

        while (headFirst != null && headSecond != null) {
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

        if (headFirst != null) {
            headFirst.next = null;
        }
    }
}