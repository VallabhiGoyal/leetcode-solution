// Last updated: 4/24/2026, 10:30:16 AM
class Solution {
    public String maximumXor(String s, String t) {
        int n = s.length();
        int[] tCount = new int[2];

        for(int i = 0; i<n; i++){
            if(t.charAt(i) == '0'){
                tCount[0]++;
            }else{
                tCount[1]++;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i<n; i++){
            int bit = s.charAt(i) - '0';
            int opposite = 1 - bit;
            if (tCount[opposite] > 0) {
                result.append('1');
                tCount[opposite]--;
            } else {
                result.append('0');
                tCount[bit]--;
            }
        }

        return result.toString();
    }
}