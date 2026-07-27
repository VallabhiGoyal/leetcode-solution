// Last updated: 7/27/2026, 5:41:53 AM
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
17    public boolean isValidBST(TreeNode root) {
18        return helper(root, null, null);
19    }
20
21    public boolean helper(TreeNode node, Integer low, Integer high){
22        if(node == null) return true;
23
24        if(low!=null && node.val<=low){
25            return false;
26        }
27
28        if(high!=null && node.val>=high){
29            return false;
30        }
31
32        boolean leftTree = helper(node.left,low,node.val);
33        boolean rightTree = helper(node.right,node.val,high);
34        return leftTree && rightTree;
35    }
36}