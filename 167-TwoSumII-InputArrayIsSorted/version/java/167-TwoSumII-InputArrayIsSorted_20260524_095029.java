// Last updated: 5/24/2026, 9:50:29 AM
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int n = numbers.length;
4
5        int i = 0;
6        int j = n-1;
7
8        while(i < j){
9            int curr = numbers[i] + numbers[j];
10
11            if(curr == target) return new int[]{i+1, j+1};
12            else if(curr < target) i++;
13            else j--;
14        }
15
16        return new int[]{};
17    }
18}