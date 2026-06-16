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
        if (head == null || head.next == null) {
            return false;
        }
        // Map<ListNode, Integer> mpp = new HashMap<>();
        Set<ListNode> st = new HashSet<>();

        ListNode temp = head;

        while(temp != null){
            if(st.contains(temp)){
                return true;
            }
            // else{
                // mpp.put(temp, mpp.getOrDefault(temp,0) + 1);
                st.add(temp);
                temp = temp.next;
            // }
        }
        return false;
    }
}
