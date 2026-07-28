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
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            mp.put(inorder[i], i);
        }

        return build(mp, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(HashMap<Integer, Integer> mp, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preEnd < preStart || inEnd < inStart) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = mp.get(preorder[preStart]);
        int left = inRoot - inStart;

        root.left = build(mp, preorder, preStart + 1, preStart + left, inorder, inStart, inRoot - 1);
        root.right = build(mp, preorder, preStart + left + 1, preEnd, inorder, inRoot + 1, inEnd);

        return root;
    }
}
