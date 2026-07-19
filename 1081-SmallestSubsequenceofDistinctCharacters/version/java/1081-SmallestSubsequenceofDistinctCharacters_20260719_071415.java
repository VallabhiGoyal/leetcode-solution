// Last updated: 7/19/2026, 7:14:15 AM
1class Solution {
2    public String smallestSubsequence(String s) {
3        int n = s.length();
4
5        int[] freq = new int[26];
6        boolean[] visited = new boolean[26];
7        for(int i = 0; i<n; i++){
8            int ch = s.charAt(i) - 'a';
9            freq[ch]++;
10        }
11
12        StringBuilder sb = new StringBuilder();
13        for(int i = 0; i<n; i++){
14            char currChar = s.charAt(i);
15            int ch = currChar - 'a';
16            freq[ch]--;
17
18            if(visited[ch]) continue;
19
20            while(sb.length() > 0){
21                char lastChar = sb.charAt(sb.length()-1);
22                int lastIdx = lastChar - 'a';
23
24                if(lastChar > currChar && freq[lastIdx] > 0){
25                    sb.deleteCharAt(sb.length()-1);
26                    visited[lastIdx] = false;
27                }else break;
28            }
29
30            sb.append(currChar);
31            visited[ch] = true;
32        }
33
34        return sb.toString();
35    }
36}