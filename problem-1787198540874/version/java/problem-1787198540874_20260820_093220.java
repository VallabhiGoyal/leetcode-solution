// Last updated: 8/20/2026, 9:32:20 AM
1class Solution {
2    public List<List<Integer>> combine(int n, int k) {
3        List<List<Integer>> ans = new ArrayList<>();
4
5        if(k == 0) return ans;
6        helper(n, k, ans, new ArrayList<>(), new boolean[n], 0);
7
8        return ans;
9    }
10
11    public void helper(int n, int k, List<List<Integer>> ans, List<Integer> temp, boolean[] visited, int idx){
12        if(temp.size() == k){
13            ans.add(new ArrayList<>(temp));
14            return;
15        }
16
17        for(int j = idx; j<n; j++){
18            if(!visited[j]){
19                temp.add(j+1);
20                visited[j] = true;
21                helper(n, k, ans, temp, visited, j);
22                visited[j] = false;
23                temp.remove(temp.size()-1);
24            }
25        }
26    }
27}