package dsa_revision.graph.medium;

class Pair {

  int r;
  int c;

  Pair(int row, int col) {
    r = row;
    c = col;
  }
}

class FloodFill {

  public void dfs(int[][] image, int sr, int sc, int color, boolean[][] vis) {
    Queue<Pair> q = new LinkedList<>();
    int matchColor = image[sr][sc];
    vis[sr][sc] = true;
    image[sr][sc] = color;
    q.offer(new Pair(sr, sc));
    int m = image.length;
    int n = image[0].length;

    while (!q.isEmpty()) {
      Pair p = q.poll();

      int idx[][] = {
        { p.r, p.c + 1 },
        { p.r, p.c - 1 },
        { p.r - 1, p.c },
        { p.r + 1, p.c },
      };

      for (int i = 0; i < idx.length; i++) {
        int iRow = idx[i][0];
        int iCol = idx[i][1];
        if (
          iRow >= 0 &&
          iRow < m &&
          iCol >= 0 &&
          iCol < n &&
          !vis[iRow][iCol] &&
          image[iRow][iCol] == matchColor
        ) {
          image[iRow][iCol] = color;
          vis[iRow][iCol] = true;
          q.offer(new Pair(iRow, iCol));
        }
      }
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean[][] vis = new boolean[image.length][image[0].length];

    dfs(image, sr, sc, color, vis);

    return image;
  }
}
