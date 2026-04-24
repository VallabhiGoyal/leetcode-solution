// Last updated: 4/24/2026, 10:36:06 AM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q ==null) return true;
        if((p == null && q!=null) || (p!=null && q == null)) return false;
        Queue<TreeNode> qP = new LinkedList<>();
        Queue<TreeNode> qQ = new LinkedList<>();
        qP.offer(p);
        qQ.offer(q);
        while(!qP.isEmpty() || !qQ.isEmpty()){
            TreeNode currP = qP.poll();
            TreeNode currQ = qQ.poll();
            if(currP.val != currQ.val){
                return false;
            }
            if(currP.left != null && currQ.left != null){
                qP.offer(currP.left);
                qQ.offer(currQ.left);
            }else if((currP.left == null && currQ.left!=null) || (currP.left != null && currQ.left == null)){
                return false;
            }

            if(currP.right != null && currQ.right != null){
                qP.offer(currP.right);
                qQ.offer(currQ.right);
            }else if((currP.right == null && currQ.right!=null) || (currP.right != null && currQ.right == null)){
                return false;
            }
        }

        return true;
    }
}