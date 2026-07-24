// Last updated: 7/24/2026, 1:19:48 PM
1class Solution {
2    public List<Integer> partitionLabels(String s) {
3        int n = s.length();
4
5        int[][] freqIdx = new int[26][2];
6
7        for(int i = 0; i<26; i++){
8            freqIdx[i][0] = -1;
9            freqIdx[i][1] = -1;
10        }
11
12        for(int i = 0; i<n; i++){
13            int ch = s.charAt(i) - 'a';
14            if(freqIdx[ch][0] == -1){
15                freqIdx[ch][0] = i;
16            }else{
17                freqIdx[ch][1] = i;
18            }
19        }
20
21        List<int[]> intervals = new ArrayList<>();
22        intervals.add(new int[]{freqIdx[s.charAt(0) - 'a'][0], freqIdx[s.charAt(0) - 'a'][1]});
23
24        boolean[] visited = new boolean[26];
25        visited[s.charAt(0) - 'a'] = true;
26
27        for(int i = 1; i<n; i++){
28            int currChar = s.charAt(i) - 'a';
29            int a2 = freqIdx[currChar][0];
30            int b2 = freqIdx[currChar][1];
31
32            if(visited[currChar]) continue;
33            visited[currChar] = true;
34            int a1 = intervals.get(intervals.size()- 1)[0];
35            int b1 = intervals.get(intervals.size() - 1)[1];
36
37            if(b1 >= a2){
38                a1 = Math.min(a1, a2);
39                b1 = Math.max(b1, b2);
40                intervals.set(intervals.size()-1, new int[]{a1, b1});
41            }else{
42                intervals.add(new int[] {a2, b2});
43            }
44        }
45
46        int size = intervals.size();
47        List<Integer> ans = new ArrayList<>();
48
49        for(int i = 0; i<size; i++){
50            int[] curr = intervals.get(i);
51            if(curr[1] != -1){
52                ans.add(intervals.get(i)[1] - intervals.get(i)[0] + 1);
53            }else{
54                ans.add(1);
55            }
56            
57        }
58
59        return ans;
60
61    }
62}