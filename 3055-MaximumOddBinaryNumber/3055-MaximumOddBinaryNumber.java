// Last updated: 7/3/2026, 11:36:51 AM
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();

        int countZero = 0;

        for(int i = 0; i<n; i++){
            int ch = s.charAt(i) - '0';
            if(ch == 0) countZero++;
        }

        int countOne = n - countZero;
        StringBuilder sb = new StringBuilder();

        while(countOne > 1){
            sb.append("1");
            countOne--;
        }

        
        while(countZero > 0){
            sb.append("0");
            countZero--;
        }

        sb.append("1");

        return sb.toString();        
    }
}