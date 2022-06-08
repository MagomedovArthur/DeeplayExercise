package io.deeplay;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Вычисление кратчайшего пути через алгоритм Дейкстры.
 *
 * @return Кратчайший путь до конца
 */
public class ShortestPath {

    private static final int ROW_ID = 0;
    private static final int COL_ID = 1;
    private final int shortestDistance;

    public ShortestPath(int[][] matrix) {
        shortestDistance = findShortestPathLength(matrix);
    }

    private int findShortestPathLength(int[][] matrix) {
        final int rowCount = matrix.length;
        if (rowCount == 0) return 0;
        final int colCount = matrix[0].length;
        if (colCount == 0) return 0;
        final boolean[][] visited = new boolean[rowCount][colCount];
        final int[][] distances = new int[rowCount][colCount];
        for (int r = 0; r < rowCount; ++r) {
            for (int c = 0; c < colCount; ++c) {
                distances[r][c] = Integer.MAX_VALUE;
            }
        }
        final Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(lhs -> distances[lhs[0]][lhs[1]]));
        distances[0][0] = 0;
        queue.add(new int[]{0, 0});
        final int lastRow = rowCount - 1;
        final int lastCol = colCount - 1;
        while (!queue.isEmpty()) {
            final int[] vertex = queue.remove();
            final int row = vertex[ROW_ID];
            final int col = vertex[COL_ID];
            if (row == lastRow && col == lastCol) {
                break;
            }
            visited[row][col] = true;
            relax(queue, matrix, visited, distances, row + 1, col, lastRow, lastCol, distances[row][col]);
            relax(queue, matrix, visited, distances, row - 1, col, lastRow, lastCol, distances[row][col]);
            relax(queue, matrix, visited, distances, row, col + 1, lastRow, lastCol, distances[row][col]);
            relax(queue, matrix, visited, distances, row, col - 1, lastRow, lastCol, distances[row][col]);
        }
        return distances[lastRow][lastCol];
    }

    private void relax(
            Queue<int[]> queue,
            int[][] matrix,
            boolean[][] visited,
            int[][] distances,
            int nextRow,
            int nextCol,
            int lastRow,
            int lastCol,
            int distance
    ) {
        if (nextRow < 0 || nextRow > lastRow) return;
        if (nextCol < 0 || nextCol > lastCol) return;
        if (visited[nextRow][nextCol]) return;
        final int nextDistance = distance + matrix[nextRow][nextCol];
        if (nextDistance < distances[nextRow][nextCol]) {
            distances[nextRow][nextCol] = nextDistance;
            queue.add(new int[]{nextRow, nextCol});
        }
    }

    public int getShortestDistance() {
        return shortestDistance;
    }
}