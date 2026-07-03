// Last updated: 7/3/2026, 11:35:40 AM
class Solution {
    public int totalWaviness(int num1, int num2) {
        if(num2 < 100) return 0;

        int count = 0;

        for(int i = num1; i <= num2; i++){
            String str = String.valueOf(i);

            int len = str.length();

            for(int j = 1; j<len-1; j++){
                char curr = str.charAt(j);
                char prev = str.charAt(j-1);
                char next = str.charAt(j+1);

                if(curr > next && curr > prev) count++;
                else if(curr < next && curr < prev) count++;
            }
        }


        return count;
    }

}