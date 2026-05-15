// Last updated: 5/15/2026, 6:52:39 AM
1class Solution {
2    public List<List<Integer>> fourSum(int[] nums, int target) {
3        int n = nums.length;
4
5        Arrays.sort(nums);
6
7        Set<List<Integer>> set = new HashSet<>();
8
9        for(int i = 0; i<n; i++){
10
11            for(int j = i + 1; j<n; j++){
12
13                int p = j + 1;
14                int q = n-1;
15
16                while(p < q){
17                    long sum = (long)nums[i] + nums[j] + nums[p] + nums[q];
18                    if(sum == target){
19                        List<Integer> list = new ArrayList<>();
20                        list.add(nums[i]);
21                        list.add(nums[p]);
22                        list.add(nums[q]);
23                        list.add(nums[j]);
24                        set.add(list);
25                        p++;
26                        q--;
27
28                        while(p<n && nums[p] == nums[p-1]) p++;
29                        while(q>=0 && nums[q] == nums[q+1]) q--;
30                    }else if(sum < target){
31                        p++;
32                    }else{
33                        q--;
34                    }
35                }
36            }
37        }
38
39        List<List<Integer>> ans = new ArrayList<>(set);
40
41        return ans;
42    }
43}