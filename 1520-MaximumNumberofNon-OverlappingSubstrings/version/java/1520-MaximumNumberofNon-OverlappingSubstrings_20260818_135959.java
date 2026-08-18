// Last updated: 8/18/2026, 1:59:59 PM
1class Solution {
2    public List<String> maxNumOfSubstrings(String s) {
3        int n = s.length();
4
5        int[][] freq = new int[26][2];
6        for(int i = 0; i<26; i++){
7            freq[i][0] = -1;
8            freq[i][1] = -1;
9        }
10
11        for(int i = 0; i<n; i++){
12            int idx = s.charAt(i) - 'a';
13
14            if(freq[idx][0] == -1) freq[idx][0] = i;
15            freq[idx][1] = i;
16        }
17
18        List<int[]> intervals = new ArrayList<>();    
19
20        for(int j = 0; j<26; j++){
21            if(freq[j][0] == -1) continue;
22
23            //single elements
24            if(freq[j][0] == freq[j][1]){
25                intervals.add(new int[]{freq[j][0], freq[j][1]});
26                continue;
27            }
28
29            //Strings with diff char
30            int start = freq[j][0];
31            int end = freq[j][1];
32
33            for(int i = start; i <= end; i++){
34                int x = s.charAt(i) - 'a';
35
36                if(freq[x][0] < start){
37                    start = -1;
38                    break;
39                }
40
41                if(freq[x][1] > end){
42                    end = freq[x][1];
43                }
44            }
45
46            if(start != -1){
47                intervals.add(new int[]{start, end});
48            }
49        }
50
51        //sort intervals
52        intervals.sort((a, b) -> a[1] - b[1]);
53
54        List<String> ans = new ArrayList<>();
55
56        int prevEnd = -1;
57
58        for(int[] interval : intervals) {
59            if(interval[0] > prevEnd) {
60                ans.add(s.substring(interval[0], interval[1] + 1));
61                prevEnd = interval[1];
62            }
63        }
64
65        return ans;
66    }
67}