// Last updated: 7/28/2026, 3:40:26 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10
11class Solution {
12    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
13        return helper(root, p, q);
14    }
15
16    public TreeNode helper(TreeNode temp, TreeNode p, TreeNode q){
17        if(temp.val == p.val || temp.val == q.val) return temp;
18
19        if(temp.val > p.val && temp.val > q.val){
20            return helper(temp.left, p, q);
21        }else if(temp.val < p.val && temp.val < q.val){
22            return helper(temp.right, p, q);
23        }else return temp;
24    }
25}