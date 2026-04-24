// Last updated: 4/24/2026, 10:32:37 AM
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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        rangeSum(root, low, high);
        return sum;

    }

    private void rangeSum(TreeNode root, int low, int high){
        if(root == null) return;

        if(root.val >= low){
            rangeSum(root.left, low, high);
        }

        if(root.val <= high){
            rangeSum(root.right, low, high);
        }

        if(root.val>= low && root.val <=high){
            sum += root.val;
        }
    }

}