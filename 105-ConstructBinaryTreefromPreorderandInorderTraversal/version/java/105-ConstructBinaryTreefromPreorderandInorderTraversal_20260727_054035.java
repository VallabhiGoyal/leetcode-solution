// Last updated: 7/27/2026, 5:40:35 AM
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
17    static int index;
18    public TreeNode buildTree(int[] preorder, int[] inorder) {
19        index = 0;
20        HashMap<Integer, Integer> map = new HashMap<>();
21
22        int n = preorder.length;
23        if(n == 0) return null;
24
25        for(int i = 0; i<n; i++){
26            map.put(inorder[i], i);
27        }
28
29        return helper(preorder, inorder, 0, preorder.length -1, map);
30    }
31
32    private TreeNode helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map){
33        if(left> right){
34            return null;
35        }
36
37        int rootVal = preorder[index++];
38
39        int indexIn = map.get(rootVal);
40        TreeNode root = new TreeNode(rootVal);
41
42        root.left = helper(preorder, inorder, left, indexIn - 1, map);
43        root.right = helper(preorder, inorder,indexIn + 1 ,right, map);
44        
45        return root;
46    }
47
48}