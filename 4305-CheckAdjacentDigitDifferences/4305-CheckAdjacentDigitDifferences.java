// Last updated: 7/3/2026, 11:34:46 AM
class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int n = s.length();

        for(int i = 0; i<n-1; i++){
            int ch1 = s.charAt(i) - '0';
            int ch2 = s.charAt(i+1) - '0';

            if(Math.abs(ch1 - ch2) > 2) return false; 
        }

        return true;
    }
}