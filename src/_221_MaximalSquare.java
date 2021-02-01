/**
 * 221. Maximal Square
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class _221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int n=1;
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length && i<matrix.length;j++){

                if(matrix[i][j] == '1'){
                    n = exploreMatrix(i,j,matrix);
                    max = Math.max(n*n,max);
                }
            }
        }
        return max;
    }

    int exploreMatrix(int x,int y,char[][] m){

        int n=1;
        while(true){

            if(x+n >= m.length || y+n >= m[0].length){
                return n;
            }

            if(m[x+n][y] == '1' && m[x][y+n] == '1' && m[x+n][y+n] == '1'){
                for(int j=y+1;j<y+n;j++){
                    if(m[x+n][j] != '1'){
                        return n;
                    }
                }

                for(int j=x+1;j<x+n;j++){
                    if(m[j][y+n] != '1'){
                        return n;
                    }
                }

                n++;
            }else{
                return n;
            }

        }
    }

    public int maximalSquare2(char[][] matrix) {

        int cols = matrix[0].length;
        int rows = matrix.length;
        int maxsqlen=0;
        int up,left,dia;

        int [][]dpMatrix = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(matrix[i][j] == '0'){
                    dpMatrix[i][j] = 0;
                }else{

                    up = i==0?0:dpMatrix[i - 1][j];
                    left = j==0?0:dpMatrix[i][j - 1];
                    dia = (i==0 || j==0)?0:dpMatrix[i - 1][j - 1];

                    dpMatrix[i][j] = Math.min(Math.min(up, left), dia) + 1;
                    maxsqlen = Math.max(maxsqlen, dpMatrix[i][j]);
                }
            }

        }
        return maxsqlen*maxsqlen;
    }


    public class Solution {
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
            int[][] dp = new int[rows + 1][cols + 1];
            int maxsqlen = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    if (matrix[i-1][j-1] == '1'){
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                        maxsqlen = Math.max(maxsqlen, dp[i][j]);
                    }
                }
            }
            return maxsqlen * maxsqlen;
        }
    }

}
