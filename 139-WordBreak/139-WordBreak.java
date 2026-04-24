// Last updated: 4/24/2026, 10:35:33 AM
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        int n = wordDict.size();

        Set<String> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(wordDict.get(i));
        }

        boolean[] dp = new boolean[m+1];

        dp[0] = true;

        for(int i = 1; i<m+1; i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[m];
    }
}