// Last updated: 4/24/2026, 10:34:20 AM
class Solution {
    public String reverseVowels(String s) {
        int i = 0; 
        int j = s.length()-1;

        StringBuilder str = new StringBuilder(s);

        while(i<j){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            if(isVowel(ch1) && isVowel(ch2)){
                str.setCharAt(i++, ch2);
                str.setCharAt(j--, ch1);
            }
            if(!isVowel(ch1)) i++;
            if(!isVowel(ch2)) j--;
        }

        return str.toString();
    }

    private boolean isVowel(char i){
        if(i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' || i=='A' || i == 'E' || i=='O' || i=='U' || i=='I') return true;

        return false;
    }
}