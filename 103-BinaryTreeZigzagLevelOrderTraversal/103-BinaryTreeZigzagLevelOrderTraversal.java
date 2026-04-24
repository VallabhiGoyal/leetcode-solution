// Last updated: 4/24/2026, 10:36:03 AM
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>(levelSize);

            for(int i = 0; i<levelSize; i++){
                if(leftToRight){
                    TreeNode currentNode = queue.pollFirst();
                    currLevel.add(currentNode.val);

                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }

                }else{
                    TreeNode currentNode = queue.pollLast();
                    currLevel.add(currentNode.val);

                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                }
                
            }
            leftToRight = !leftToRight;
            list.add(currLevel);       
            
        }
        return list;
    }
}