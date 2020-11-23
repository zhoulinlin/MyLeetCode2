/**
 * 200. Number of Islands
 *
 *Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 */
public class _200_Number_ofIslands {

    public int numIslands(char[][] grid) {
    boolean[][] visitTable = new boolean[grid.length][grid[0].length];

    int islandCounter = 0;
        for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(!visitTable[i][j] && grid[i][j] == '1'){
                islandCounter++;
                visitNeighs(i,j,visitTable,grid);
            }
        }
    }

        return islandCounter;
}

    void visitNeighs(int i,int j,boolean[][] visitTable,char[][] grid){

        if(!visitTable[i][j]){
            visitTable[i][j] = true;

            if(i + 1 < grid.length && grid[i+1][j] == '1'){
                visitNeighs(i+1,j,visitTable,grid);
            }

            if(i - 1 >= 0 && grid[i - 1][j] == '1'){
                visitNeighs(i-1,j,visitTable,grid);
            }

            if(j + 1 < grid[0].length && grid[i][j+1] == '1'){
                visitNeighs(i,j+1,visitTable,grid);
            }

            if(j - 1 >= 0 && grid[i][j - 1] == '1'){
                visitNeighs(i,j-1,visitTable,grid);
            }
        }
    }

}
