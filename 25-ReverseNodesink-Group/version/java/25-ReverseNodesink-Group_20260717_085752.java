// Last updated: 7/17/2026, 8:57:52 AM
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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        if(countNode(head)<k || head == null || k==1){
14            return head;
15        }
16        
17        ListNode prev = null;
18        ListNode pres = head;
19        ListNode fut = null;
20
21        int c = 0;
22        while(pres != null && c<k){
23            fut = pres.next;
24            pres.next = prev;
25            prev = pres;
26            pres = fut;
27            c++;
28        }
29        if(fut!=null){
30            head.next = reverseKGroup(fut,k);
31        }
32        return prev;
33    }
34
35    public int countNode(ListNode head){
36        int i = 1;
37        while(head.next!=null){
38            head = head.next;
39            i++;
40        }
41
42        return i;
43    }
44}