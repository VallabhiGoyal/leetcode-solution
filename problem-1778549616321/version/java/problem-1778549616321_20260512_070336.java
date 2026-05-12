// Last updated: 5/12/2026, 7:03:36 AM
1class Solution {
2    public long minArraySum(int[] nums) {
3        int n = nums.length;
4
5        Map<Integer, Integer> map = new HashMap<>();
6
7        for(int i = 0; i<n; i++){
8            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
9        }
10
11        long sum = 0;
12        for(int i = 0; i<n; i++){
13            int curr = nums[i];
14
15            for(int j = 1; j*j <= curr; j++){
16                if(curr % j == 0){
17                    if(map.containsKey(j)){
18                        nums[i] = Math.min(nums[i], j);
19                    }
20
21                    int temp = curr/j;
22                    if(map.containsKey(temp)){
23                        nums[i] = Math.min(nums[i], temp);
24                    }
25                }
26            }
27
28            sum += nums[i];
29        }
30
31        return sum;
32    }
33}