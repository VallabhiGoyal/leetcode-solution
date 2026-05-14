// Last updated: 5/14/2026, 7:26:20 AM
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
12            List<Integer> currList = new ArrayList<>();
13            currList.add(curr);
14
15            int k = n-1;
16            int j = i+1;
17            while(j<k){
18                if(j == k) break;
19
20                int sum = curr + nums[j] + nums[k];
21
22                if(sum == 0){
23                    currList.add(nums[j]);
24                    currList.add(nums[k]);
25
26                    set.add(new ArrayList<>(currList));
27
28                    currList.remove(currList.size()-1);
29                    currList.remove(currList.size()-1);
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