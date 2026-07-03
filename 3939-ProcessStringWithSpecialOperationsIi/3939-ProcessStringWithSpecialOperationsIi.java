// Last updated: 7/3/2026, 11:36:24 AM
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long len = 0;

        for(int i = 1; i<=n; i++){
            char ch = s.charAt(i-1);

            if(ch >= 'a' && ch <= 'z'){
                len += 1;
            }else if(ch == '*'){
                if(len > 0) len -= 1;
            }else if(ch == '#'){
                len <<= 1;
            }
        }

        if(k >= len) return '.';

        for(int i = n-1; i>=0; i--){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                len -= 1;
                if(k == len){
                    return ch;
                }
            }else if(ch == '*'){
                len += 1;
            }else if(ch == '#'){
                len /= 2;
                if(k >= len){
                    k -= len;
                }
            }else{
                k = len - 1 - k;
            }
        }

        return '.';
    }
}