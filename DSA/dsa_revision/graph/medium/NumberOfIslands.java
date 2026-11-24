package dsa_revision.graph.medium;

// https://leetcode.com/problems/number-of-islands/

class Pair{
    int r; 
    int c;
    Pair(int row, int col){
        r = row;
        c = col;
    }
}
public class NumberOfIslands {
   
    public void bfs(char[][] grid, int r, int c, boolean[][] vis){
      Queue<Pair> q = new LinkedList<>();
      vis[r][c] = true;
      q.add(new Pair(r,c));
      int m = grid.length;
      int n = grid[0].length;
     while(!q.isEmpty()){
        Pair p = q.poll(); 
        int idx[][] = {{p.r-1,p.c},{p.r+1, p.c},{p.r, p.c-1},{p.r,p.c+1}};
        for(int i=0; i<idx.length; i++){
            int iRow = idx[i][0];
            int iCol = idx[i][1];
            if(iRow>=0 &&  iRow<m && iCol>=0 && iCol<n && !vis[iRow][iCol] && grid[iRow][iCol]=='1'){
                vis[iRow][iCol]=true;
                q.add(new Pair(iRow, iCol));
            }
        }
     }       
    }

    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for(int row = 0; row<vis.length; row++){
            for(int col =0; col<grid[0].length; col++){
                if(!vis[row][col] && grid[row][col]=='1'){
                    bfs(grid, row, col, vis);  
                    cnt++;
                }
            }
        }
     return cnt;   
    }
}