// Last updated: 8/14/2026, 5:57:15 AM
1class Solution {
2    public int maximumLengthSubstring(String s) {
3        int  n = s.length();
4
5        Map<Character, Integer> map = new HashMap<>();
6
7        int j = 0; 
8        int maxLen = 0;
9
10        for(int i = 0; i<n; i++){
11            char ch = s.charAt(i);
12            map.merge(ch, 1, Integer::sum);
13
14            while(map.get(ch) > 2){
15                map.merge(s.charAt(j), -1, Integer::sum);
16                j++;
17            }
18
19            maxLen = Math.max(maxLen, i-j+1);
20        }
21
22        return maxLen;
23    }
24}