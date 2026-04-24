// Last updated: 4/24/2026, 10:35:25 AM
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder str = new StringBuilder();
        for(int i = words.length-1; i>=0; i--){
            str.append(words[i]).append(" ");
        }
        return str.toString().trim();
    }
}