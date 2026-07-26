// Last updated: 7/26/2026, 7:10:32 AM
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
17    private int k;
18    private int ans;
19    public int kthSmallest(TreeNode root, int k) {
20        this.k = k;
21        helper(root);
22        return ans;
23    }
24
25    private void helper(TreeNode node){
26        if(node == null) return;
27
28        helper(node.left);  //left
29        
30        k--;
31        if(k==0){
32            ans = node.val;
33            return;
34        }
35
36        helper(node.right); //right
37
38    }
39}