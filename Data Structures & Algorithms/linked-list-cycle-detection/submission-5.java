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
        HashMap<ListNode,Integer> mp = new HashMap<>();
        ListNode temp = head;

        while(temp != null){
            if(mp.containsKey(temp)){
                return true;
            } else {
                mp.put(temp, mp.getOrDefault(temp,0) + 1);
                temp = temp.next;
            }
        }
        return false;
    }
}
