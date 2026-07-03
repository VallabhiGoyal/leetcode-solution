// Last updated: 7/3/2026, 11:37:14 AM
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<n; i++){
            int currParent = descriptions[i][0];
            int currChild = descriptions[i][1];
            int isLeft = descriptions[i][2];

            TreeNode parent;
            if(!map.containsKey(currParent)){
                parent = new TreeNode(currParent);

                map.put(currParent, parent);
            }else{
                parent = map.get(currParent);
            }

            TreeNode child;
            if(!map.containsKey(currChild)){
                child = new TreeNode(currChild);

                map.put(currChild, child);
            }else{
                child = map.get(currChild);
            }

            if(isLeft == 1){
                parent.left = child;
            }else{
                parent.right = child;
            }

            set.add(currChild);
        }

        int size = map.size();

        for(int key : map.keySet()){
            if(!set.contains(key)) return map.get(key);
        }

        return null;
    }
}