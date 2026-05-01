// Last updated: 5/1/2026, 9:48:18 AM
1class Solution {
2    public List<Integer> findValidElements(int[] nums) {
3        int n = nums.length;
4
5        int[] prefix = new int[n];
6        prefix[0] = nums[0];
7        for(int i = 1; i<n; i++){
8            prefix[i] = Math.max(prefix[i-1], nums[i]);
9        }
10
11        int[] suffix = new int[n];
12        suffix[n-1] = nums[n-1];
13        for(int i = n-2; i>=0; i--){
14            suffix[i] = Math.max(suffix[i+1], nums[i]);
15        }
16
17        List<Integer> list = new ArrayList<>();
18        for(int i = 0; i<n; i++){
19            if(i == 0 || i == n-1){
20                list.add(nums[i]);
21            }else if(prefix[i-1] < nums[i] || suffix[i+1] < nums[i]) list.add(nums[i]);
22        }
23
24        return list;
25    }
26}