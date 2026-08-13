// Last updated: 8/13/2026, 2:29:00 PM
1class Solution {
2    Node[] tree;
3    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
4        int k = queryIndices.length;
5
6        char[] ch = s.toCharArray();
7
8        int n = s.length();
9        tree = new Node[4*n];
10
11        build( 1, 0, n-1, ch);
12
13        int[] ans = new int[k];
14        for(int i = 0; i<k; i++){
15
16            update(1, 0, n-1, queryIndices[i], queryCharacters.charAt(i));
17
18            ans[i] = tree[1].maxLen;
19        }
20
21        return ans;
22    }
23
24    public void update(int node, int left, int right, int idx, char newChar){
25        if(left == right){
26            tree[node] = new Node(newChar, newChar, 1, 1, 1, 1);
27            return;
28        }
29
30        int mid = left + (right - left)/2;
31        
32        if(idx <= mid){
33            update(2*node, left, mid, idx, newChar);
34        }else{
35            update(2*node+1, mid+1, right, idx, newChar);
36        }
37
38        tree[node] = merge(tree[2*node], tree[2*node+1]);
39    }
40
41    public void build(int node, int left, int right, char[] ch){
42        if(left == right){
43            tree[node] = new Node(ch[left], ch[left], 1, 1, 1,1);
44            return;
45        }
46
47        int mid = left + (right - left)/2;
48
49        build(2*node, left, mid, ch);
50        build(2*node+1, mid + 1, right, ch);
51
52        tree[node] = merge(tree[2*node], tree[2*node+1]);
53    }
54
55    public Node merge(Node left, Node right){
56        char firstChar = left.firstChar;
57        char lastChar = right.lastChar;
58
59        int prefixLen = left.prefixLen;
60        int suffixLen = right.suffixLen;
61        int maxLen;
62
63        if(left.lastChar == right.firstChar){
64
65            if(left.suffixLen == left.totalLen){
66                prefixLen = left.totalLen + right.prefixLen;
67            }
68
69            if(right.suffixLen == right.totalLen){
70                suffixLen = left.suffixLen + right.totalLen;
71            }
72
73            maxLen = Math.max(left.maxLen, Math.max(right.maxLen, left.suffixLen + right.prefixLen));
74        }else{
75            maxLen = Math.max(left.maxLen, right.maxLen);
76        }
77        int totalLen = left.totalLen + right.totalLen;
78
79        return new Node(firstChar, lastChar, prefixLen, suffixLen, maxLen, totalLen);
80    }
81
82    class Node{
83        char firstChar;
84        char lastChar;
85        int prefixLen;
86        int suffixLen;
87        int maxLen;
88        int totalLen;
89
90        Node(char firstChar, char lastChar, int prefixLen, int suffixLen, int maxLen, int totalLen){
91            this.firstChar = firstChar;
92            this.lastChar = lastChar;
93            this.prefixLen = prefixLen;
94            this.suffixLen = suffixLen;
95            this.maxLen = maxLen;
96            this.totalLen = totalLen;
97        }
98    }
99}