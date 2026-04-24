// Last updated: 4/24/2026, 10:33:58 AM
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        int idx = 0;

        for(int i = 0; i<n; i++){
            int count = 1;
            char ch = chars[i];
            int j = i+1;

            while(j<n && ch == chars[j]){
                j++;
                count++;
            }
            i = j-1;
            chars[idx++] = ch;
            if(count > 1){
                String str = count + "";
                for(int a = 0; a<str.length(); a++){
                    chars[idx++] = str.charAt(a);
                }
            }
        }

        return idx;
    }
}