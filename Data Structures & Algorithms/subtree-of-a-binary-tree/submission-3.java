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
    boolean same;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(root.val == subRoot.val){
            if(same == true) same = true;
            else same = isSame(root, subRoot);
        }
        boolean leftN = isSubtree(root.left, subRoot);
        boolean rightN = isSubtree(root.right, subRoot);

        return leftN || rightN || same;
    }

    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        boolean leftN = isSame(root.left, subRoot.left);
        boolean rightN = isSame(root.right, subRoot.right);

        if(root.val == subRoot.val && leftN && rightN) return true;

        return false;
    }
}
