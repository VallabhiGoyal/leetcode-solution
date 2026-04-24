// Last updated: 4/24/2026, 10:37:14 AM
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;

        int maxLen = 0;
        String ans = new String();
        for(int i = 0; i<n; i++){

            //odd length
            int left = i;
            int right = i;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            int len = right - left - 1;
            if(len > maxLen){
                maxLen = len;
                ans = s.substring(left+1, right);
            }

            //even length
            left = i;
            right = i + 1;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            
            len = right - left - 1;
            if(len > maxLen){
                maxLen = len;
                ans = s.substring(left+1, right);
            }
        }

        return ans;
    }
}