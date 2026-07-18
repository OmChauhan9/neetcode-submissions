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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i=0; i<lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.remove();
            temp.next = node;
            temp = temp.next;

            node = node.next;
            if(node != null){
                pq.add(node);
            }
        }

        return dummy.next;
    }
}
