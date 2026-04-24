// Last updated: 4/24/2026, 10:31:18 AM
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;

        int[] dp = new int[n];
        int[] tails = new int[n];
        int size = 0;

        for(int i = 0; i<n; i++){
            int h = obstacles[i];
            
            int j = binarySearch(tails, 0, size, h);
            tails[j] = h;

            if(j == size) size++;
            dp[i] = j+1;
        }

        return dp;
    }

    public int binarySearch(int[] tails, int left, int right, int h){
        while(left < right){
            int mid = left + (right - left)/2;
            if(tails[mid] <= h){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}