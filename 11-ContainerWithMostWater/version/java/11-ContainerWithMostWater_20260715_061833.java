// Last updated: 7/15/2026, 6:18:33 AM
1class Solution {
2    public int maxArea(int[] height) {
3        int n = height.length;
4
5        int maxArea = 0;
6        int i = 0;
7        int j = n-1;
8
9        while(i<j){
10            int x = j-i;
11            int area = Math.min(height[i], height[j]) * x;
12            if(height[i]<=height[j]){
13                i++;
14            }else{
15                j--;
16            }
17            maxArea = Math.max(area, maxArea);
18        }
19
20        return maxArea;
21    }
22}