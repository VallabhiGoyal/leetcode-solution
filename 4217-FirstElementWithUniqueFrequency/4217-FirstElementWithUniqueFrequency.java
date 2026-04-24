// Last updated: 4/24/2026, 10:29:42 AM
class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> fmap = new HashMap<>();
        for(int i = 0; i<n; i++){
            fmap.put(nums[i], fmap.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, Integer> haveFreq = new HashMap<>();
        for(int values : fmap.values()){
            haveFreq.put(values, haveFreq.getOrDefault(values, 0) + 1);
        }

        for(int i = 0; i<n; i++){
            int curr = nums[i];
            int freq = fmap.get(curr);
            int count = haveFreq.get(freq);
            if(count == 1) return nums[i];
        }

        return -1;

    }
}