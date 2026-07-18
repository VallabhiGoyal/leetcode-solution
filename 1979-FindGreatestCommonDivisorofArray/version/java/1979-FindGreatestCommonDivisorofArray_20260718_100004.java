// Last updated: 7/18/2026, 10:00:04 AM
1class Solution {
2    public int findGCD(int[] nums) {
3        int n = nums.length;
4
5        int max = Integer.MIN_VALUE;
6        int min = Integer.MAX_VALUE;
7
8        for(int num : nums){
9            
10            if(max < num) max = num;
11            if(min > num) min = num;
12        }
13
14        return gcd(max, min);
15    }
16
17    public int gcd(int a, int b){
18        while(b != 0){
19            int temp = b;
20            b = a % b;
21            a = temp;
22        }
23
24        return a;
25    }
26}