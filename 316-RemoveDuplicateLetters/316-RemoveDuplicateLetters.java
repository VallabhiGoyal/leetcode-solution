// Last updated: 4/24/2026, 10:34:30 AM
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();

        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for(int i = 0; i<n; i++){
            int ch = s.charAt(i) - 'a';
            freq[ch]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            char currChar = s.charAt(i);
            int ch = currChar - 'a';
            freq[ch]--;

            if(visited[ch]) continue;

            while(sb.length() > 0){
                char lastChar = sb.charAt(sb.length()-1);
                int lastIdx = lastChar - 'a';

                if(lastChar > currChar && freq[lastIdx] > 0){
                    sb.deleteCharAt(sb.length()-1);
                    visited[lastIdx] = false;
                }else break;
            }

            sb.append(currChar);
            visited[ch] = true;
        }

        return sb.toString();
    }
}