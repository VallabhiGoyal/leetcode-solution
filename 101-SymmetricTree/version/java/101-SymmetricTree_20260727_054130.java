// Last updated: 7/27/2026, 5:41:30 AM
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
17    public boolean isSymmetric(TreeNode root) {
18
19        return naive(root);
20    }
21
22    public boolean naive(TreeNode root){
23        if(root == null) return true;
24        return isMirror(root.left, root.right);
25    }
26
27    public boolean isMirror(TreeNode T1, TreeNode T2){
28        if(T1 == null && T2 == null) return true;
29        if(T1 == null || T2 == null) return false;
30        if(T1.val != T2.val) return false;
31
32        return isMirror(T1.left, T2.right) && isMirror(T1.right, T2.left);
33    }
34}