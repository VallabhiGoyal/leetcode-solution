// Last updated: 4/24/2026, 10:31:48 AM
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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return good(root, root.val);
    }

    private int good(TreeNode root, int max){
        if(root == null) return 0;
        int count = 0;
        if(root.val >= max){
            max = root.val;
            count++;
        }
        return count + good(root.left, max) + good(root.right, max);
    }
}