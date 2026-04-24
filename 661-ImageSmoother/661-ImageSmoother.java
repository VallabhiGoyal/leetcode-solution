// Last updated: 4/24/2026, 10:33:21 AM
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int a = img.length;
        int b = img[0].length;

        int[][] result = new int[a][b];
        for(int i = 0; i<a; i++){
            
            for(int j = 0; j<b; j++){
                int count = 0;
                int sum = 0;
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        if (r >= 0 && r < a && c >= 0 && c < b) {
                            sum += img[r][c];
                            count++;
                        }
                    }
                }

                //average
                result[i][j] = sum/count;
            }
        }

        return result;
    }
}