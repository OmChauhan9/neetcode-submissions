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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            mp.put(inorder[i], i);
        }

        return postOrder(mp, postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode postOrder(HashMap<Integer, Integer> mp, int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd){
        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode newNode = new TreeNode(postorder[postEnd]);

        int inRoot = mp.get(postorder[postEnd]);
        int leftSide = inRoot - inStart;

        newNode.left = postOrder(mp, postorder, postStart, postStart + leftSide - 1, inorder, inStart, inRoot - 1);
        newNode.right = postOrder(mp, postorder, postStart + leftSide, postEnd - 1, inorder, inRoot + 1, inEnd);

        return newNode;
    }
}