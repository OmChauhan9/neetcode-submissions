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
//     ListNode(int val){ this.val = val;}
//     ListNode(int val, ListNode next){ this.val = val; this.next = next;}
// }

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        HashSet<ListNode> st = new HashSet<>();
        ListNode temp = head;

        while(temp != null){
            if(st.contains(temp)) return true;
            st.add(temp);
            temp = temp.next;
        }

        return false;
    }
}
