// Last updated: 7/26/2026, 7:06:39 AM
1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        int m = s.length();
4        int n = wordDict.size();
5
6        Set<String> set = new HashSet<>();
7        for(int i = 0; i<n; i++){
8            set.add(wordDict.get(i));
9        }
10
11        boolean[] dp = new boolean[m+1];
12
13        dp[0] = true;
14
15        for(int i = 1; i<m+1; i++){
16            for(int j = 0; j<i; j++){
17                if(dp[j] && set.contains(s.substring(j, i))){
18                    dp[i] = true;
19                    break;
20                }
21            }
22        }
23
24        return dp[m];
25    }
26}