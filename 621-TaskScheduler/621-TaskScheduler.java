// Last updated: 4/24/2026, 10:33:29 AM
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        if(n == 0) return m;

        int[] freq = new int[26];
        for(int i = 0; i<m; i++){
            int ch = tasks[i] - 'A';
            freq[ch]++;
        }

        int maxFreq = 0;
        int count = 0;
        for(int i = 0; i<26; i++){
            if(freq[i] > maxFreq){
                count = 1;
                maxFreq = freq[i];
            }else if(maxFreq == freq[i]) count++;
        }

        return Math.max((maxFreq-1)*(n+1) + count, m);
    }
}