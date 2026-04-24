// Last updated: 4/24/2026, 10:34:14 AM
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = magazine.length();

        int[] ch = new int[26];
        for(int i = 0; i<n; i++){
            ch[magazine.charAt(i)-'a']++;
        }

        for(int i = 0; i<ransomNote.length(); i++){
            ch[ransomNote.charAt(i)-'a']--;
            if(ch[ransomNote.charAt(i)-'a']<0) return false;
        }

        return true;
    }
}