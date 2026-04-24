// Last updated: 4/24/2026, 10:29:58 AM
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        if(words.length <=1) return s;
        
        String first = words[0];
        int count = countVowels(first);
        
        for(int i = 1; i<words.length; i++){
            if(countVowels(words[i]) == count){
                words[i] = reverseWord(words[i]);
            }
        }

        String result = String.join(" ",words).trim();
        return result;
        
    }

    public int countVowels(String s){
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
        }
        return count;
    }

    public String reverseWord(String s){
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }
}