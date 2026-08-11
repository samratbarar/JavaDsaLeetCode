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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode currNode = head;
        ListNode prevNode = null;

        for (int i = 0; currNode != null && i < left - 1; i++) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        ListNode last = prevNode;
        ListNode newEnd = currNode;
        ListNode nextNode = currNode.next;

        for (int i = 0; currNode != null && i < right - left + 1; i++) {
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;

            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        if (last != null) {
            last.next = prevNode;
        } else {
            head = prevNode;
        }

        newEnd.next = currNode;

        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode currNode = head;
        ListNode prevNode = null;
        int count = 0;

        while (true) {
            ListNode last = prevNode;
            ListNode newEnd = currNode;
            ListNode nextNode = currNode.next;

            for (int i = 0; currNode != null && i < k; i++) {
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
                count++;

                if (nextNode != null) {
                    nextNode = nextNode.next;
                }
            }

            if (last != null) {
                last.next = prevNode;
            } else {
                head = prevNode;
            }

            newEnd.next = currNode;

            if ((count % k) > 1) {
                head = reverseBetween(head, ((count - (count % k)) + 1), count);
            }

            if (currNode == null) {
                break;
            }

            prevNode = newEnd;
        }

        return head;
    }
}