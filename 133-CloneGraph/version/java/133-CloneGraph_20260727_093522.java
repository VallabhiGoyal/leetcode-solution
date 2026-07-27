// Last updated: 7/27/2026, 9:35:22 AM
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>();
9    }
10    public Node(int _val) {
11        val = _val;
12        neighbors = new ArrayList<Node>();
13    }
14    public Node(int _val, ArrayList<Node> _neighbors) {
15        val = _val;
16        neighbors = _neighbors;
17    }
18}
19*/
20
21class Solution {
22    Map<Node, Node> map;
23    public Node cloneGraph(Node node) {
24        map = new HashMap<>();
25
26        return helper(node);
27    }
28
29    public Node helper(Node node){
30        if(node == null) return null;
31
32        if(map.containsKey(node)) return map.get(node);
33
34        Node copy = new Node(node.val);
35        map.put(node, copy);
36
37        List<Node> curr = node.neighbors;
38
39        for(Node n : curr){
40            Node clonedNei =  helper(n);
41            copy.neighbors.add(clonedNei);
42        }
43
44        return copy;        
45    }
46}