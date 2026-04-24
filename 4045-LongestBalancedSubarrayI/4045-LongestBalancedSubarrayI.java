// Last updated: 4/24/2026, 10:30:15 AM
class Solution {
    public int longestBalanced(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int maxLen = 0;
        for(int i = 0; i<n; i++){
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();
            for(int j = i; j<n; j++){
                if(nums[j]%2==0){
                    evenSet.add(nums[j]);
                }
                else if(nums[j]%2 != 0){
                    oddSet.add(nums[j]);
                }

                if(evenSet.size() == oddSet.size()){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }
}