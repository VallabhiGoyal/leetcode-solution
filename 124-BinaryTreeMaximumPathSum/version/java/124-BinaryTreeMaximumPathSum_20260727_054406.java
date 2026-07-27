// Last updated: 7/27/2026, 5:44:06 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    int ans = Integer.MIN_VALUE;
18    public int maxPathSum(TreeNode root) {
19        helper(root);
20        return ans;
21    }
22
23    private int helper(TreeNode node){
24        if(node == null) return 0;
25
26        int left = helper(node.left);
27        int right = helper(node.right);
28
29        left = Math.max(0, left);
30        right = Math.max(0, right);
31        int max = left + right + node.val;
32        
33        ans = Math.max(max, ans);
34
35        return Math.max(left, right) + node.val;
36    }
37}