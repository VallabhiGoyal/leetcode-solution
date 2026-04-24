// Last updated: 4/24/2026, 10:30:45 AM
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();

        int[] even = new int[26];
        int[] odd = new int[26];

        for(int i = 0; i < n; i++){
            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';
            if(i % 2 == 0){
                even[idx1]++;
                even[idx2]--;
            } else {
                odd[idx1]++;
                odd[idx2]--;
            }
        }

        for(int i = 0; i<26; i++){
            if((even[i] < 0) || (odd[i] < 0)) return false;
        }
        

        return true;
    }
}