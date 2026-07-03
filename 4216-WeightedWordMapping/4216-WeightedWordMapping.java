// Last updated: 7/3/2026, 11:35:22 AM
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            String curr = words[i];
            int len = curr.length();

            int currWeight = 0;

            for(int j = 0; j<len; j++){
                int currIdx = curr.charAt(j) - 'a';

                currWeight += weights[currIdx];
            }

            char req;
            if(currWeight % 26 != 0){
                currWeight %= 26;
                req = (char)(26-currWeight + 'a' - 1);
            }else{
                currWeight = 26;
                req = 'z';
            }
            
            sb.append(req);
        }

        return sb.toString();
    }
}