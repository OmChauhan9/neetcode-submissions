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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++) mp.put(inorder[i], i);

        return build(mp, preorder, 0, n-1, inorder, 0, n-1);
    }

    public TreeNode build(HashMap<Integer, Integer> mp, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preEnd < preStart || inEnd < inStart) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = mp.get(preorder[preStart]);
        int leftSide = inRoot - inStart;

        root.left = build(mp, preorder, preStart + 1, preStart + leftSide, inorder, inStart, inRoot - 1);
        root.right = build(mp, preorder, preStart + leftSide + 1, preEnd, inorder, inRoot + 1, inEnd);

        return root;
    }
}
