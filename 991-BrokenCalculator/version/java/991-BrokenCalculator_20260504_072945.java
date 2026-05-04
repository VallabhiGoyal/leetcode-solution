// Last updated: 5/4/2026, 7:29:45 AM
1class Solution {
2    public int brokenCalc(int startValue, int target) {
3        int ans = 0;
4
5        while(startValue != target){
6            if(target > startValue && target%2==0){
7                target /= 2;
8            }else{
9                target++;
10            }
11            ans++;
12        }
13
14        return ans;
15    }
16}