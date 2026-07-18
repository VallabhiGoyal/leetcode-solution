// Last updated: 7/18/2026, 10:40:26 AM
1/*
2// Definition for a Node.
3class Node {
4    int val;
5    Node next;
6    Node random;
7
8    public Node(int val) {
9        this.val = val;
10        this.next = null;
11        this.random = null;
12    }
13}
14*/
15
16class Solution {
17    public Node copyRandomList(Node head) {
18        if (head == null) return null;
19
20        Map<Node, Node> map = new HashMap<>();
21
22        Node head1 = new Node(head.val);
23        map.put(head, head1);
24
25        Node ans = head1;
26        Node temp = head.next;
27
28        while (temp != null) {
29            ans.next = new Node(temp.val);
30            ans = ans.next;
31            map.put(temp, ans);
32            temp = temp.next;
33        }
34
35        ans = head1;
36        temp = head;
37
38        while (temp != null) {
39            if (temp.random != null) {
40                ans.random = map.get(temp.random);
41            }
42            temp = temp.next;
43            ans = ans.next;
44        }
45
46        return head1;
47    }
48}