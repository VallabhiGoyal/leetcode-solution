// Last updated: 8/10/2026, 10:35:36 AM
1class Solution {
2    public long lastInteger(long n) {
3        return helper(1, 1, true, n);
4    }
5
6    public long helper(long head, long steps, boolean isLeft, long remain) {
7        if (remain == 1) return head;
8
9        if (!isLeft && remain % 2 == 0) {
10            head += steps;
11        }
12
13        return helper(head, steps * 2, !isLeft, (remain+1) / 2);
14    }
15}