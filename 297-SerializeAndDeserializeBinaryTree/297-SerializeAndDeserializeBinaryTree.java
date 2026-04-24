// Last updated: 4/24/2026, 10:34:34 AM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = serializeL(root);
        String result = String.join(",",list);
        System.out.println(result);
        return result;
    }

    private List<String> serializeL(TreeNode node){
        List<String> list = new ArrayList<>();
        helper(node, list);
        return list;
    }

    private void helper(TreeNode node, List<String> list){
        if(node == null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        
        helper(node.left, list);
        helper(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        return deserializeL(list);
    }

    private TreeNode deserializeL(List<String> list){
        Collections.reverse(list);
        TreeNode node = helper2(list);
        return node;
    }

    private TreeNode helper2(List<String> list){
        String val = list.remove(list.size()-1); //first element

        if(val.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(list);
        node.right = helper2(list);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));