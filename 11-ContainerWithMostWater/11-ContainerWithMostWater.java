// Last updated: 4/24/2026, 10:37:09 AM
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int maxArea = 0;
        int i = 0;
        int j = n-1;

        while(i<j){
            int x = j-i;
            int area = Math.min(height[i], height[j]) * x;
            if(height[i]<=height[j]){
                i++;
            }else{
                j--;
            }
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}