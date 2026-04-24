// Last updated: 4/24/2026, 10:35:42 AM
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}