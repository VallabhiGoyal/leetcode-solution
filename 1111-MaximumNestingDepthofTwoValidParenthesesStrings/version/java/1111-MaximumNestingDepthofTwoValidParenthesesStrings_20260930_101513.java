// Last updated: 9/30/2026, 10:15:13 AM
1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int n = seq.length();
4        int[] ans = new int[n];
5        int open = 0;
6        int i = 0;
7
8        for(char ch : seq.toCharArray()){
9            if(ch == '('){
10                open++;
11                ans[i] = open % 2;
12            }else{
13                ans[i] = open % 2;
14                open--;
15            }
16            i++;
17        }
18        return ans;
19    }
20}