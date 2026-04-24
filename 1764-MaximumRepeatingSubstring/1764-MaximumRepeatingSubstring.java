// Last updated: 4/24/2026, 10:31:36 AM
class Solution {
    public int maxRepeating(String sequence, String word) {
        int m = sequence.length();
        int n = word.length();
        if(n > m) return 0;

        int maxCount = 0;

        for(int i = 0; i<m; i++){  
            int count = 0;
            int k = i;
            while(k+n <= m && sequence.substring(k, k + n).equals(word)){
                count++;
                k += n;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}