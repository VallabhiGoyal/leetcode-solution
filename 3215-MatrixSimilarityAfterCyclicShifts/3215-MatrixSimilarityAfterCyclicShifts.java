// Last updated: 4/24/2026, 10:30:39 AM
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int a = mat.length;
        int b = mat[0].length;
        if(k%b == 0) return true;
        
        k = k % b ;

        int[][] answer = new int[a][b];
        for(int i = 0; i<a; i++){
            if(i%2 == 0){
                for(int j = 0; j<b; j++){
                    answer[i][j] = mat[i][(j-k+b)%b];
                }
                
            }else{
                for(int j = 0; j<b; j++){
                    answer[i][j] = mat[i][(j+k)%b];
                }
            }
        }

        for(int i = 0; i<a; i++){
            for(int j = 0; j<b; j++){
                if(answer[i][j] != mat[i][j]) return false;
            }
        }

        return true;
    }
}