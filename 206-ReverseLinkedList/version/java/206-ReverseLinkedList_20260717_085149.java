// Last updated: 7/17/2026, 8:51:49 AM
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
12    public ListNode reverseList(ListNode head) {
13        if( head == null || head.next == null){
14            return head;
15        }
16        ListNode prev = null;
17        ListNode pres = head;
18        
19        while(pres != null){
20            ListNode fut = pres.next;
21            pres.next = prev;
22            prev = pres;
23            pres = fut;
24            if(fut!=null){
25                fut = fut.next;
26            }
27            
28        }
29        head = prev;
30        
31        return head;
32    }
33}