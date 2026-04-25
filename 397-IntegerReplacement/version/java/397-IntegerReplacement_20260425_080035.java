// Last updated: 4/25/2026, 8:00:35 AM
1class Solution {
2    public int integerReplacement(int n) {
3        if(n == 1) return 0;
4        long num = n;
5        int count = 0;
6        while(num != 1){
7            if((num & 1)  == 0){
8                num = num>>1;
9            }else{
10               if(num == 3 || (num & 3) == 1) num-- ;
11               else num++; 
12            }
13            count++;
14        }
15
16        return count;
17    }
18}