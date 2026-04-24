// Last updated: 4/24/2026, 10:33:11 AM
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int a = image.length;
        int b = image[0].length;

        int curr = image[sr][sc];
        if(curr == color) return image;
        image[sr][sc] = color;
        

        if(sr>0 && image[sr-1][sc] == curr){
            //sr-1
            floodFill(image, sr-1, sc, color);
        }

        if(sr<a-1 && image[sr+1][sc] == curr){
            //sr+1
            floodFill(image, sr+1, sc, color);
        }

        if(sc>0 && image[sr][sc-1] == curr){
            //sc-0
            floodFill(image, sr, sc-1, color);
        }

        if(sc<b-1 && image[sr][sc+1] == curr){
            //sc+1
            floodFill(image, sr, sc+1, color);
        }
        return image;
    }
}