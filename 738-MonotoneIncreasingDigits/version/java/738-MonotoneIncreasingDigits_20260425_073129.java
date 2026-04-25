// Last updated: 4/25/2026, 7:31:29 AM
1class Solution {
2    public int monotoneIncreasingDigits(int n) {
3        int[] digit = new int[10];
4
5        for(int i = 9; i>=0; i--){
6            digit[i] = n % 10;
7            n /= 10;
8        }
9        
10        for(int i = 0; i<9; i++){
11            if(digit[i] > digit[i+1]){
12                digit[i]--;
13                for(int j = i+1; j<10; j++){
14                    digit[j] = 9;
15                }
16                i = -1;
17            }
18        }
19
20        int ans = 0;
21        for(int i = 0; i<10; i++){
22            ans = ans*10 + digit[i];
23        }
24
25        return ans;
26    }
27}