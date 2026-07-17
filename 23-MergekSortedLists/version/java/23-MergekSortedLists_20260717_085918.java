// Last updated: 7/17/2026, 8:59:18 AM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode mergeKLists(ListNode[] lists) {
13        ListNode newLL = new ListNode();
14        ListNode head = newLL;
15        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val-b.val);
16
17        for(int i = 0; i<lists.length; i++){
18            if(lists[i]!=null){
19                queue.add(lists[i]);
20            }
21        }
22
23        while(!queue.isEmpty()){
24            ListNode smallest = queue.poll();
25            newLL.next = smallest;
26            newLL = newLL.next;
27            if(smallest.next != null){
28                queue.add(smallest.next);
29            }
30            
31        }
32
33        return head.next;
34    }
35}