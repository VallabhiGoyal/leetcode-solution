// Last updated: 7/7/2026, 10:42:54 AM
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        int n = nums.length;
4
5        Arrays.sort(nums);
6
7        List<List<Integer>> ans = new ArrayList<>();
8
9        for(int i = 0; i<n; i++){
10            int curr = nums[i];
11
12            if(i>0 && nums[i] == nums[i-1]) continue;
13
14            int k = n-1;
15            int j = i+1;
16
17            while(j<k){
18
19                if(j == k) break;
20
21                int sum = curr + nums[j] + nums[k];
22
23                if(sum == 0){
24                    List<Integer> currList = new ArrayList<>();
25
26                    currList.add(curr);
27                    currList.add(nums[j]);
28                    currList.add(nums[k]);
29
30                    ans.add(new ArrayList<>(currList));
31
32                    j++;
33                    k--;
34
35                    while(j<k && nums[j] == nums[j-1]) j++;
36                    while(j<k && nums[k] == nums[k+1]) k--;
37
38                }else if(sum > 0){
39                    k--;
40                }else{
41                    j++;
42                }
43                sum -= (nums[j] + nums[k]);
44            }
45        }
46
47        return ans;
48    }
49}