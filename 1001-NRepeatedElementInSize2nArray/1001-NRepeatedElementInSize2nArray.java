// Last updated: 4/24/2026, 10:32:36 AM
class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            if(freq.put(num, 0) != null) return num;
        }
        return -1;
    }
}