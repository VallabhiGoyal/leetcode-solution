// Last updated: 7/3/2026, 11:34:35 AM
class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        
        for(int i = 0; i<n; i++){
            int maxFreq = 0;
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int j = i; j<n; j++){
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(nums[j]));

                if(isValid(map, maxFreq)){
                    ans = Math.max(ans, j - i +1);
                }
            }
        }

        return ans;
    }

    public boolean isValid(Map<Integer, Integer> map, int maxFreq){
        if(map.size() == 1) return true;
        if(maxFreq % 2 != 0) return false;

        boolean maxFreqEle = false;
        boolean minFreqEle = false;
        
        for(int key : map.keySet()){
            int value = map.get(key);
            if(value == maxFreq){
                maxFreqEle = true;
                continue;
            }
            if(maxFreq != 2*value) return false;
            minFreqEle = true;
        }
        return maxFreqEle && minFreqEle;
    }
}