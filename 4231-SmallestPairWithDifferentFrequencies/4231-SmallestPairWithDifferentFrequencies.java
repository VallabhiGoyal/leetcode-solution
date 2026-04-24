// Last updated: 4/24/2026, 10:29:36 AM
class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int n = nums.length;
        if(n<=1) return new int[]{-1,-1};
        Arrays.sort(nums);

        int x = nums[0];
        int y = 0;

        int countX = 1;
        int countY = 0;
        for(int i = 1; i<n; i++){
            if(nums[i] == x){
                countX++;
                continue;
            }
            countY = 0;
            y = nums[i];
            while(i<n && nums[i] == y){
                countY++;
                i++;
            }
            i--;
            if(countX != countY) break;
        }
        if(countX == countY || y==0) return new int[]{-1,-1}; 
        return new int[]{x,y};
    }
}