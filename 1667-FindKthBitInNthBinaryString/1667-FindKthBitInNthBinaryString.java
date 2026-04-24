// Last updated: 4/24/2026, 10:31:41 AM
class Solution {
    public char findKthBit(int n, int k) {
        if(n==1) return '0';
        int len = (1<<n) - 1;
        if(k == (len+1)/2) return '1';
        if(k < (len+1)/2) return findKthBit(n-1, k);
        int mirror = len - k +1;
        return invert(findKthBit(n-1,mirror));
    }

    private char invert(char str){
        if(str == '1') return '0';
        return '1';
    }

}