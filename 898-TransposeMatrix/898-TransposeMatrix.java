// Last updated: 4/24/2026, 10:32:52 AM
import java.util.*;
class Solution {
    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] trans = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                trans[i][j] = matrix[j][i];
            }   
        }
        return trans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of rows and cols");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        System.out.println("enter the elements of the array");
        for(int i =0; i<n; i++){
            for(int j = 0;j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Transpose");
        int[][] transposed = transpose(arr);
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }

    }
}