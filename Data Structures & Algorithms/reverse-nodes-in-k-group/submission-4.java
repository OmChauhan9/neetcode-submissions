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
        ListNode prevNode = null;
        ListNode nextNode = null;

        while(temp != null){
            ListNode kth = findKth(temp, k);

            if(kth == null){
                if(nextNode != null) prevNode.next = nextNode;
                break;
            }

            nextNode = kth.next;
            kth.next = null;
            reverse(temp);

            if(temp == head){
                head = kth;
            }else{
                prevNode.next = kth;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }

    public ListNode findKth(ListNode head, int k){
        ListNode temp = head;
        for(int i=0; i<k-1; i++){
            if(temp == null) return null;
            temp = temp.next;
        }
        return temp;
    }

    public void reverse(ListNode head){
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
