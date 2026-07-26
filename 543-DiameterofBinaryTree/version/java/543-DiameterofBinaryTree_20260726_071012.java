// Last updated: 7/26/2026, 7:10:12 AM
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
17    int diameter = 0;
18    public int diameterOfBinaryTree(TreeNode root) {
19        height(root);
20
21        return diameter ;
22    }
23
24    public int height(TreeNode node){
25        if(node == null) return 0;
26
27        int leftHeight = height(node.left);
28        int rightHeight = height(node.right);
29
30        int dia = leftHeight + rightHeight;
31        diameter = Math.max(diameter, dia);
32
33        return Math.max(leftHeight, rightHeight) + 1;
34    }
35}