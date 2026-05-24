// Last updated: 5/24/2026, 8:05:23 AM
1class Solution {
2    public int[] limitOccurrences(int[] nums, int k) {
3        int n = nums.length;
4
5        List<Integer> list = new ArrayList<>();
6
7        for(int i = 0; i<n; i++){
8            int count = 0;
9            int j = i;
10            while(j<n && nums[i] == nums[j]){
11
12                if(count < k){
13                    list.add(nums[i]);
14                    count++;
15                }
16                j++;
17            }
18
19            i = j-1;
20        }
21
22        int size = list.size();
23        int[] ans = new int[size];
24
25        for(int i = 0; i<size; i++){
26            ans[i] = list.get(i);
27        }
28
29        return ans;
30    }
31}