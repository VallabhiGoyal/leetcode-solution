// Last updated: 7/17/2026, 8:59:26 AM
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
12    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
13        ListNode head = new ListNode();
14        ListNode tail = head;
15        
16        while(list1 != null && list2 != null){
17            if(list1.val<list2.val){
18                tail.next = list1;
19                list1 = list1.next;
20                tail = tail.next;
21            }else{
22                tail.next = list2;
23                list2 = list2.next;
24                tail = tail.next;
25            }
26        }
27
28        tail.next = (list1 != null) ? list1 : list2;
29
30        return head.next;
31    }
32}