// Last updated: 7/27/2026, 5:40:04 AM
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
17    public void flatten(TreeNode root) {
18        if(root == null) return;
19        TreeNode node = root;
20        if(node.left!=null){
21            node = node.left;
22            while(node.right != null){
23                node = node.right;
24            }
25            node.right = root.right;
26            root.right = root.left;
27            root.left = null;
28        }
29        
30        flatten(root.right);
31    }
32}