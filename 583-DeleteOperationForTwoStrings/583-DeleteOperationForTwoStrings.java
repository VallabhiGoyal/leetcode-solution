// Last updated: 4/24/2026, 10:33:33 AM
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] t = new int[m+1][n+1];
        
        for(int i = 1; i<m+1; i++){
            for(int j = 1; j<n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        int lcs = t[m][n];
        
        return m + n - 2*lcs;
    }
}