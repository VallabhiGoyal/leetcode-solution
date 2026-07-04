// Last updated: 7/4/2026, 9:13:08 AM
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
17    int max = 0;
18
19    public int longestZigZag(TreeNode root) {
20        dfs(root.right, false, 1);
21        dfs(root.left, true, 1);
22
23        return max;
24    }
25
26    public void dfs(TreeNode root, boolean isLeft, int currLen){
27        if(root == null) return;
28
29        max = Math.max(max, currLen);
30
31        if(isLeft){
32            dfs(root.right, false, currLen + 1);
33            dfs(root.left, true, 1);
34        }else{
35            dfs(root.left, true, currLen + 1);
36            dfs(root.right, false, 1);
37        }
38    }
39}