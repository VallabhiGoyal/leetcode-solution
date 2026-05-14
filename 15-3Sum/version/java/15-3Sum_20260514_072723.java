// Last updated: 5/14/2026, 7:27:23 AM
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        int n = nums.length;
4
5        Arrays.sort(nums);
6
7        Set<List<Integer>> set = new HashSet<>();
8
9        for(int i = 0; i<n; i++){
10            int curr = nums[i];
11
12            int k = n-1;
13            int j = i+1;
14
15            while(j<k){
16
17                if(j == k) break;
18
19                int sum = curr + nums[j] + nums[k];
20
21                if(sum == 0){
22                    List<Integer> currList = new ArrayList<>();
23
24                    currList.add(curr);
25                    currList.add(nums[j]);
26                    currList.add(nums[k]);
27
28                    set.add(new ArrayList<>(currList));
29                    j++;
30                    k--;
31                }else if(sum > 0){
32                    k--;
33                }else{
34                    j++;
35                }
36                sum -= (nums[j] + nums[k]);
37            }
38        }
39
40        List<List<Integer>> ans = new ArrayList<>(set);
41        return ans;
42    }
43}