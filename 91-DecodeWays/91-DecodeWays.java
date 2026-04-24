// Last updated: 4/24/2026, 10:36:13 AM
class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if(s.charAt(0) == '0') return 0;

        int t0 = 1;
        int t1 = 1;

        for(int i = 1; i<n; i++){
            int ans = 0;

            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if(curr != '0'){
                ans += t1;
            }

            if(prev == '1' || (prev == '2' && curr <= '6')){
                ans += t0;
            }


            if(ans == 0) return 0;

            t0 = t1;
            t1 = ans;
        }    

        return t1;    
    }
}