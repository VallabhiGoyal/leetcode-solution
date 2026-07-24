// Last updated: 7/24/2026, 1:53:09 PM
1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3        int n = nums.length;
4        List<List<Integer>> ans = new ArrayList<>();
5        helper(nums, ans, new ArrayList<>(), new boolean[n], n);
6
7        return ans;
8    }
9
10    public void helper(int[] nums, List<List<Integer>> list, List<Integer> temp, boolean[] visited, int n){
11        if(temp.size() == n){
12            list.add(new ArrayList<>(temp));
13            return;
14        }
15    
16        for(int i = 0; i < n; i++){
17            if(!visited[i]){
18                temp.add(nums[i]);
19                visited[i] = true;
20                helper(nums, list, temp, visited, n);
21                temp.remove(temp.size() - 1);
22                visited[i] = false;
23            }
24        }
25
26    }
27}