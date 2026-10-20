// Last updated: 10/20/2026, 6:07:21 AM
1class Solution {
2    public boolean check(int[] nums, int len) {
3        int n = nums.length;
4        int minn = 0;
5        
6        for (int i = 0; i < n; i += len) {
7            if (nums[i] < minn) return false;
8            
9            int maxx = nums[i];
10            boolean point = false;
11            
12            for (int j = i + 1; j < i + len; j++) {
13                if (nums[j] < minn) return false;
14                
15                if (nums[j - 1] > nums[j]) {
16                    if (point) return false;
17                    point = true;
18                }
19                
20                maxx = Math.max(maxx, nums[j]);
21            }
22            
23            if (point) {
24                if (nums[i] < nums[i + len - 1]) return false;
25            }
26            
27            minn = maxx;
28        }
29        
30        return true;
31    }
32    
33    public int sortableIntegers(int[] nums) {
34        int n = nums.length;
35        int ans = 0;
36        
37        for (int k = 1; k <= n; k++) {
38            if (n % k != 0) continue;
39            if (check(nums, k)) ans += k;
40        }
41        
42        return ans;
43    }
44}