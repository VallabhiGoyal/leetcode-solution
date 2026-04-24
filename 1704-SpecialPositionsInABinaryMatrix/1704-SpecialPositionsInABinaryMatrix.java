// Last updated: 4/24/2026, 10:31:37 AM
class Solution {
    public int numSpecial(int[][] mat) {
        int a = mat.length;
        int b = mat[0].length;

        int count = 0;
        int[] row = new int[a];
        int[] col = new int[b];

        for(int i = 0; i<a; i++){
            for(int j = 0; j<b; j++){
                if(mat[i][j] == 1){
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }

        for(int i = 0; i<a; i++){
            if(row[i] == 1){
                for(int j = 0; j<b; j++){
                    if(col[j] == 1 && mat[i][j] == 1){
                        count++;
                        break;
                    }
                }
            }
        }

        return count;

    }
}