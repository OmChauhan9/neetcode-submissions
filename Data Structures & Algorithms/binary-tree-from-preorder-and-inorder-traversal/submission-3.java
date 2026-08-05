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
        for(int i=0; i<n; i++){
            mp.put(inorder[i], i);
        }

        return binary(mp, preorder, 0, n-1, inorder, 0, n-1);
    }

    public TreeNode binary(HashMap<Integer, Integer> mp, int[] preorder, 
        int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
            if(preStart > preEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(preorder[preStart]);

            int inRoot = mp.get(preorder[preStart]);
            int left = inRoot - inStart;

            root.left = binary(mp, preorder, preStart + 1, preStart + left, inorder, inStart, inRoot - 1);
            root.right = binary(mp, preorder, preStart + left + 1, preEnd, inorder, inRoot + 1, inEnd);

            return root;
        }
}
