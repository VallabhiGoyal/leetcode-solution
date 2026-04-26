// Last updated: 4/26/2026, 9:42:23 AM
1class Solution {
2    public boolean validDigit(int n, int x) {
3        boolean flag = false;
4        while(n>9){
5            int remain = n % 10;
6            if(remain == x) flag = true;
7            n/=10;
8        }
9        if(n == x) flag = false;
10        return flag;
11    }
12}