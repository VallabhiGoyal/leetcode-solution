// Last updated: 7/17/2026, 8:50:53 AM
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
12    public boolean isPalindrome(ListNode head) {
13        if(head == null){
14            return true;
15        }
16
17        ListNode midNode = mid(head);
18        ListNode rev = reverse(midNode);
19
20        while(rev!=null){
21            if(head.val == rev.val){
22                head = head.next;
23                rev = rev.next;
24            }else{
25                return false;
26            }
27        }
28
29        return true;
30    }
31
32    public ListNode mid(ListNode head){
33        ListNode s = head;
34        ListNode f = head;
35        while(f!=null && f.next!=null){
36            f = f.next.next;
37            s = s.next;
38        }
39        return s;
40    }
41
42    public ListNode reverse(ListNode head){
43        if(head == null || head.next == null){
44            return head;
45        }
46
47        ListNode prev = null;
48        ListNode pres = head;
49
50        while(pres != null){
51            ListNode fut = pres.next;
52            pres.next = prev;
53            prev = pres;
54            pres = fut;
55            if(fut!=null){
56                fut = fut.next;
57            }
58            
59        }
60        head = prev;
61
62        return head;
63    }
64}