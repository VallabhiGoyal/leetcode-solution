// Last updated: 4/24/2026, 10:33:41 AM
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
    int prev;
    int minDiff;

    public int getMinimumDifference(TreeNode root) {
        prev = -1;
        minDiff = Integer.MAX_VALUE;
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != -1){
            minDiff = Math.min(minDiff, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}