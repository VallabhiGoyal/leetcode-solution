// Last updated: 5/21/2026, 6:40:03 AM
1class Solution {
2    public int longestCommonPrefix(int[] arr1, int[] arr2) {
3        int m = arr1.length;
4        int n = arr2.length;
5
6        String[] temp1 = Arrays.stream(arr1).mapToObj(String::valueOf).toArray(String[]::new);
7
8        String[] temp2 = Arrays.stream(arr2).mapToObj(String::valueOf).toArray(String[]::new);
9
10        TrieNode root = new TrieNode();
11
12        for(int i = 0; i<m; i++){
13            String curr = temp1[i];
14            int size = curr.length();
15
16            TrieNode node = root;
17
18            for(int j = 0; j<size; j++){
19                int ch = curr.charAt(j) - '0';
20                
21                if(node.children[ch] == null){
22                    node.children[ch] = new TrieNode();
23                }
24
25                node = node.children[ch];
26            }
27        }
28
29        int max = 0;
30
31        for(int i = 0; i<n; i++){
32            String curr = temp2[i];
33
34            TrieNode node = root;
35            int count = 0;
36
37            int size = curr.length();
38
39            for(int j = 0; j<size; j++){
40                int ch = curr.charAt(j) - '0';
41
42                if(node.children[ch] != null){
43                    count++;
44
45                    node = node.children[ch];
46                }else{
47                    break;
48                }
49            }
50
51            max = Math.max(max, count);
52        }
53
54        return max;
55    }
56
57
58    class TrieNode{
59        TrieNode[] children = new TrieNode[10];
60    }
61}