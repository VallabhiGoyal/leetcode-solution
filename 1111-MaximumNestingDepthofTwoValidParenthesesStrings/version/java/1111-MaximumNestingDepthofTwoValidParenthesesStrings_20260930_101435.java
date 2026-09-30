// Last updated: 9/30/2026, 10:14:35 AM
1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int n = seq.length();
4
5        int[] ans = new int[n];
6
7        int total = n/2;
8        int A = total/2;
9
10        int i = 0; 
11        int countOpen = 0;
12        int countClose = 0;
13
14        int depthOpen = 0;
15        int depthClose = 0;
16
17        while(i < n){
18            char ch = seq.charAt(i);
19
20            if(ch == '('){
21                if(depthOpen % 2 == 0){
22                    ans[i] = 1;
23                    countOpen++;
24                }
25                depthOpen++;
26            }
27
28            if(ch == ')' && countClose <= countOpen && depthClose <= depthOpen){
29                if(depthClose % 2 == 0){
30                    ans[i] = 1;
31                    countClose++;
32                }
33                depthClose++;
34            }
35
36            i++;
37        }
38
39        return ans;
40    }
41}