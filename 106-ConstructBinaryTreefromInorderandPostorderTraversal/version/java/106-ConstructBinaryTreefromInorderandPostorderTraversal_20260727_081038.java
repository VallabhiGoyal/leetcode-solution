// Last updated: 7/27/2026, 8:10:38 AM
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
17    Map<Integer, Integer> map;
18    int postIdx;
19    public TreeNode buildTree(int[] inorder, int[] postorder) {
20        map = new HashMap<>();
21
22        int n = inorder.length;
23        postIdx = n-1;
24
25        for(int i = 0; i<n; i++){
26            map.put(inorder[i], i);
27        }
28
29        return helper(inorder, postorder, 0, n-1);
30    }
31
32    public TreeNode helper(int[] inorder, int[] postorder, int inLeft, int inRight){
33
34        if(inLeft > inRight) return null;
35
36        TreeNode node = new TreeNode(postorder[postIdx]);
37        postIdx--;
38        
39        int idx = map.get(postorder[postIdx + 1]);
40
41        node.right = helper(inorder, postorder, idx + 1, inRight);
42        node.left = helper(inorder, postorder, inLeft, idx - 1);
43
44        return node;
45    }
46}