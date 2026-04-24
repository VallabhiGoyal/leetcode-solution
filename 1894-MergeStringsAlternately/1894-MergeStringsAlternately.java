// Last updated: 4/24/2026, 10:31:26 AM
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int a = word1.length();
        int b = word2.length();

        int i = 0;
        int j = 0;

        StringBuilder str = new StringBuilder();
        while(i<a && j<b){
            str.append(word1.charAt(i++));
            str.append(word2.charAt(j++));
        }

        if(i!=a) str.append(word1, i, a);
        else if(j!=b) str.append(word2, j, b);

        return str.toString();
    }
}