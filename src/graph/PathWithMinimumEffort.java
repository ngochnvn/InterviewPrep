package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 * Use dirkstra to find minimum effort.
 * It is similar to shortest path but instead of keeping
 * distance, we maintain the maximum effort of the path
 *
 * High level of dirkstra is to maintain a priority queue of distance and
 * explore next using the queue.
 */
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int m = heights.length;
        int n = heights[0].length;
        int[][] result = new int[m][n];
        for (int[] row: result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        boolean [][] visited = new boolean[m][n];

        PriorityQueue<int[]> queue = new PriorityQueue<>(m+n, (x, y) -> Integer.compare(x[2],y[2]));
        queue.add(new int[]{0,0,0});
        result[0][0] = 0;
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];

            for (int[] direction: directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    int newVal = Math.max(result[x][y], Math.abs(heights[newX][newY] - heights[x][y]));
                    if (result[newX][newY] > newVal) {
                        result[newX][newY] = newVal;
                        queue.add(new int[]{newX, newY, newVal});
                    }
                }
            }
        }
        return result[m-1][n-1];
    }
}
