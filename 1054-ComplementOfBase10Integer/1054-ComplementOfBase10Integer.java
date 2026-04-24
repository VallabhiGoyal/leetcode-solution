// Last updated: 4/24/2026, 10:32:24 AM
class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int k = 0;
        int temp = n;
        while(temp>0){
            temp /= 2;
            k++;
        }

        int mask = (1<<k)-1;
        return n ^ mask;
    }
}