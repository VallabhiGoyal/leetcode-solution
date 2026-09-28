// Last updated: 9/28/2026, 9:39:23 AM
1class Solution {
2    public long maximumSumOfHeights(int[] heights) {
3        int n = heights.length;
4
5        long[] left = new long[n];
6        long[] right = new long[n];
7
8        Stack<Integer> stack = new Stack<>();
9        for (int i = 0; i < n; i++) {
10            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
11                stack.pop();
12            }
13
14            if (stack.isEmpty()) {
15                left[i] = (long) heights[i] * (i + 1);
16            } else {
17                int j = stack.peek();
18                left[i] = left[j] + (long) heights[i] * (i - j);
19            }
20
21            stack.push(i);
22        }
23
24        stack.clear();
25        for (int i = n - 1; i >= 0; i--) {
26            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
27                stack.pop();
28            }
29
30            if (stack.isEmpty()) {
31                right[i] = (long) heights[i] * (n - i);
32            } else {
33                int j = stack.peek();
34                right[i] = right[j] + (long) heights[i] * (j - i);
35            }
36
37            stack.push(i);
38        }
39
40        long max = 0;
41
42        for (int i = 0; i < n; i++) {
43            max = Math.max(max, left[i] + right[i] - heights[i]);
44        }
45
46        return max;
47    }
48}