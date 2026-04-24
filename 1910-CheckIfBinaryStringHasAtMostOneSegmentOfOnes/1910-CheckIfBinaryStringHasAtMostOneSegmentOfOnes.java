// Last updated: 4/24/2026, 10:31:25 AM
class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            int j = i;
            if(ch == '1'){
                while(j<n-1 && s.charAt(j+1) == '1') j++;
                count++;
            }
            i = j;
            if(count > 1) return false;
        }
        return true;
    }
}