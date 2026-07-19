// Last updated: 7/19/2026, 8:37:09 AM
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
17    int count = 0;
18    public int countDominantNodes(TreeNode root) {
19        helper(root, 0);
20
21        return count;
22    }
23
24    public int helper(TreeNode root, int currMax){
25        if(root == null) return 0;
26
27        int leftMax = helper(root.left, currMax);
28        int rightMax = helper(root.right, currMax);
29
30        currMax = Math.max(leftMax, rightMax);
31        if(root.left == null && root.right == null){
32            count++;
33        }else if(root.val >= currMax) count++;
34
35        return Math.max(root.val, currMax);
36    }
37}