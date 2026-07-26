// Last updated: 7/26/2026, 8:05:37 AM
1class Solution {
2    public int largestInteger(int n, int s) {
3        if(s > n * 9) return -1;
4
5        int ans = 0;
6        int count = 0;
7
8        while(s > 0){
9            if(s >= 9){
10                ans = ans*10 + 9;
11                s -= 9;
12            }else{
13                ans = ans*10 + s;
14                s = 0;
15            }
16            count++;
17        }
18
19        if(n > count){
20            int temp = n - count;
21            temp = (int)Math.pow(10, temp);
22            ans = ans*temp;
23        }
24
25        return ans;
26    }
27}