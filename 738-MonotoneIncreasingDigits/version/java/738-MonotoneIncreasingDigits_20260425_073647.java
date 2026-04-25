// Last updated: 4/25/2026, 7:36:47 AM
1class Solution {
2    public int monotoneIncreasingDigits(int n) {
3
4        int[] digit = new int[10];
5        for(int i = 9; i >=0; i--){
6            digit[i] = n%10;
7            n/=10;
8        }
9
10        int mark = 10;
11        for(int i = 9; i > 0; i--){
12            if(digit[i] < digit[i - 1]){
13                digit[i - 1]--;
14                mark = i;
15            }
16        }
17
18        for(int i = mark; i < 10; i++){
19            digit[i] = 9;
20        }
21
22        int ans = 0;
23        for(int i = 0; i < 10; i++){
24            ans = ans * 10 + digit[i];
25        }
26
27        return ans;
28    }
29}