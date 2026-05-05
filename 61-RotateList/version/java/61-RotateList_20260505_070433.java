// Last updated: 5/5/2026, 7:04:33 AM
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
12    public ListNode rotateRight(ListNode head, int k) {
13        if(head == null || head.next == null || k==0){
14            return head;
15        }
16
17        ListNode curr = head;
18        int len = 1;
19        while(curr.next!=null){
20            curr = curr.next;
21            len++;
22        }
23        ListNode tail = curr;
24        tail.next = head;
25        
26        k = k%len;
27        int steps = len-k;
28        ListNode newTail = head;
29        for(int i =1; i<steps; i++){
30            newTail = newTail.next;
31        }
32        
33        ListNode newhead = newTail.next;
34        newTail.next = null;
35
36        return newhead;   
37    }
38}