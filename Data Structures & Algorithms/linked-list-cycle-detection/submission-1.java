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
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> mpp = new HashMap<>();

        ListNode temp = head;

        while(temp != null){
            if(mpp.containsKey(temp)){
                return true;
            }
            else{
                mpp.put(temp, mpp.getOrDefault(temp,0) + 1);
                temp = temp.next;
            }
        }
        return false;
    }
}
