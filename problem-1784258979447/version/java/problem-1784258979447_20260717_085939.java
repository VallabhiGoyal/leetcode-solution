// Last updated: 7/17/2026, 8:59:39 AM
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
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        if(head==null || head.next==null){
14            return null;
15        }
16        if(n==0){
17            return head;
18        }
19
20        //count total nodes
21        int count = 0;
22        ListNode tail = head;
23        while(tail!=null){
24            tail=tail.next;
25            count++;
26        }
27
28        //delete first
29        if(count == n){
30            head = head.next;
31            return head;
32        }
33
34        //delete between        
35        int index = count - n ;
36        ListNode prev = head;
37        for(int i = 1; i<index; i++){
38            prev = prev.next;
39        }
40        prev.next = prev.next.next;
41
42        return head;
43    }
44    
45}