// Last updated: 4/24/2026, 10:29:28 AM
class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        if(n==1) return true;
        
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            }else {
                minOdd = Math.min(minOdd, num);
            }
        }

        if(minEven == Integer.MAX_VALUE || minOdd == Integer.MAX_VALUE) return true;
        return minEven > minOdd;
    }
}