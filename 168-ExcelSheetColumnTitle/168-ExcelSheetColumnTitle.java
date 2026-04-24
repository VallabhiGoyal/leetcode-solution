// Last updated: 4/24/2026, 10:35:22 AM
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str  = new StringBuilder();
        while(columnNumber > 0){
            int remain = columnNumber % 26;
            if(remain == 0){
                remain = 26;
                columnNumber--;
            }
            char ch = (char)('A' + remain - 1);
            str.append(ch);
            columnNumber /= 26;
        }

        return str.reverse().toString();
    }
}