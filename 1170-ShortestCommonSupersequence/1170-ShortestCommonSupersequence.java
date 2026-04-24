// Last updated: 4/24/2026, 10:32:14 AM
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] t = new int[m+1][n+1];

        // build lcs table
        for(int i = 1; i<m+1; i++){
            for(int j = 1; j<n+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        // lcs
        StringBuilder scs = new StringBuilder();
        int i = m;
        int j = n;
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                scs.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(t[i-1][j] > t[i][j-1]){
                    scs.append(str1.charAt(i-1));
                    i--;
                }else{
                    scs.append(str2.charAt(j-1));
                    j--;
                }
            }
        }

        while(i > 0){
            scs.append(str1.charAt(i-1));
            i--;
        }

        while(j > 0){
            scs.append(str2.charAt(j-1));
            j--;
        }

        return scs.reverse().toString();
    }
}