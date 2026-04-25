// Last updated: 4/25/2026, 7:55:28 AM
1class Solution {
2    Map<Integer, Integer> map = new HashMap<>();
3
4    public int integerReplacement(int n) {
5        return solve((long)n);
6    }
7
8    public int solve(long n){
9        if(n == 1) return 0;
10
11        if(map.containsKey(n)) return map.get(n);
12
13        int ans;
14        if(n%2 == 0){
15            ans = 1 + solve(n/2);
16        }else{
17            ans = 1 + Math.min(solve(n-1), solve(n+1));
18        }
19
20        return ans;
21    }
22}