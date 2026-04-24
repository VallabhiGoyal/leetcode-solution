// Last updated: 4/24/2026, 10:33:16 AM
class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();

        int min = 0;
        int max = 0;

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                min++;
                max++;
            }
            else if(ch == ')'){
                if(min > 0) min--;
                max--;
                if(max < 0) return false;
            }else{
                if(min > 0) min--;
                max++;
            }
        }

        return min == 0;
    }
}