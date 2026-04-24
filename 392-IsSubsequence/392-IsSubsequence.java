// Last updated: 4/24/2026, 10:34:10 AM
class Solution {
    public boolean isSubsequence(String s, String t) {
        int a = s.length();
        int b = t.length();

        int i = 0;
        int j = 0;
        int count = 0;
        while(j<b && i<a){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == a;
    }
}