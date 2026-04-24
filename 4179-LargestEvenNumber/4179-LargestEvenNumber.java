// Last updated: 4/24/2026, 10:29:51 AM
class Solution {
    public String largestEven(String s) {

        int last = -1;
        for(int i = s.length() - 1; i>=0; i--){
            if(s.charAt(i) == '2') {
                last = i;
                break;
            }
        }

        if(last == -1) return "";

        return s.substring(0, last + 1);
    }
}