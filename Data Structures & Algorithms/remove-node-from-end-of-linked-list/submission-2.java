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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // int cnt = 0;
        // ListNode temp = head;

        // while(temp != null){
        //     cnt++;
        //     temp = temp.next;
        // }

        // if(cnt == n){
        //     ListNode newH = head.next;
        //     return newH;
        // }

        // int res = cnt - n;
        // temp = head;

        // while(temp != null){
        //     res--;
        //     if(res == 0){
        //         break;
        //     }
        //     temp = temp.next;
        // }

        // ListNode delN = temp.next;  
        // temp.next = temp.next.next;
        // return head;

        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // if (head == null) {
        //     return head;
        // }

        // if (head.next == null) {
        //     return (n == 1) ? null : head;
        // }   

        // ListNode fast = head

        for(int i = 0; i<n; i++){
            fast = fast.next;
        }

        // ListNode slow = head;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode delN = slow.next;
        slow.next = slow.next.next;
        return dummy.next;
    }
}
