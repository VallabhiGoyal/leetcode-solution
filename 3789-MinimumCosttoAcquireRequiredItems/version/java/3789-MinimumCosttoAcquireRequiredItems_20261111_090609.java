// Last updated: 11/11/2026, 9:06:09 AM
1class Solution {
2    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
3        long min = Long.MAX_VALUE;
4
5        if(cost1 >= costBoth && cost2 >= costBoth){
6            int temp = Math.max(need1, need2);
7            min = (long) temp * costBoth;
8        }else if(cost1 + cost2 <= costBoth){
9            min = (long) need1 * cost1 + (long) need2 * cost2;
10        }else{
11            int temp = Math.min(need1, need2);
12            need1 -= temp;
13            need2 -= temp;
14
15            if(cost1 >= costBoth){
16                min = (long) temp * costBoth + (long) need1 * costBoth + (long) need2 * cost2;
17            }else if(cost2 >= costBoth){
18                min = (long) temp * costBoth + (long) need1 * cost1 + (long) need2 * costBoth;
19            }else{
20                min = (long) temp * costBoth + (long) need1 * cost1 + (long) need2 * cost2;
21            }
22        }
23
24        return min;
25    }
26}
27