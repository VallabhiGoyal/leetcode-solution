// Last updated: 10/22/2026, 6:31:16 AM
1class Solution {
2    public int minOperations(int[] nums) {
3        int n = nums.length;
4
5        int minOp = Integer.MAX_VALUE;
6
7        int pivot = -1;
8        for (int i = 0; i < n; i++) {
9            if (nums[i] == 0) {
10                pivot = i;
11                break;
12            }
13        }
14
15        if (pivot == -1) return -1;
16
17        int flag = 1;
18        for (int i = 0; i < n; i++) {
19            if (nums[(i + 1) % n] != (nums[i] + 1) % n) {
20                flag = 0;
21                break;
22            }
23        }
24
25        if (flag == 1) {
26            minOp = Math.min(pivot, n - pivot + 2);
27        }
28
29        flag = 1;
30        for (int i = 0; i < n; i++) {
31            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) {
32                flag = 0;
33                break;
34            }
35        }
36
37        if (flag == 1) {
38            minOp = Math.min(minOp, Math.min(pivot + 2, n - pivot));
39        }
40
41        if (minOp == Integer.MAX_VALUE) return -1;
42
43        return minOp;
44    }
45}