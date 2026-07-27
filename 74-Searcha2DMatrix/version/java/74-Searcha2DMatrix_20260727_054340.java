// Last updated: 7/27/2026, 5:43:40 AM
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int row = matrix.length;
4        int col = matrix[0].length;
5
6        if(target < matrix[0][0] || target>matrix[row-1][col-1]) return false;
7        
8        for(int i = 0; i< row; i++){
9            if(target >= matrix[i][0] && target <= matrix [i][col-1]){
10                int start = 0;
11                int end = col-1;
12
13                while(start<=end){
14                    int mid = start + (end - start)/2;
15
16                    if(matrix[i][mid] == target) return true;
17                    else if(matrix[i][mid] < target){
18                        start = mid + 1;
19                    }else{
20                        end = mid-1;
21                    }
22                }
23            }
24        }
25
26        return false;
27    }
28}