// Last updated: 4/24/2026, 10:31:50 AM
class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        int  i = sb.length()-1;
        while(sb.length() > 1){
            if(sb.charAt(i) == '0'){
                sb = sb.deleteCharAt(i);
                i--;
            }else{
                int j = i;
                int carry = 0;
                while(j>=0 && sb.charAt(j) =='1'){
                    sb.setCharAt(j, '0');
                    j--;
                }
                if(j >= 0){
                    sb.setCharAt(j, '1');
                }else{
                    sb.insert(0, '1');
                    i = sb.length()-1;
                }
            }
            count++;
        }

        return count;
    }
}