// Last updated: 4/24/2026, 10:29:39 AM
class Solution {
    private static final int[] FACT = {
        1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880
    };
    public boolean isDigitorialPermutation(int n) {
        int result = 0;
        int temp = n;
        int[] countN = new int[10];
        
        while(temp>0){
            int digit = temp%10;
            countN[digit]++;
            result += FACT[digit];
            temp /= 10;
        }
        
        int[] countR = new int[10];
        while(result > 0){
            int digit = result % 10;
            countR[digit]++;
            result /= 10;
        }

        for(int i = 0; i<10; i++){
            if(countN[i]!= countR[i]) return false;
        }

        return true;
    }
}