// Last updated: 7/3/2026, 11:36:28 AM
class Solution {
    public String processStr(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }else if(sb.length() >=1 && ch == '*'){
                sb.deleteCharAt(sb.length() - 1);
            }else if(ch == '#'){
                sb.append(sb);
            }else{
                sb.reverse();
            }
        }

        return sb.toString(); 
    }
}