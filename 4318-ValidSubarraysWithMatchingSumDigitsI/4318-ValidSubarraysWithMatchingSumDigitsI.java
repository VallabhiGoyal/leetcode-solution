// Last updated: 7/3/2026, 11:34:41 AM
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;

        int count = 0;
        for(int i = 0; i<n; i++){
            long sum = 0;
            for(int j = i; j<n; j++){
                sum += nums[j];

                String s = Long.toString(sum);

                if(s.charAt(0)-'0' == x && sum % 10 == x){
                    count++;
                }
            }
        }

        return count;
    }
}