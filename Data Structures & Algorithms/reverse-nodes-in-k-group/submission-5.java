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
        ListNode temp = head;
        ListNode curr = null, prev = null;

        while(temp != null){
            ListNode kth = findKth(temp, k);

            if(kth == null){
                if(prev != null) prev.next = curr;
                break;
            }

            curr = kth.next;
            kth.next = null;
            reverse(temp);

            if(temp == head){
                head = kth;
            }else{
                prev.next = kth;
            }

            prev = temp;
            temp = curr;
        }

        return head;
    }

    private ListNode findKth(ListNode head, int k){
        ListNode temp = head;
        for(int i=0; i<k-1; i++){
            if(temp == null) return null;
            temp = temp.next;
        }

        return temp;
    }

    private void reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
    }
}
