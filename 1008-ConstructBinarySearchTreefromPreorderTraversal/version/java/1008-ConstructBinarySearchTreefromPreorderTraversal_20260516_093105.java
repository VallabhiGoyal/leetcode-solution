// Last updated: 5/16/2026, 9:31:05 AM
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
17    public TreeNode bstFromPreorder(int[] preorder) {
18        int n = preorder.length;
19
20        TreeNode root = new TreeNode();
21
22        root.val = preorder[0];
23        for(int i = 1; i<n; i++){
24            helper(root, preorder[i]);
25        }
26
27        return root;
28    }
29
30    private TreeNode helper(TreeNode root, int val){
31        if(root == null){
32            TreeNode temp = new TreeNode(val);
33            return temp;
34        }
35
36        if(root.val < val){
37            root.right = helper(root.right, val);
38        }else if(root.val > val){
39            root.left = helper(root.left, val);
40        }
41
42        return root;
43    }
44}