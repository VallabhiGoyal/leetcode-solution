// Last updated: 7/26/2026, 7:11:13 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
12        if(root == null) return root;
13
14        if(root == p || root == q) return root;
15        TreeNode left = lowestCommonAncestor(root.left, p, q);
16        TreeNode right = lowestCommonAncestor(root.right, p, q);
17        
18        if(left != null && right != null){
19            return root;
20        }
21        
22        return (left==null)? right:left;
23
24    }
25}