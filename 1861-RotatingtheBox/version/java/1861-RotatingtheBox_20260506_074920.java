// Last updated: 5/6/2026, 7:49:20 AM
1class Solution {
2    public char[][] rotateTheBox(char[][] boxGrid) {
3        int m = boxGrid.length;
4        int n = boxGrid[0].length;
5
6        char[][] rotated = new char[n][m];
7
8        for(int i = 0; i<m; i++){
9            int empty = n-1;
10            for(int j = n-1; j>=0; j--){
11                char curr = boxGrid[i][j];
12                if(curr == '*'){
13                    empty = j-1;
14                }else if(curr == '#'){
15                    boxGrid[i][j] = '.';
16                    boxGrid[i][empty] = '#';
17                    empty--;
18                }
19            }
20        }
21
22        for(int i = 0; i<m; i++){
23            for(int j = 0; j<n; j++){
24                rotated[j][m-1-i] = boxGrid[i][j];
25            }
26        }
27
28        return rotated;
29    }
30}