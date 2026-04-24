// Last updated: 4/24/2026, 10:33:20 AM
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
    private int min;
    private long secondMin = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;

        min = root.val;
        findSecondMin(root);

        return secondMin == Long.MAX_VALUE ? -1 : (int)secondMin;
    }

    private void findSecondMin(TreeNode root){
        if(root == null) return;

        if(root.val>min && root.val<secondMin){
            secondMin = root.val;
        }

        findSecondMin(root.left);
        findSecondMin(root.right);
    }
}