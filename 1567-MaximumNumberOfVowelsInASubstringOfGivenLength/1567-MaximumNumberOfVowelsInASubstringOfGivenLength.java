// Last updated: 4/24/2026, 10:31:46 AM
class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();

        int maxCount = 0;
        for(int i = 0; i<k; i++){
            if(isVowel(s.charAt(i))) maxCount++;
        }
        if(maxCount == k) return k;
        int count = maxCount;
        for(int i = 1; i<=n-k; i++){
            if(isVowel(s.charAt(i+k-1))) count++;
            if(isVowel(s.charAt(i-1))) count--;
            if(count > maxCount) maxCount = count;
            if(maxCount == k) return k;
        }

        return maxCount;
    }

    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        } 
        return false;
    }
}