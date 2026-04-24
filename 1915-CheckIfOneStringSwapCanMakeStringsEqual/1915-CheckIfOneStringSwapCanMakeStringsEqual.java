// Last updated: 4/24/2026, 10:31:24 AM
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;

        int count = 0;
        int idx1 = -1;
        int idx2 = -1;

        for(int i = 0; i<s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 != ch2){
                count++;
                if (count == 1) idx1 = i;
                else if (count == 2) idx2 = i;
                else return false;
            }
        }
        if(count == 0) return true;
        if(count != 2) return false;
        if(s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1)) return true;

        return false;
    }
}