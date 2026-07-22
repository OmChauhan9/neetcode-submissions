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

        return preOrder(mp, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public TreeNode preOrder(HashMap<Integer, Integer> mp, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode newNode = new TreeNode(preorder[preStart]);

        int inRoot = mp.get(preorder[preStart]);
        int leftSide = inRoot - inStart;

        newNode.left = preOrder(mp, preorder, preStart + 1, preStart + leftSide, inorder, inStart, inRoot - 1);
        newNode.right = preOrder(mp, preorder, preStart + leftSide + 1, preEnd, inorder, inRoot + 1, inEnd);

        return newNode;
    }
}
