// Last updated: 4/24/2026, 10:37:13 AM
class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n <= 2 || numRows == 1 || numRows == n) return s;

        StringBuilder str = new StringBuilder();

        int cycleLen = 2*(numRows-1);

        for(int i = 0; i<numRows; i++){
            if(i >= n) break;
            for(int j = i; j<n; j += cycleLen){

                //first char of each row
                str.append(s.charAt(j));

                //middle rows -> 2nd char
                if(i != 0 && i != numRows-1){
                    int len = cycleLen - 2*i;
                    if(j+len < n) str.append(s.charAt(j+len));
                }
            }
        }
        return str.toString();
    }
}