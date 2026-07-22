/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count;
    public int goodNodes(TreeNode root) {
        int max = root.val;
        check(root, max);
        return count;
    }

    public void check(TreeNode root, int max){
        if(root == null) return;

        // TreeNode leftN = check(root.left);
        // TreeNode rightN = check(root.right);
        if(root.val >= max){
            count++;
            max = root.val;
        }
        check(root.left, max);
        check(root.right, max);
    }
}
