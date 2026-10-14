// Last updated: 10/14/2026, 5:36:34 AM
1class Solution {
2    public String maxSumOfSquares(int num, int sum) {
3        if(sum > 9*num) return "";
4
5        StringBuilder sb = new StringBuilder();
6
7        while(sum > 0){
8            if(sum > 9){
9                sb.append('9');
10                sum -= 9;
11            }else{
12                sb.append(Integer.toString(sum));
13                sum = 0;
14            }
15        }
16
17        while(sb.length() != num) sb.append(0);
18
19        return sb.toString();
20    }
21}