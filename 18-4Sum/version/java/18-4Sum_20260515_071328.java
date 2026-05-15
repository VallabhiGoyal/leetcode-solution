// Last updated: 5/15/2026, 7:13:28 AM
1class Solution {
2    public List<List<Integer>> fourSum(int[] nums, int target) {
3        int n = nums.length;
4        Arrays.sort(nums);
5
6        List<List<Integer>> ans = new ArrayList<>();
7        if(n < 4) return ans;
8
9        for(int i = 0; i<n; i++){
10            
11            if(i > 0 && nums[i-1] == nums[i]) continue;
12
13            if(i+3 < n){
14                long min = (long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
15                if(min > target) break;
16            }
17            
18            if(n-3 >= 0){
19                long max = (long)nums[i] + nums[n-1] + nums[n-2] + nums[n-3];
20                if(max < target) continue;
21            }
22        
23            for(int j = i + 1; j<n; j++){
24                if(j > i+1 && nums[j-1] == nums[j]) continue;
25
26                if(j+2 < n){
27                    long min = (long)nums[i] + nums[j] + nums[j+1] + nums[j+2];
28                    if(min > target) break;
29                }
30            
31                if(n-2 >= 0){
32                    long max = (long)nums[i] + nums[j] + nums[n-2] + nums[n-1];
33                    if(max < target) continue;
34                }
35
36                int p = j + 1;
37                int q = n-1;
38
39                while(p < q){
40                    
41                    long sum = (long)nums[i] + nums[j] + nums[p] + nums[q];
42                    if(sum == target){
43                        List<Integer> list = new ArrayList<>();
44                        list.add(nums[i]);
45                        list.add(nums[j]);
46                        list.add(nums[p]);
47                        list.add(nums[q]);
48                        ans.add(list);
49                        p++;
50                        q--;
51
52                        while(p<n && nums[p] == nums[p-1]) p++;
53                        while(q>=0 && nums[q] == nums[q+1]) q--;
54                    }else if(sum < target){
55                        p++;
56                    }else{
57                        q--;
58                    }
59                }
60            }
61        }
62
63        return ans;
64    }
65}