// Last updated: 7/10/2026, 6:55:00 PM
class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();

        StringBuilder sb1 = new StringBuilder(s1);
        int op = 0;
        
        for(int i = 0; i<n; i++){
            if(sb1.charAt(i) == s2.charAt(i)) continue;

            if(sb1.charAt(i) == '0'){
                op++;
                sb1.setCharAt(i, '1');
            }else{
                if(i<n-1){
                    if(sb1.charAt(i+1) == '1'){
                        op++;
                        sb1.setCharAt(i, '0');
                        sb1.setCharAt(i+1, '0');
                    }else{
                        op += 2;
                        sb1.setCharAt(i, '0');
                    }
                }else if(i > 0){
                    op += 2;
                    sb1.setCharAt(i, '0');
                }else return -1;
            }
        }

        return s2.equals(sb1.toString()) ? op : -1;
    }
}