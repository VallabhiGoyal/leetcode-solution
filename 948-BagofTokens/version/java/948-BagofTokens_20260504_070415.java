// Last updated: 5/4/2026, 7:04:15 AM
1class Solution {
2    public int bagOfTokensScore(int[] tokens, int power) {
3        int n = tokens.length;
4
5        Arrays.sort(tokens);
6
7        int ans = 0;
8        int j = n-1;
9        int i = 0;
10
11        int temp = 0;
12        while(i<=j){
13            if(power >= tokens[i]){
14                power -= tokens[i];
15                temp++;
16                i++;
17            }else if(power < tokens[i] && temp > 0){
18                power += tokens[j];
19                temp--;
20                j--;
21            }else{
22                break;
23            }
24            ans = Math.max(ans, temp);
25        }
26
27        return ans;
28    }
29}