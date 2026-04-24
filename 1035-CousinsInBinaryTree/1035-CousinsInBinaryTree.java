// Last updated: 4/24/2026, 10:32:29 AM
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
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for(int i = 0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.val == x) foundX = true;
                if(currentNode.val == y) foundY = true;

                //siblings
                if(currentNode.left!= null && currentNode.right!=null){
                    if((currentNode.left.val == x && currentNode.right.val == y) || (currentNode.left.val == y && currentNode.right.val == x)){
                        return false;
                    }
                }

                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            if(foundX && foundY) return true;
            if(foundX || foundY) return false;
        }

        return false;
    }
}