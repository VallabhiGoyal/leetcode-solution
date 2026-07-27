// Last updated: 7/27/2026, 6:12:37 AM
1class Solution {
2    public List<List<Integer>> subsetsWithDup(int[] nums) {
3        int n = nums.length;
4        Arrays.sort(nums);
5
6        List<List<Integer>> ans = new ArrayList<>();
7        ans.add(new ArrayList<>());
8
9        helper(nums, n, ans, new ArrayList<>(), 0);
10
11        return ans;
12    }
13
14    public void helper(int[] nums, int n, List<List<Integer>> list, List<Integer> temp, int j){
15        if(temp.size() == n){
16            return;
17        }
18
19        for(int i = j; i<n; i++){
20            if(i > j && nums[i] == nums[i - 1]) continue;
21
22            temp.add(nums[i]);
23            list.add(new ArrayList<>(temp));
24
25            helper(nums, n, list, temp, i + 1);
26
27            temp.remove(temp.size() - 1);
28        }
29    }
30}