// Last updated: 7/3/2026, 11:35:00 AM
class Solution {
    public boolean validDigit(int n, int x) {
        boolean flag = false;
        while(n>9){
            int remain = n % 10;
            if(remain == x) flag = true;
            n/=10;
        }
        if(n == x) flag = false;
        return flag;
    }
}