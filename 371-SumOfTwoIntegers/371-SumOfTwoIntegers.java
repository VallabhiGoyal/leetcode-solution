// Last updated: 4/24/2026, 10:34:16 AM
class Solution {
    public int getSum(int a, int b) {
        return (a^b) + ((a&b)<<1);
    }
}