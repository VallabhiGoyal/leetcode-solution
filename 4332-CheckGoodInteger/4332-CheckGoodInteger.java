// Last updated: 7/3/2026, 11:34:33 AM
class Solution {
    public boolean checkGoodInteger(int n) {
        long digitSum = 0;
        long squareSum = 0;

        while(n > 0){
            int remain = n % 10;
            digitSum += remain;
            squareSum += remain*remain;
            n /= 10;
        }

        return (squareSum - digitSum) >= 50;
    }
}