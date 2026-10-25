// Last updated: 10/25/2026, 8:59:25 AM
1class Solution {
2    public int countStaircase(int[] nums) {
3        int n = nums.length;
4
5        int ans = 0;
6
7        for(int i = 0; i<n; i++){
8            Map<Integer, Integer> map = new LinkedHashMap<>();
9            boolean valid = true;
10
11            for(int j = i; j<n; j++){
12                int curr = nums[j];
13                map.merge(curr, 1, Integer::sum);
14
15                int exp = 1;
16                valid = true;
17
18                for(int count : map.values()){
19                    if(count != exp){
20                        valid = false;
21                        break;
22                    }
23                    exp++;
24                }
25
26                if(valid) ans++;
27            }
28        }
29
30        return ans;
31    }
32}