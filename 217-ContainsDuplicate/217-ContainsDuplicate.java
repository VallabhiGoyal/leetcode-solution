// Last updated: 4/24/2026, 10:35:01 AM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }
}