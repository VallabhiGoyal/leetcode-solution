// Last updated: 4/24/2026, 10:31:56 AM
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] answer = new int[k];

        int a = mat.length;
        int b = mat[0].length;

        int[][] strength = new int[a][2];
        for(int i = 0; i<a; i++){
            strength[i][1] = i;
            for(int j = 0; j<b; j++){
                if(mat[i][j] == 1){
                    strength[i][0]++;
                }
            }
        }

        Arrays.sort(strength, (row1, row2) -> {
            if(row1[0] != row2[0]) return row1[0] - row2[0];
            else return row1[1] - row2[1];
        });

        for(int i = 0; i<k; i++){
            answer[i] = strength[i][1];
        }

        return answer;
    }
}