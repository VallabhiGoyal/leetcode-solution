// Last updated: 7/19/2026, 9:18:13 AM
1class Solution {
2    public boolean[] transformStr(String s, String[] strs) {
3        int n = s.length();
4        int m = strs.length;
5        
6        boolean[] ans = new boolean[m];
7
8        int countZero = 0;
9        int[] prefix = new int[n];
10        for(int i = 0; i<n; i++){
11            if(s.charAt(i) == '0'){
12                countZero++;
13            }
14            prefix[i] = countZero;
15        }
16
17        for(int i = 0; i<m; i++){
18            int countZ = 0;
19            int countQ = 0;
20            
21            String curr = strs[i];
22            int size = curr.length();
23            
24            for(int j = 0; j<size; j++){
25                if(curr.charAt(j) == '0') countZ++;
26                else if(curr.charAt(j) == '?') countQ++;
27            }
28
29            if(countZ > countZero) ans[i] = false;
30            else if(countZ + countQ >= countZero) ans[i] = true;
31            else ans[i] = false;
32
33            if(!ans[i]) continue;
34
35            int requiredZero = countZero - countZ;
36            int currZeroCount = 0;
37            
38            for(int j = 0; j< size; j++){
39                if(requiredZero > 0){
40                    if(curr.charAt(j) == '?'){
41                        requiredZero--;
42                        currZeroCount++;
43                    }
44                }
45                if(curr.charAt(j) == '0') currZeroCount++;
46                
47                if(currZeroCount < prefix[j]){
48                    ans[i] = false;
49                    break;
50                }
51            }
52        }
53
54        return ans;
55    }
56}