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
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode startingPart = dummy;

        // move startingPart before left position
        for (int i = 1; i < left; i++) {
            startingPart = startingPart.next;
        }


        ListNode leftNode = startingPart.next;

        ListNode prev = null;
        ListNode curr = leftNode;


        // reverse left to right
        for (int i = 0; i <= right - left; i++) {

            ListNode nextNode = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }


        // connect
        startingPart.next = prev;
        leftNode.next = curr;


        return dummy.next;
    }
}
// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         if (head == null || head.next == null) {
//            return head; 
//         }

//         ListNode startingPart = head;
//         ListNode prev = head.next;

//         while (prev.val != left) {
//             startingPart = startingPart.next;
//             prev = prev.next;
//         }

//         ListNode leftNode = prev;
//         ListNode curr = prev.next;
//         while (prev.val != right) {
//             ListNode nextNode = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = nextNode;
//         }

//         startingPart.next = prev;
//         leftNode.next = curr;

//         return head;
//     }
// }