// Last updated: 4/24/2026, 10:36:27 AM
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if(m == 0) return n;
        if(n == 0) return m;

        int[] t = new int[n+1];

        for(int j = 0; j<n+1; j++){
            t[j] = j;
        }
        
        for(int i = 1; i<m+1; i++){
            int prevDia = t[0];  
            t[0] = i;
            for(int j = 1; j<n+1; j++){
                int temp = t[j];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    int best = Math.min(t[j], t[j-1]);
                    best = Math.min(best, prevDia);
                    t[j] = 1 + best;
                }else{
                    t[j] = prevDia;
                }
                prevDia = temp;
            }
        }

        return t[n];
    }
}