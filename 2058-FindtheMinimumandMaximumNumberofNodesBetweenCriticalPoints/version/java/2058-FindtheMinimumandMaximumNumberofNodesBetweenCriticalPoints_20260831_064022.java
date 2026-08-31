// Last updated: 8/31/2026, 6:40:22 AM
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
17
18        int i = 1;
19        while(temp.next != null && temp.next.next != null){
20            prev = temp;
21            temp = temp.next;
22
23            if((prev.val > temp.val && temp.val < temp.next.val) || (prev.val < temp.val && temp.val > temp.next.val)){
24                criticalPoint.add(i);
25            }
26
27            i++;
28        }
29
30        int size = criticalPoint.size();
31
32        if(size < 2){
33            return new int[]{-1, -1};
34        }
35
36        int minDist = Integer.MAX_VALUE;
37        int maxDist = criticalPoint.get(size - 1) - criticalPoint.get(0);
38
39        for(i = 1; i<size; i++){
40            minDist = Math.min(minDist, criticalPoint.get(i) - criticalPoint.get(i-1));
41        }
42
43        return new int[]{minDist, maxDist};
44    }
45}