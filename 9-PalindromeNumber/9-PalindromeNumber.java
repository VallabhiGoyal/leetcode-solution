// Last updated: 4/24/2026, 10:37:10 AM
class Solution {
    public boolean isPalindrome(int x) {
        int y = x, p = 0;
        while(x>0){
            int remain = x%10;
            x=x/10;
            p = p*10 + remain;
        }
        if(p<0){
            return false;
        }
        if(y==p){
            return true;
        }
        return false;
    }
}