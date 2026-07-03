// Last updated: 7/3/2026, 11:34:38 AM
class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];

        while(n>0){
            freq[n%10]++;
            n /= 10;
        }

        int ans = 0;
        for(int i = 0; i<10; i++){
            ans += i*freq[i];
        }

        return ans;
    }
}