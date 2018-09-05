package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yangxiao on 2018/9/5.
 * desc:
 * https://leetcode.com/problems/flood-fill/description/
 */
public class FloodFill {
  public int[][] floodFill_dfs(int[][] image, int sr, int sc, int newColor) {
    //bfs
    Queue<int[]> queue = new LinkedList<>();
    int orgin = image[sr][sc];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int row = image.length;
    int col = image[0].length;
    image[sr][sc] = newColor;
    boolean[][] visited = new boolean[row][col];
    queue.offer(new int[]{sr, sc});
    while (!queue.isEmpty()) {
      int[] point = queue.poll();
      visited[point[0]][point[1]] = true;
      for (int i = 0; i < 4; i++) {
        int newX = point[0] + dx[i];
        int newY = point[1] + dy[i];
        if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY] || image[newX][newY] != orgin ) {
          continue;
        }
        image[newX][newY] = newColor;
        queue.offer(new int[]{newX, newY});
      }
    }
    return image;
  }

  public int[][] floodFill_bfs(int[][] image, int sr, int sc, int newColor) {
    dfs(image, image[sr][sc], sr, sc, newColor, image.length, image[0].length, new boolean[image.length][image[0].length]);
    return image;
  }
  public void dfs(int[][] image, int origin, int x, int y, int newColor, int row, int col, boolean[][] visited) {
    if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || image[x][y] != origin) {
      return;
    }
    visited[x][y] = true;
    image[x][y] = newColor;
    dfs(image, origin, x + 1, y, newColor, row, col, visited);
    dfs(image, origin, x - 1, y, newColor, row, col, visited);
    dfs(image, origin, x, y + 1, newColor, row, col, visited);
    dfs(image, origin, x, y - 1, newColor, row, col, visited);
  }
}
