// Last updated: 4/24/2026, 10:30:13 AM
class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        if(s.length()<2) return false;

        int totalScore = 0;
        for (int i = 0; i < n; i++) {
            totalScore += s.charAt(i) - 'a' + 1;
        }

        int leftScore = 0;
        for (int i = 0; i < n - 1; i++) {
            leftScore += s.charAt(i) - 'a' + 1;
            int rightScore = totalScore - leftScore;

            if (leftScore == rightScore) return true;
        }

        return false;
    }
}