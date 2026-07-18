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

// class ListNode{
//     int val;
//     ListNode next;

//     ListNode(){}
//     ListNode(int val){ this.val = val;}
//     ListNode(int val, ListNode next){ this.val = val; this.next = next;}
// }

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;

        for(int i=1; i<left; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for(int i=left; i<right; i++){
            ListNode front = curr.next;
            curr.next = front.next;
            front.next = prev.next;
            prev.next = front;
        }

        return dummy.next;
    }
}