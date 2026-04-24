// Last updated: 4/24/2026, 10:34:08 AM
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n<=k) return "0";
        if(k == 0) return num;

        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));

        for(int i = 1; i<n; i++){
            char ch = num.charAt(i);
            while(k>0 && sb.length() > 0 && sb.charAt(sb.length()-1) > ch){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(ch);
        }
        while(k>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }

        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.toString();
    }
}