// Last updated: 7/3/2026, 11:36:45 AM
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        String[] temp1 = Arrays.stream(arr1).mapToObj(String::valueOf).toArray(String[]::new);

        String[] temp2 = Arrays.stream(arr2).mapToObj(String::valueOf).toArray(String[]::new);

        TrieNode root = new TrieNode();

        for(int i = 0; i<m; i++){
            String curr = temp1[i];
            int size = curr.length();

            TrieNode node = root;

            for(int j = 0; j<size; j++){
                int ch = curr.charAt(j) - '0';
                
                if(node.children[ch] == null){
                    node.children[ch] = new TrieNode();
                }

                node = node.children[ch];
            }
        }

        int max = 0;

        for(int i = 0; i<n; i++){
            String curr = temp2[i];

            TrieNode node = root;
            int count = 0;

            int size = curr.length();

            for(int j = 0; j<size; j++){
                int ch = curr.charAt(j) - '0';

                if(node.children[ch] != null){
                    count++;

                    node = node.children[ch];
                }else{
                    break;
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }


    class TrieNode{
        TrieNode[] children = new TrieNode[10];
    }
}