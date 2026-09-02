// Last updated: 9/2/2026, 8:47:25 AM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int n = nums1.length;
4        if(n == 1) return true;
5        
6        int odd = 0, even = 0;
7
8        for (int num : nums1) {
9            if (num % 2 == 0) even++;
10            else odd++;
11        }
12
13        boolean MakeEven = (odd == 0) || (odd >= 2);
14
15        boolean MakeOdd = (odd > 0 && even > 0);
16
17        return MakeEven || MakeOdd;
18    }
19}