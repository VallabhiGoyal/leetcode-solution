// Last updated: 7/5/2026, 9:15:55 AM
1class Trie {
2    TrieNode root;
3    public Trie() {
4        root = new TrieNode(new TrieNode[26], false);
5    }
6    
7    public void insert(String word) {
8        TrieNode curr = root;
9
10        int n = word.length();
11        
12        for(int i = 0; i<n; i++){
13            int idx = word.charAt(i) - 'a';
14            
15            if(curr.children[idx] == null){
16                curr.children[idx] = new TrieNode(new TrieNode[26], false);
17            }
18
19            curr = curr.children[idx];
20        }
21
22        curr.isEnd = true;
23    }
24    
25    public boolean search(String word) {
26        TrieNode curr = root;
27
28        int n = word.length();
29        
30        for(int i = 0; i<n; i++){
31            int idx = word.charAt(i) - 'a';
32            
33            if(curr.children[idx] == null){
34                return false;
35            }
36
37            curr = curr.children[idx];
38        }
39
40        return curr.isEnd;
41    }
42    
43    public boolean startsWith(String prefix) {
44        TrieNode curr = root;
45
46        int n = prefix.length();
47        
48        for(int i = 0; i<n; i++){
49            int idx = prefix.charAt(i) - 'a';
50            
51            if(curr.children[idx] == null){
52                return false;
53            }
54
55            curr = curr.children[idx];
56        }
57
58        return true;
59    }
60}
61
62class TrieNode{
63    TrieNode[] children;
64    boolean isEnd;
65
66    TrieNode(TrieNode[] children, boolean isEnd){
67        this.children = children;
68        this.isEnd = isEnd;
69    }
70}
71
72/**
73 * Your Trie object will be instantiated and called as such:
74 * Trie obj = new Trie();
75 * obj.insert(word);
76 * boolean param_2 = obj.search(word);
77 * boolean param_3 = obj.startsWith(prefix);
78 */