// Last updated: 8/3/2026, 11:11:00 AM
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
12    public ListNode insertionSortList(ListNode head) {
13        List<Integer> list = new ArrayList<>();
14
15        while(head != null){
16            list.add(head.val);
17            head = head.next;
18        }
19
20        Collections.sort(list);
21
22        ListNode demo = new ListNode(list.get(0));
23        ListNode temp = demo;
24
25        int n = list.size();
26        for(int i = 1; i<n; i++){
27            temp.next = new ListNode(list.get(i));
28            temp = temp.next;
29        }
30
31        return demo;
32    }
33
34}