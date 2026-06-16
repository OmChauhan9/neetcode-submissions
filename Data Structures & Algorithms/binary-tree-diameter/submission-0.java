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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        dBt(root, arr);
        return arr[0];
    }

    public int dBt(TreeNode root, int[] arr){
        if(root == null){
            return 0;
        }

        int left = dBt(root.left, arr);
        int right = dBt(root.right, arr);
        arr[0] = Math.max(left + right, arr[0]);

        return 1 + Math.max(left,right);

    }
}
