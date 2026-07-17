// Last updated: 7/17/2026, 8:55:23 AM
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
12    public ListNode sortList(ListNode head) {
13        if(head==null || head.next == null){
14            return head;
15        }
16
17        ListNode mid = midNode(head);
18        ListNode rightHead = mid.next;
19        mid.next = null; 
20
21        ListNode left = sortList(head);
22        ListNode right = sortList(rightHead);
23
24        return merge(left, right);
25
26    }
27
28    private ListNode merge(ListNode l1, ListNode l2){
29        ListNode dummy = new ListNode(0);
30        ListNode tail = dummy;
31
32        while(l1!=null && l2!=null){
33            if(l1.val<l2.val){
34                tail.next = l1;
35                l1=l1.next;
36            }else{
37                tail.next = l2;
38                l2 = l2.next;
39            }
40
41            tail = tail.next;
42        }
43
44        if(l1!=null) tail.next = l1;
45        if(l2!=null) tail.next = l2;
46
47        return dummy.next;
48    }
49
50    private ListNode midNode(ListNode head){
51        ListNode s = head;
52        ListNode f = head;
53        ListNode prev = null;
54
55        while(f!= null && f.next != null){
56            prev = s;
57            s = s.next;
58            f = f.next.next;
59        }
60
61        return prev;
62    }
63}