// Last updated: 4/24/2026, 10:32:55 AM
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int a = image.length;
        int b = image[0].length;

        for(int i = 0; i<a; i++){
            for(int j = 0; j<=(b-1)/2; j++){
                int temp = image[i][j];
                image[i][j] = image[i][b-j-1]^1;
                image[i][b-j-1] = temp^1;
            }
        }
        return image;
    }
}