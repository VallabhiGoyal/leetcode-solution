// Last updated: 7/7/2026, 10:42:10 AM
1class Solution {
2    public int trap(int[] height) {
3        int n = height.length;
4        if(n<=2) return 0;
5
6        int left = 0;
7        int right = n-1;
8        
9        int leftMax = 0;
10        int rightMax = 0;
11        int water = 0;
12
13        while(left<right){
14            if(height[left] < height[right]){
15                if(height[left] >= leftMax){
16                    leftMax = height[left];
17                }else{
18                    water += leftMax - height[left];
19                }
20                left++;
21            }else{
22                if(height[right] >= rightMax){
23                    rightMax = height[right];
24                }else{
25                    water += rightMax - height[right];
26                }
27                right--;
28            }
29        }
30
31        return water;
32    }
33}