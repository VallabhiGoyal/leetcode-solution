// Last updated: 4/24/2026, 10:36:18 AM
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int maxRectangle = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        for(int i = 0; i<rows; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j<cols; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;    
            }
            maxRectangle = Math.max(maxRectangle, getMaxArea(heights, stack));
        }
        return maxRectangle;
    }

    private int getMaxArea(int[] heights, Stack<Integer> stack){
        int maxArea = 0;

        for(int j = 0; j<heights.length; j++){
            
            while(!stack.isEmpty() && heights[j]<=heights[stack.peek()]){
                int poppedIndex = stack.pop();
                int height = heights[poppedIndex];
                int width = stack.isEmpty()? j : j - stack.peek() - 1;
                maxArea = Math.max(maxArea, width*height);
            }
            stack.push(j);
        }

        while(!stack.isEmpty()){
            int poppedIndex = stack.pop();
            int height = heights[poppedIndex];
            int width = stack.isEmpty()? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, width*height);
        }

        return maxArea;
    }
}