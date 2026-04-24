// Last updated: 4/24/2026, 10:29:29 AM
class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        if(n == 1) return true;
        
        int odd = 0, even = 0;

        for (int num : nums1) {
            if (num % 2 == 0) even++;
            else odd++;
        }

        boolean MakeEven = (odd == 0) || (odd >= 2);

        boolean MakeOdd = (odd > 0 && even > 0);

        return MakeEven || MakeOdd;
    }
}