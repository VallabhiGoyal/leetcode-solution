// Last updated: 8/31/2026, 6:37:15 AM
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
12    public int[] nodesBetweenCriticalPoints(ListNode head) {
13        List<Integer> criticalPoint = new ArrayList<>();
14
15        ListNode temp = head;
16        ListNode prev = null;
17        ListNode next = null;
18
19        int i = 1;
20        while(temp.next != null && temp.next.next != null){
21            prev = temp;
22            temp = temp.next;
23
24            if(prev.val > temp.val && temp.val < temp.next.val){
25                criticalPoint.add(i);
26            }else if(prev.val < temp.val && temp.val > temp.next.val){
27                criticalPoint.add(i);
28            }
29
30            i++;
31        }
32
33        int size = criticalPoint.size();
34
35        if(size < 2){
36            return new int[]{-1, -1};
37        }
38
39        int minDist = Integer.MAX_VALUE;
40        int maxDist = criticalPoint.get(size - 1) - criticalPoint.get(0);
41
42        for(i = 1; i<size; i++){
43            minDist = Math.min(minDist, criticalPoint.get(i) - criticalPoint.get(i-1));
44        }
45
46        return new int[]{minDist, maxDist};
47    }
48}