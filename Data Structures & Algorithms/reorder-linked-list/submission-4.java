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
//     ListNode(int val){this.val = val;}
//     ListNode(int val, ListNode next){this.val = val; this.next = next;}
// }

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        ListNode temp1 = head;
        ListNode temp2 = prev;
        ListNode dummy = new ListNode(-1);
        ListNode temp3 = dummy;

        while(temp1 != null){
            temp3.next = temp1;
            ListNode front1 = temp1.next;
            ListNode front2 = temp2.next;

            temp1.next = temp2;
            temp1 = front1;
            temp2.next = temp1;
            temp2 = front2;
        }
    }
}