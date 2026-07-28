// Last updated: 7/28/2026, 5:32:39 AM
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
16class BSTIterator {
17    List<Integer> list;
18    int idx = 0;
19
20    public BSTIterator(TreeNode root) {
21        list = new ArrayList<>();
22        inorder(root);
23
24    }
25    
26    public int next() {
27        if(idx < list.size()) return list.get(idx++);
28        return -1;
29    }
30    
31    public boolean hasNext() {
32        return idx < list.size();
33    }
34
35    public void inorder(TreeNode root){
36        if(root == null) return;
37
38        inorder(root.left);
39        list.add(root.val);
40        inorder(root.right);
41    }
42}
43
44/**
45 * Your BSTIterator object will be instantiated and called as such:
46 * BSTIterator obj = new BSTIterator(root);
47 * int param_1 = obj.next();
48 * boolean param_2 = obj.hasNext();
49 */