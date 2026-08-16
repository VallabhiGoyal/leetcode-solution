// Last updated: 8/16/2026, 6:08:52 AM
1class Solution {
2    public boolean stoneGameIX(int[] stones) {
3        int n = stones.length;
4
5        int count0 = 0;
6        int count1 = 0;
7        int count2 = 0;
8
9        for(int i = 0; i<n; i++){
10            if(stones[i] % 3 == 0){
11                count0++;
12            }else if(stones[i] % 3 == 1){
13                count1++;
14            }else{
15                count2++;
16            }
17        }
18
19        count0 %= 2;
20        
21        if (count0 == 0) {
22            return count1 > 0 && count2 > 0;
23        }
24
25        return Math.abs(count1 - count2) > 2;
26    }
27}