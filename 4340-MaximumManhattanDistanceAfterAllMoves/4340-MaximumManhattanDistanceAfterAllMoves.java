// Last updated: 7/3/2026, 11:34:31 AM
class Solution {
    public int maxDistance(String moves) {
        int n = moves.length();

        int ans = 0;
        int x = 0;
        int y = 0;
        int extra = 0;
        
        for(int i = 0; i<n; i++){
            char ch = moves.charAt(i);
            
            if(ch == 'U'){
                y++;
            }else if(ch == 'D'){
                y--;
            }else if(ch == 'L'){
                x--;
            }else if(ch == 'R'){
                x++;
            }else extra++;
        }

        ans = Math.abs(x) + Math.abs(y);

        return ans + extra;
    }
}