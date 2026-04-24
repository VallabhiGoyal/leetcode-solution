// Last updated: 4/24/2026, 10:32:30 AM
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        List<Triplet> triplets = collectTriplets(root);
        int i = 0;
        while(i<triplets.size()){
            List<Integer> sublist = new ArrayList<>();
            int currCol = triplets.get(i).col;

            while(i<triplets.size() && triplets.get(i).col == currCol){
                
                sublist.add(triplets.get(i).val);
                i++;
            }
            list.add(sublist);
        }      
        
        return list;
    }

    public List<Triplet> collectTriplets(TreeNode root) {
        List<Triplet> triplets = new ArrayList<>();
        helper(root, 0, 0, triplets);
        Collections.sort(triplets);
        return triplets;
    } 

    public List<Triplet> helper(TreeNode node, int row, int col, List<Triplet> list){
        if(node == null) return list;

        Triplet triplet = new Triplet(node.val, row, col);
        list.add(triplet);

        helper(node.left, row+1, col-1, list);
        helper(node.right, row+1, col+1, list);

        return list;
    }

    public class Triplet implements Comparable<Triplet>{
        int val, row, col;

        Triplet(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Triplet other) {
            if (this.col != other.col) return this.col - other.col;
            if (this.row != other.row) return this.row - other.row;
            return this.val - other.val;
        }
    }
}