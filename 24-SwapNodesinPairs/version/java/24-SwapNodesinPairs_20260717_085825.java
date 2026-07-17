// Last updated: 7/17/2026, 8:58:25 AM
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
12    public ListNode swapPairs(ListNode head) {
13        if(head == null || head.next == null){
14            return head;
15        }
16        ListNode dummy = new ListNode(0);
17        dummy.next = head;
18
19        ListNode prev = dummy;
20
21        while(prev.next!=null && prev.next.next!=null){
22            ListNode first = prev.next;
23            ListNode second = prev.next.next;
24
25            //swapping
26            first.next = second.next;
27            second.next = first;
28            prev.next = second;
29
30            prev = first;
31        }
32
33        return dummy.next;
34    }
35}