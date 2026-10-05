// Last updated: 10/5/2026, 9:45:53 AM
1class Solution {
2    public int longestStrChain(String[] words) {
3        int n = words.length;
4
5        Arrays.sort(words, (a, b) -> {
6            if(a.length() != b.length()){
7                return a.length() - b.length();
8            }
9
10            return a.compareTo(b);
11        });
12
13        int[] dp = new int[n];
14        Arrays.fill(dp, 1);
15
16        for(int i = 0; i<n; i++){
17            for(int j = i+1; j<n; j++){
18                if(words[i].length() == words[j].length()) continue;
19                if(words[i].length() + 1 != words[j].length()) break;
20
21                if(checkPredecessor(words[i], words[j])){
22                    dp[j] = Math.max(dp[j], dp[i] + 1);
23                }
24            }
25        }
26
27        int max = 1;
28        for(int i = 0; i<n; i++){
29            max = Math.max(dp[i], max);
30        }
31
32        return max;
33    }
34
35    public boolean checkPredecessor(String s1, String s2){
36        int n = s1.length();
37        int m = s2.length();
38
39        int i = 0;
40        int j = 0;
41        int count = 0;
42        int notEqual = 0;
43        while(i<n && j<m){
44            if(s1.charAt(i) == s2.charAt(j)){
45                i++;
46                j++;
47                count++;
48            }else{
49                notEqual++;
50                j++;
51            }
52            if(notEqual > 1) return false;
53        }
54
55        return count == n;
56    }
57}