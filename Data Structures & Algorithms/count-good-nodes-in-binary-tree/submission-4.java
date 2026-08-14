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
    int countGood = 0;
    public int goodNodes(TreeNode root) {
        int maxNum = root.val;
        solve(root, maxNum);
        return countGood;
    }

    public void solve(TreeNode root, int maxNum){
        if(root == null) return;

        if(root.val >= maxNum){
            countGood++;
            maxNum = root.val;
        }

        solve(root.left, maxNum);
        solve(root.right, maxNum);
    }
}
