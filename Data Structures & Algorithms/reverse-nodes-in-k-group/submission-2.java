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

        ListNode nextNode = null, prevNode = null;

        while(temp != null){
            ListNode kthNode = kthNode(temp, k);

            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);

            if(temp == head){
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }

    public ListNode kthNode(ListNode head, int k){
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
