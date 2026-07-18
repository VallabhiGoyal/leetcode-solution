// Last updated: 7/18/2026, 9:59:07 AM
1class Solution {
2    public int findGCD(int[] nums) {
3        int n = nums.length;
4
5        int max = Integer.MIN_VALUE;
6        int min = Integer.MAX_VALUE;
7
8        for(int num : nums){
9            max = Math.max(max, num);
10            min = Math.min(min, num);
11        }
12
13        return gcd(max, min);
14    }
15
16    public int gcd(int a, int b){
17        while(b != 0){
18            int temp = b;
19            b = a % b;
20            a = temp;
21        }
22
23        return a;
24    }
25}