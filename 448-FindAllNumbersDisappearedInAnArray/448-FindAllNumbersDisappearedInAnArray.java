// Last updated: 4/24/2026, 10:33:55 AM
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        boolean[] seen = new boolean[n+1];

        for(int i : nums){
            seen[i] = true;
        }

        for(int i = 1; i<n+1; i++){
            if(!seen[i]) li.add(i);
        }

        return li;
    }
}