// Last updated: 7/17/2026, 8:53:06 AM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
14        if(headA==null || headB == null){
15            return null;
16        }
17
18        ListNode listA = headA;
19        ListNode listB = headB;
20        
21        while(listA!=listB){
22            listA = (listA == null) ? headB:listA.next;
23            listB = (listB == null) ? headA:listB.next;
24        }
25        return listA;
26    }
27}