// Last updated: 8/16/2026, 8:58:38 AM
1class Solution {
2    public int maximumGap(String skill, String station) {
3        int n = skill.length();
4        int m = station.length();
5
6        int ans = 0;
7        int currIdx = -1;
8
9        int[] firstOccur = new int[n];
10        int prev = -1;
11        for(int i = 0; i<n; i++){
12            for(int j = prev+1; j<m; j++){
13                if(skill.charAt(i) == station.charAt(j)){
14                    firstOccur[i] = j;
15                    prev = j;
16                    break;
17                }
18            }
19        }
20        
21        int[] lastOccur = new int[n];
22        prev = m;
23        for(int i = n-1; i>=0; i--){
24            for(int j = prev-1; j>=0; j--){
25                if(skill.charAt(i) == station.charAt(j)){
26                    lastOccur[i] = j;
27                    prev = j;
28                    break;
29                }
30            }
31        }
32
33        int max = 0;
34        for(int i = 1; i<n; i++){
35            max = Math.max(max, lastOccur[i] - firstOccur[i-1]);
36        }
37
38        return max;
39    }
40}