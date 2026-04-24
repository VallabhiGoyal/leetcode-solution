// Last updated: 4/24/2026, 10:35:14 AM
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n!=0){
            n &= n-1;
            count++;
        }

        return count;
    }
}