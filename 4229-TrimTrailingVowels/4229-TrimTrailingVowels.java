// Last updated: 4/24/2026, 10:29:38 AM
class Solution {
    public String trimTrailingVowels(String s) {
        int i = s.length();
        for(i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') continue;
            break;
        }

        return s.substring(0,i+1);
    }
}