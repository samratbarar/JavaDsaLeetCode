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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode currNode = head;
        ListNode prevNode = null;
        boolean isReversable = true;
        ListNode checker = head;

        for (int i = 0 ; i < k; i++) {
            if (checker != null) {
                checker = checker.next;
            } else {
                isReversable = false;
            }
        }

        while (true) {
            if (!isReversable) {
                break;
            }

            ListNode last = prevNode;
            ListNode newEnd = currNode;
            ListNode nextNode = currNode.next;

            for (int i = 0; currNode != null && i < k; i++) {
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;

                if (nextNode != null) {
                    nextNode = nextNode.next;
                }

                if (checker != null) {
                    checker = checker.next;
                } else {
                    isReversable = false;
                }
            }

            if (last != null) {
                last.next = prevNode;
            } else {
                head = prevNode;
            }

            newEnd.next = currNode;

            if (currNode == null) {
                break;
            }

            prevNode = newEnd;
        }

        return head;
    }
}