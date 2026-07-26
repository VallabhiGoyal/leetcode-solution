// Last updated: 7/26/2026, 7:12:17 AM
1class Solution {
2    List<List<Integer>> ans;
3    public List<List<Integer>> combinationSum(int[] candidates, int target) {
4        ans = new ArrayList<>();
5        List<Integer> temp = new ArrayList<>();
6        helper(candidates, target, 0, 0, candidates.length, temp);
7        return ans;
8    }
9
10    public void helper(int[] arr, int target, int sum, int idx, int n, List<Integer> temp){
11        if(sum == target){
12            ans.add(new ArrayList<>(temp));
13            return;
14        }
15        if(idx == n|| sum > target) return;
16
17        //take
18        temp.add(arr[idx]);
19        helper(arr, target, sum+arr[idx], idx, n, temp);
20        temp.remove(temp.size()-1);
21        
22
23        //remove
24        helper(arr, target, sum, idx+1, n, temp);
25    }
26}