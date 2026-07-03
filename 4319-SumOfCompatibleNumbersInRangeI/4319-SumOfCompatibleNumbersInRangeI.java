// Last updated: 7/3/2026, 11:34:40 AM
class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int count = 0;

        int start = n-k;
        int end = n + k;

        if(start <= 0) start = 1;

        while(start <= end){
            if(Math.abs(n- start) <= k && (n & start) == 0) count+= start;
            start++;
        }

        return count;
    }
}