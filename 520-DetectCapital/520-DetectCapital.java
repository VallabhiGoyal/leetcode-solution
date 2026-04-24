// Last updated: 4/24/2026, 10:33:43 AM
class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        if(n==1) return true;
        int count = 0;
        for(int i = 0; i<n; i++){
            int ascii = (int)word.charAt(i);
            if(ascii >=65 && ascii<=90) count++;
        }

        if(count == n) return true;
        if(count > 1) return false;
        if(count == 1 && word.charAt(0) >= 'a' && word.charAt(0) <= 'z') return false;
        return true;
    }
}