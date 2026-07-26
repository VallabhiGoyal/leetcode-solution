// Last updated: 7/26/2026, 7:12:33 AM
1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> ans = new ArrayList<>();
4        
5        helper(nums, ans, new ArrayList<>(), 0);
6
7        return ans;
8    }
9
10    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> list, int idx){
11        if(idx == nums.length){
12            ans.add(new ArrayList<>(list));
13            return;
14        }
15
16        list.add(nums[idx]);
17        helper(nums, ans, list, idx + 1);
18        
19        list.remove(list.size()-1);
20        helper(nums, ans, list, idx+1);
21    }
22}