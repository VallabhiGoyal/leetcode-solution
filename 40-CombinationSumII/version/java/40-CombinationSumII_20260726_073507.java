// Last updated: 7/26/2026, 7:35:07 AM
1class Solution {
2    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
3        int n = candidates.length;
4
5        Arrays.sort(candidates);
6
7        List<List<Integer>> ans = new ArrayList<>();
8        helper(ans, new ArrayList<>(), candidates, target, 0, n, 0);
9
10        return ans;
11    }
12
13    public void helper(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int count, int n, int j){
14
15        if(target == count){
16
17            list.add(new ArrayList<>(temp));
18            return;
19        }
20
21        for(int i = j; i<n; i++){
22            if(i > j && candidates[i] == candidates[i-1]) continue;
23
24            count += candidates[i];
25
26            if(count <= target){
27                temp.add(candidates[i]);
28                helper(list, temp, candidates, target, count, n, i + 1);
29                temp.remove(temp.size()-1);
30            }
31
32            count -= candidates[i];
33        }
34    }
35}