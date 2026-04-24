// Last updated: 4/24/2026, 10:33:37 AM
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
    private int tilt = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        sum(root);
        return tilt;
    }
    
    private int sum(TreeNode root){
        if(root == null) return 0;

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        tilt += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}