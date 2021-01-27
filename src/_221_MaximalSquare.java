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
                break;
            }

            if(m[x+n][y] == '1' && m[x][y+n] == '1' && m[x+n][y+n] == '1'){
                n++;
            }else{
                break;
            }

        }
        return n;
    }

}
