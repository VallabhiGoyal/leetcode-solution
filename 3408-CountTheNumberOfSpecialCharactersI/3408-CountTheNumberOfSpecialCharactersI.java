// Last updated: 7/3/2026, 11:36:40 AM
class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        int count = 0;

        int[] small = new int[26];
        int[] big = new int[26];

        for(int i = 0; i<n; i++){
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if(small[ch - 'a'] == 1) continue;
                small[ch - 'a']++;
                if(small[ch - 'a'] == big[ch - 'a']) count++;
            }else{
                if(big[ch - 'A'] == 1) continue; 
                big[ch - 'A']++;
                if(small[ch - 'A'] == big[ch - 'A']) count++;
            }
        }

        return count;
    }
}