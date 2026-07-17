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
//     ListNode(int val, ListNode next){ this.val=val; this.next=next;}
// }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;

        while(temp != null){
            temp = temp.next;
            length++;
        }

        int finalLength = length - n;
        if(finalLength == 0) return head.next;

        temp = head;

        while(temp != null){
            finalLength--;
            if(finalLength == 0) break;
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;     
    }
}
