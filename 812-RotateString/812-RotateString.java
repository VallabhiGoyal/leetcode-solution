// Last updated: 4/24/2026, 10:32:57 AM
class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) return false;
        if(s.equals(goal)) return true;

        for(int i = 0; i<n; i++){
            String rotated = s.substring(i) + s.substring(0,i);

            if(rotated.equals(goal)) return true;
        }

        return false;
    }
}