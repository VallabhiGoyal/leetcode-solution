// Last updated: 4/24/2026, 10:30:14 AM
class Solution {
    public long removeZeros(long n) {
        long temp = 0;
        while(n>0){
            long remain = n%10;
            if(remain!=0){
                temp = temp*10 + remain;
            }
            n=n/10;
        }
        long reverse =0;
        while(temp>0){
            long remain = temp%10;
            reverse = reverse*10 + remain;
            temp = temp/10;
        }
        return reverse;
    }
}